package upc.cm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import upc.cm.model.CommunityInfo;
import upc.cm.model.SystemCollector;

@Repository
public interface CollectorRe extends JpaRepository<SystemCollector, Integer>, JpaSpecificationExecutor<SystemCollector> {
}
