package upc.cm.model;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
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
public class SystemUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int suId;

    @ExcelProperty("用户账号")
    private String userAccount;

    @ExcelProperty("用户密码")
    private String userPassword;

    @ExcelProperty("用户类型")
    private String userType;

    @ExcelProperty("用户备注")
    private String userNote;

    @JsonIgnore
    @ExcelIgnore
    @OneToMany(mappedBy = "systemUser")
    private Set<SystemLog> systemLogs = new HashSet<>();

    @Override
    public String toString() {
        return "SystemUser{" +
                "suId=" + suId +
                ", userAccount='" + userAccount + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userType='" + userType + '\'' +
                ", userNote='" + userNote + '\'' +
                '}';
    }
}
