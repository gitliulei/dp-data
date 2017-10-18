package net.astroway.yw.rrsdp.model.dto;

import lombok.Data;
import net.astroway.yw.rrsdp.model.IndexOrder;

/**
 * Created by syk on 2017/10/12.
 */
@Data
public class IndexOrderDTO extends IndexOrder{
    private String percent;//用户好评率、预约及时率、预约完成率、下LES完成率、签收准时率
    private String indexAllNum;//指标总值累计和
    private String indexValueNum;//指标值累计和
    private double longitude;//经度
    private double latitude;//纬度
    private Integer orderNum;//前一小时订单数量
    private Integer orderDiffer;//订单数量差
    private String indexOrders;//当月有效接单数量
}
