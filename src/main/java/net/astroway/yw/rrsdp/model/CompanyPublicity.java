package net.astroway.yw.rrsdp.model;

import lombok.Data;
import net.astroway.yw.base.dao.Table;

/*
* 企业宣传RRS_COMPANY_PUBLICITY
* @author:lj
* @create:2017 - 10 -07 上午 11:25
* */
@Table("RRS_COMPANY_PUBLICITY")
@Data
public class CompanyPublicity {
    private String id;
    private String introduction;//文字介绍
    private String videoPath;//视频地址
    private String partnerPath;//合作伙伴
    private String honorPath;//企业荣誉
    private String createBy;//创建人
    private String createDate;//创建日期
    private String updateBy;//修改人
    private String updateDate;//修改日期
    private String remarks;//备注
    private String status;//状态 0正常 1删除

}
