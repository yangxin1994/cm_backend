package upc.cm.controller;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import upc.cm.model.IntegrationMeter;
import upc.cm.model.OnlineDevice;
import upc.cm.repository.IntegrationMeterRe;
import upc.cm.repository.OnlineDeviceRe;
import upc.cm.utils.AjaxResult;
import upc.cm.utils.HttpClient;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by cheny on 2020/08/27
 */
@RestController
@RequestMapping("/integrationTest")
public class IntegrationController {
    @Autowired
    IntegrationMeterRe integrationMeterRe;
    @Autowired
    OnlineDeviceRe onlineDeviceRe;
    // midWare
    @Async
    @GetMapping("singleReceive")
    public Object singleReceive(
            @RequestParam String  meterNumber,
            @RequestParam String  reading
    ){
        System.out.println("----------------------------------");
        System.out.println(new Date().toString());
        System.out.println("水表" + meterNumber);
        System.out.println("读数" + reading);
        IntegrationMeter integrationMeter =  integrationMeterRe.findIntegrationMeterByIntegrationMeterAccount(meterNumber);
        if(integrationMeter == null)
            return AjaxResult.error("查无此表");
        double tem =Integer.valueOf(reading);
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        integrationMeter.setTime(formatter.format(date).toString());
        integrationMeter.setMeterNumber(tem/100);
        integrationMeterRe.save(integrationMeter);
        System.out.println("已经插入数据库");
        return AjaxResult.success();
    }
    //web front
    @GetMapping("singleCommandSend")
    public Object singleCommandSend(
            @RequestParam String  meterNumber
    ) throws IOException {
       String temMeterNumber = meterNumber;
       IntegrationMeter integrationMeter =  integrationMeterRe.findIntegrationMeterByIntegrationMeterAccount(temMeterNumber);
       if(integrationMeter == null)
           return AjaxResult.error("查无此表");
       if(!onlineDeviceRe.existsAllByOnlineDevice(integrationMeter.getIntegrationMeterConcentratorId()))
            return AjaxResult.error("设备不在线");
       new Thread(new Runnable() {
           @SneakyThrows
           @Override
           public void run() {
               String url = "http://127.0.0.1:10002/midWare/singleMeterQuery?concentrator="
                       + integrationMeter.getIntegrationMeterConcentratorId()
                       + "&collector=" + integrationMeter.getIntegrationMeterCollectorId()
                       + "&meter=" + integrationMeter.getIntegrationMeterAccount();
               HttpClient.sendGetRequest(url);
               System.out.println("命令已下发");
           }
       }).run();

       return AjaxResult.success();
    }

    //web front
    @GetMapping("singleQueryFromDb")
    public Object singleQueryFromDb(
            @RequestParam String meterAccount
    ){
        IntegrationMeter integrationMeter =  integrationMeterRe.findIntegrationMeterByIntegrationMeterAccount(meterAccount);
        if(integrationMeter == null)
            return AjaxResult.error("查无此表");
        return integrationMeter.getMeterNumber();
    }
    @GetMapping("clearQuery")
    public Object clearQuery() throws IOException {
        String url = "http://127.0.0.1:10002/midWare/clearQuery";
        HttpClient.sendGetRequest(url);
        return AjaxResult.success("清空命令已發送");
    }
    //web front

    @GetMapping("multipleCommandSend")
    public Object multipleCommandSend(
            @RequestParam String collectorId
    ){
        int batchNumber = 3;
        List<IntegrationMeter> integrationMeters =
                integrationMeterRe.findIntegrationMeterByIntegrationMeterCollectorId(collectorId);
        if(integrationMeters.size()==0){
            return AjaxResult.error("查无此表");
        }
        new Thread(new Runnable(){
            @SneakyThrows
            public void run(){
                // run方法具体重写
                for(int tem = 0; tem < integrationMeters.size(); tem++){
                    singleCommandSend(integrationMeters.get(tem).getIntegrationMeterAccount());
                    Thread.sleep(1000*10);
                }
            }}).run();
        return AjaxResult.success();
    }

    //
    @GetMapping("addOnlineDevice")
    public Object addOnlineDevice(
            @RequestParam String deviceNumber
    ){
        System.out.println(onlineDeviceRe.existsAllByOnlineDevice(deviceNumber));
        if(onlineDeviceRe.existsAllByOnlineDevice(deviceNumber)){
            return AjaxResult.success("数据库已更新");
        }
        OnlineDevice onlineDevice = new OnlineDevice();
        onlineDevice.setOnlineDevice(deviceNumber);
        onlineDeviceRe.save(onlineDevice);
        return AjaxResult.success();
    }
    @Transactional
    @GetMapping("deleteOnlineDevice")
    public Object deleteOnlineDevice(
            @RequestParam String deviceNumber
    ){
        onlineDeviceRe.deleteAllByOnlineDevice(deviceNumber);
        return AjaxResult.success();
    }

    @GetMapping("getOnlineDevice")
    public Object getOnlineDevice(
    ){

        return onlineDeviceRe.findAll();
    }

}
