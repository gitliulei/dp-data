package net.astroway.yw.rrsdp.model;

import lombok.Data;
import net.astroway.yw.base.dao.Table;

import java.util.Date;

/**
 * 系统用户表
 * Created by zx on 2017/10/10.
 */
@Table("RRS_SYS_USER")
@Data
public class SysUser {
    private String id;
    private String userCode;
    private String password;
    private String userNmae;
    private String dimId;
    private String createBy;
    private Date createDate;
    private String updateBy;
    private Date updateDate;
    private String remarks;
    private String status;
}
