package net.astroway.yw.rrsdp.model;

import lombok.Data;
import net.astroway.yw.base.dao.Table;

import java.util.Date;

/**
 * Created by syk on 2017/10/7.
 */
@Table("RRS_STATIC_WAREHOUSE")
@Data
public class StaticWareHouse {
    private String id;
    private String wareArea;
    private String tcArea;
    private String frontArea;
    private String cdcArea;
    private String tcTotal;
    private String frontTotal;
    private String cdcTotal;
    private String hbArea;
    private String hdArea;
    private String hnArea;
    private String hzArea;
    private String sdArea;
    private String xnArea;
    private String xbArea;
    private String dbArea;
    private String hbTotal;
    private String dbTotal;
    private String xnTotal;
    private String xbTotal;
    private String hdTotal;
    private String sdTotal;
    private String hzTotal;
    private String hnTotal;
    private String createBy;
    private Date createDate;
    private String updateBy;
    private Date updateDate;
    private String remarks;
    private String status;
}
