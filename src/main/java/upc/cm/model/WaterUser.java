package upc.cm.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class WaterUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @OneToOne
    @JoinColumn(referencedColumnName = "meterId")
    private WaterMeter waterMeter;

    private String userAddress;

    private String userName;

    private String userEmail;

    private String userPhone;

    private String houseType;

    private String huangdaoNumber;

    private String isReal;

    private String userMoney;

    private String meterType;

    private String userPrepay;

    private String waterType;

    private String aboutDoor;

    private String userPrize;

    private String userNumber;

    private String userBankcard;

    private String familyNumber;

    private String otherId;

    private String userNote;

    @Override
    public String toString() {
        return "WaterUser{" +
                "userId=" + userId +
                ", userAddress='" + userAddress + '\'' +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", houseType='" + houseType + '\'' +
                ", huangdaoNumber='" + huangdaoNumber + '\'' +
                ", isReal='" + isReal + '\'' +
                ", userMoney='" + userMoney + '\'' +
                ", meterType='" + meterType + '\'' +
                ", userPrepay='" + userPrepay + '\'' +
                ", waterType='" + waterType + '\'' +
                ", aboutDoor='" + aboutDoor + '\'' +
                ", userPrize='" + userPrize + '\'' +
                ", userNumber='" + userNumber + '\'' +
                ", userBankcard='" + userBankcard + '\'' +
                ", familyNumber='" + familyNumber + '\'' +
                ", otherId='" + otherId + '\'' +
                ", userNote='" + userNote + '\'' +
                '}';
    }
}
