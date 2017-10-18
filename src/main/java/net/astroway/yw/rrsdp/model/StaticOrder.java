package net.astroway.yw.rrsdp.model;

import lombok.Data;
import net.astroway.yw.base.dao.Table;

/**
 * 订单二级页面
* @author:lj
* @create:2017 - 10 -06
 */
@Table("RRS_STATIC_ORDER")
@Data
public class StaticOrder {
    private String id;//id
    private String orderTotal;//2016年接单总数
    private String userPrais;//用户好评率
    private String hbArea;//华北地区好评率
    private String hdArea;//华东地区
    private String hzArea;//华中地区
    private String xbArea;//西北地区
    private String xnArea;//西南地区
    private String dbArea;//东北地区
    private String hnArea;//华南地区
    private String sdArea;//山东地区好评率
    private String createBy;//创建人
    private String createDate;//创建日期
    private String updateBy;//修改人
    private String updateDate;//修改日期
    private String remarks;//备注
    private String status;//状态 0正常 1删除
}
