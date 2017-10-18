package net.astroway.yw.rrsdp.model;

import lombok.Data;
import net.astroway.yw.base.dao.Table;

import java.util.Date;

/**
 * Created by syk on 2017/10/7.
 */
@Table("RRS_STATIC_HOME")
@Data
public class StaticHome {
    private String id;
    private String introduction;
    private String wareArea;
    private String tcTotal;
    private String frontTotal;
    private String cdcTotal;
    private String isMonitor;
    private String noMonitor;
    private String county;
    private String branch;
    private String carTotal;
    private String peopleTotal;
    private String trunkCar;
    private String areaCar;
    private String lastCar;
    private String registerCar;
    private String activeCar;
    private String orderCar;
    private String trunkDay;
    private String trunkArrival;
    private String trunkSend;
    private String trunkTotal;
    private String baseTotal;
    private String centerArrival;
    private String centerSend;
    private String branchShop;
    private String imageShop;
    private String createBy;
    private Date createDate;
    private String updateBy;
    private Date updateDate;
    private String remarks;
    private String status;
}
