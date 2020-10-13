package upc.cm.repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import upc.cm.model.WaterUser;

@Repository
public interface WURe extends JpaRepository<WaterUser, Integer>, JpaSpecificationExecutor<WaterUser> {
}
