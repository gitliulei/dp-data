package net.astroway.yw.rrsdp.model;

import lombok.Data;
import net.astroway.yw.base.dao.Table;

import java.util.Date;

/**
 * Created by syk on 2017/10/6.
 */
@Table("RRS_STATIC_BRANCH")
@Data
public class StaticBranch {
    private String id;
    private String branchTotal;
    private String branchHb;
    private String branchHd;
    private String branchHz;
    private String branchXb;
    private String branchXn;
    private String branchDb;
    private String branchHn;
    private String branchSd;
    private String imageTotal;
    private String imageHb;
    private String imageHd;
    private String imageHz;
    private String imageXb;
    private String imageXn;
    private String imageDb;
    private String imageHn;
    private String imageSd;
    private String createBy;
    private Date createDate;
    private String updateBy;
    private Date updateDate;
    private String remarks;
    private String status;
}
