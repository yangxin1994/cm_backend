package upc.cm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import upc.cm.model.CommunityInfo;

@Repository
public interface CommunityRe extends JpaRepository<CommunityInfo, Integer>, JpaSpecificationExecutor<CommunityInfo> {
}
