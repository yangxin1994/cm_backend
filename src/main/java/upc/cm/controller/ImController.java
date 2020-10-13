package upc.cm.controller;

import com.alibaba.excel.EasyExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import upc.cm.model.IntegrationMeter;
import upc.cm.repository.IntegrationMeterRe;
import upc.cm.utils.AjaxResult;
import upc.cm.utils.ImListener;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@RestController
public class ImController {
    @Autowired
    IntegrationMeterRe integrationMeterRe;

    @RequestMapping(value = "/meterImport", method = RequestMethod.POST)
    public Object uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        try {
            EasyExcel.read(file.getInputStream(), IntegrationMeter.class, new ImListener(integrationMeterRe)).sheet().doRead();
            return AjaxResult.success();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return AjaxResult.error("数据有重复");
        }
    }

    @GetMapping("/meterDownload")
    public void download(HttpServletResponse response) throws IOException {
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("测试", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        List<IntegrationMeter> list = integrationMeterRe.findAll();
        EasyExcel.write(response.getOutputStream(), IntegrationMeter.class).sheet("数据").doWrite(list);
    }
}