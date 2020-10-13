package upc.cm.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Setter
@Getter
public class SystemLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int logId;

    private String operationType;

    private Time operateTime;

    @ManyToOne
    @JoinColumn(referencedColumnName = "suId")
    private SystemUser systemUser;

    @Override
    public String toString() {
        return "SystemLog{" +
                "logId=" + logId +
                ", operationType='" + operationType + '\'' +
                ", operateTime=" + operateTime +
                '}';
    }
}
