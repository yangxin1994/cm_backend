package upc.cm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class SystemCollector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int collectorId;

    private String collectorNote;

    private String contactOne;

    private String onePhone;

    private String contactTwo;

    private String twoPhone;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(referencedColumnName = "concentratorId")
    private SystemConcentrator systemConcentrator;

    @JsonIgnore
    @OneToMany(mappedBy = "systemCollector")
    private Set<WaterMeter> waterMeters = new HashSet<>();

    @Override
    public String toString() {
        return "SystemCollector{" +
                "collectorId=" + collectorId +
                ", collectorNote='" + collectorNote + '\'' +
                ", contactOne='" + contactOne + '\'' +
                ", onePhone='" + onePhone + '\'' +
                ", contactTwo='" + contactTwo + '\'' +
                ", twoPhone='" + twoPhone + '\'' +
                '}';
    }
}
