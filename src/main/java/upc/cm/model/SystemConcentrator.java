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
public class SystemConcentrator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int concentratorId;

    private String concentratorAccount;

    private String concentratorNote;

    private String contactOne;

    private String onePhone;

    private String contactTwo;

    private String twoPhone;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(referencedColumnName = "communityId")
    private CommunityInfo communityInfo;

    @JsonIgnore
    @OneToMany(mappedBy = "systemConcentrator")
    private Set<SystemCollector> systemCollectors = new HashSet<>();

    @Override
    public String toString() {
        return "SystemConcentrator{" +
                "concentratorId=" + concentratorId +
                ", concentratorAccount='" + concentratorAccount + '\'' +
                ", concentratorNote='" + concentratorNote + '\'' +
                ", contactOne='" + contactOne + '\'' +
                ", onePhone='" + onePhone + '\'' +
                ", contactTwo='" + contactTwo + '\'' +
                ", twoPhone='" + twoPhone + '\'' +
                ", communityInfo=" + communityInfo +
                '}';
    }
}
