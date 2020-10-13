package upc.cm.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Getter
@Setter
public class WaterMeter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int meterId;

    private Time createTime;

    private double currentReading;

    @ManyToOne
    @JoinColumn(referencedColumnName = "collectorId")
    private SystemCollector systemCollector;

    @OneToOne
    private WaterUser waterUser;

    @Override
    public String toString() {
        return "WaterMeter{" +
                "meterId=" + meterId +
                ", createTime=" + createTime +
                ", currentReading=" + currentReading +
                '}';
    }
}
