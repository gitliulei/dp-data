package net.astroway.yw.rrsdp.model;

import lombok.Data;
import net.astroway.yw.base.dao.Table;

/**
 * @Author: syk
 * @Date 2017/10/16
 */
@Table("RRS_STATIC_BRANCH_INFO")
@Data
public class StaticBranchInfo {
    private String id;
    private String gongmaoName;
    private String branchName;
    private String branchRegion;
    private String telephone;
    private String position;
    private double longitude;
    private double latitude;
    private String type;
    private String dotImage;
}
