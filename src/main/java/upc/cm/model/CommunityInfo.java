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
public class CommunityInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int communityId;

    private String communityName;

    private String communityAddress;

    private String communityNote;

    private String contactOne;

    private String onePhone;

    private String contactTwo;

    private String twoPhone;

    private String contactThree;

    private String threePhone;

    @JsonIgnore
    @OneToMany(mappedBy = "communityInfo")
    private Set<SystemConcentrator> systemConcentrators = new HashSet<>();

    @Override
    public String toString() {
        return "CommunityInfo{" +
                "communityId=" + communityId +
                ", communityName='" + communityName + '\'' +
                ", communityAddress='" + communityAddress + '\'' +
                ", communityNote='" + communityNote + '\'' +
                ", contactOne='" + contactOne + '\'' +
                ", onePhone='" + onePhone + '\'' +
                ", contactTwo='" + contactTwo + '\'' +
                ", twoPhone='" + twoPhone + '\'' +
                ", contactThree='" + contactThree + '\'' +
                ", threePhone='" + threePhone + '\'' +
                '}';
    }
}
