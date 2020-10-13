package upc.cm.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by cheny on 2020/09/06
 */
@Entity
@Data
public class OnlineDevice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int autoId;

    private String onlineDevice;
}
