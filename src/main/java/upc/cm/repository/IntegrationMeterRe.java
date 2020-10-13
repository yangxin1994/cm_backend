package upc.cm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import upc.cm.model.IntegrationMeter;
import upc.cm.model.SystemUser;

import java.util.List;

/**
 * 集合测试类
 * 2020、8、27
 */
@Repository
public interface IntegrationMeterRe extends JpaRepository<IntegrationMeter, Integer>, JpaSpecificationExecutor<SystemUser> {
        IntegrationMeter findIntegrationMeterByIntegrationMeterAccount(String meterNumber);
        List<IntegrationMeter> findIntegrationMeterByIntegrationMeterCollectorId(String collectorId);
        }
