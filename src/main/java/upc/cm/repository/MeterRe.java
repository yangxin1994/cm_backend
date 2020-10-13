package upc.cm.repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import upc.cm.model.WaterMeter;

@Repository
public interface MeterRe extends JpaRepository<WaterMeter, Integer>, JpaSpecificationExecutor<WaterMeter> {
}
