package upc.cm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.cm.model.OnlineDevice;


/**
 * Created by cheny on 2020/09/06
 */
public interface OnlineDeviceRe extends JpaRepository<OnlineDevice, Integer> {
    int deleteAllByOnlineDevice(String deviceNumber);
    boolean existsAllByOnlineDevice(String deviceNumber);

}
