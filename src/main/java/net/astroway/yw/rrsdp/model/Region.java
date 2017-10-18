package net.astroway.yw.rrsdp.model;

import lombok.Data;
import net.astroway.yw.base.dao.Table;

/*
*查询区域
* @author:lj
* @create:2017 - 10 -11 下午 2:37
* */
@Table("RRS_REGION_DIM")
@Data
public class Region {
    private String centerId;
    private String centerName;
    private String regionId;
    private String regionName;
    private String tradeId;
    private String tradeName;
    private String wCode;
    private String tmallStoreCode;
    private String province;
    private String loneItude;
    private String laItude;
    private String tradeNameOld;
}
