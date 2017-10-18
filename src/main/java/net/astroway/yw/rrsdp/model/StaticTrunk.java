package net.astroway.yw.rrsdp.model;

import lombok.Data;
import net.astroway.yw.base.dao.Table;

import java.util.List;

/*外部干线二级页面
* @author:lj
* @create:2017 - 10 -16 下午 1:47
* */
@Table("RRS_STATIC_TRUNK")
@Data
public class StaticTrunk {
    private String indexId;//指标id
    private String throughput;//总吞吐量
    private String throughputShip;//发运吞吐量
    private String throughputTrunk;//干线吞吐量
    private String regionName;//大区名称
    private String shipPunctuality;//发货准时率
    private String arivalPunctuality;//到货准时率
    private String shipNumber;//发货基地数量
    private String trunkNumber;//干线数量
    private String trunkTransportTime;//干线运输时效
    private String centerTransportTime;//中心运输时效
    private List<StaticTrunk> staticTrunkList;
}
