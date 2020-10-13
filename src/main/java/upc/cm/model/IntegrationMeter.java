package upc.cm.model;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Data
public class IntegrationMeter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ExcelIgnore
    private int integrationMeterId;

    @ExcelProperty("地址")
    private String integrationMeterAddress;

    @Column(unique = true)
    @ExcelProperty("表号")
    private String integrationMeterAccount;

    @ExcelProperty("采集器地址")
    private String integrationMeterCollectorId;

    @ExcelProperty("集中器地址")
    private String integrationMeterConcentratorId;

    @ExcelProperty("抄表时间")
    private String time;


    @ExcelProperty("水表读数")
    private double meterNumber;



}
