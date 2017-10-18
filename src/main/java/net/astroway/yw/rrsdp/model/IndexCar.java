package net.astroway.yw.rrsdp.model;

import lombok.Data;
import net.astroway.yw.base.dao.Table;

/**
 * @Desc 车辆
 * @Author: lj
 * @Date 2017/10/17
 */
@Table("RRS_INDEX_CAR")
@Data
public class IndexCar {
    private String indexId;//指标id
    private String source;//数据来源
    private String province;//省
    private String city;//城市
    private String regionId;//大区id
    private String regionName;//大区
    private String tradeId;//小微id
    private String tradeName;//小微
    private String centerId;//中心id
    private String centerName;//中心
    private String dateDt;//日期
    private String dateTime;//时分秒
    private String indexValue;//指标值
    private String etlDt;//抽取时间
    private String indexType;//车辆类型,司机类型，五星车小微
    private String driverName;//司机姓名
    private String contact;//联系方式
    private String carNumber;//车牌号
    private String carModel;//车型
    private String carImage;//车辆图片
    private String startAddress;//起始地址
    private String endAddress;//目的地址



}
