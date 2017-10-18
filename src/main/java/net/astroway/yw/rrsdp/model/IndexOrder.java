package net.astroway.yw.rrsdp.model;

import lombok.Data;
import net.astroway.yw.base.dao.Table;

import java.util.List;

/*
* @author:zx
* @create:2017 - 10 -12
* */
@Table("RRS_INDEX_ORDER")
@Data
public class IndexOrder {
    private String regionId;//大区ID
    private String regionName;//大区
    private String tradeId;//小微ID
    private String tradeName;//小微
    private String centerId;//中心ID
    private String centerName;//中心
    private String dateDt;//日期
    private String dateTime;//时
    private String indexValue;//指标值(或者存放量)
    private String indexAll;//指标总值
    private String indexId;//指标ID
    private String etlDt;//抽取时间

    private String startDate;//本月第一天
    private String endDate;//当前日期

    private String rate;//百分比
    private List<IndexOrder> timelyRateList;//及时率列表
    private List<IndexOrder> finishRateList;//完成率列表
}
