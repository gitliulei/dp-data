package net.astroway.yw.rrsdp.model;

import lombok.Data;
import net.astroway.yw.base.dao.Table;

import java.util.Date;

/**
 * Created by syk on 2017/10/12.
 */
@Table("RRS_SYS_USER_DIM")
@Data
public class SysUserDim {
    private String id;
    private String userCode;
    private String dimId;
    private String type;
    private String createBy;
    private Date createDate;
    private String updateBy;
    private Date updateDate;
    private String remarks;
    private String status;
}
