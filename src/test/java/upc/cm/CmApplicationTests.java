package upc.cm;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import upc.cm.model.*;
import upc.cm.repository.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@RunWith(SpringRunner.class)

@EnableAutoConfiguration
@SpringBootTest(classes = {CmApplication.class})
// 指定启动类
class CmApplicationTests {
    @Autowired
    WURe wuRe;

    @Autowired
    MeterRe meterRe;

    @Autowired
    CollectorRe collectorRe;

    @Autowired
    CommunityRe communityRe;

    @Autowired
    ConcentratorRe concentratorRe;

    @Test
    void contextLoads() {
//        SystemCollector systemCollector = collectorRe.findById(1).get();

        Log log = LogFactory.getLog("test");
        log.info("start");

        CommunityInfo communityInfo = new CommunityInfo();
        communityRe.save(communityInfo);
        SystemConcentrator systemConcentrator = new SystemConcentrator();
        concentratorRe.save(systemConcentrator);
        SystemCollector systemCollector = new SystemCollector();
        collectorRe.save(systemCollector);

        communityInfo.getSystemConcentrators().add(systemConcentrator);
        systemConcentrator.setCommunityInfo(communityInfo);

        systemConcentrator.getSystemCollectors().add(systemCollector);
        systemCollector.setSystemConcentrator(systemConcentrator);

        communityRe.save(communityInfo);

        concentratorRe.save(systemConcentrator);

        collectorRe.save(systemCollector);
        log.info("over");

//        WaterMeter waterMeter = new WaterMeter();
//        waterMeter.setSystem_collector(systemCollector);
//        wuRe.save(waterUser);
//        meterRe.save(waterMeter);
//        waterUser.setWater_meter(waterMeter);
//        waterMeter.setWater_user(waterUser);
//        wuRe.save(waterUser);
//        meterRe.save(waterMeter);
//

        System.out.println("ok");


    }

}


