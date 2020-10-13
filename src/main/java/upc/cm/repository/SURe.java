package upc.cm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import upc.cm.model.SystemConcentrator;
import upc.cm.model.SystemUser;

import java.util.List;

@Repository
public interface SURe extends JpaRepository<SystemUser, Integer>, JpaSpecificationExecutor<SystemUser> {
    SystemUser findFirstByUserAccount(String userAccount);
}
