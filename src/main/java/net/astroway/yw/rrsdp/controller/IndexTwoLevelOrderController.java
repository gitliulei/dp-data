package net.astroway.yw.rrsdp.controller;

import net.astroway.yw.base.controller.BaseController;
import net.astroway.yw.rrsdp.model.IndexOrder;
import net.astroway.yw.rrsdp.model.dto.IndexOrderDTO;
import net.astroway.yw.rrsdp.service.IndexTwoLevelOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Desc 二级页面指标数据Controller
 * @author:zx
 * @Date 2017/10/12
 */
@RestController
@RequestMapping("api/indextwolevelorder")
public class IndexTwoLevelOrderController extends BaseController{

    @Autowired
    private IndexTwoLevelOrderService indexTwoLevelOrderService;

    /**
     * @desc 查询有效接单数量折线图
     * @param indexOrder
     * @return
     */
    @RequestMapping(value = "getValidOrderList",method = RequestMethod.GET)
    public ResponseEntity getValidOrderList(IndexOrder indexOrder){
        List<IndexOrderDTO> indexOrderDTOList = indexTwoLevelOrderService.getValidOrderList(indexOrder);
        return ok().body(indexOrderDTOList).build();
    }

    /**
     * @desc 查询有效订单数
     * @param indexOrder
     * @return
     */
    @RequestMapping(value = "getValidOrderNum",method = RequestMethod.GET)
    public ResponseEntity getValidOrderNum(IndexOrder indexOrder){
        IndexOrderDTO indexOrderDTO = indexTwoLevelOrderService.getValidOrderNum(indexOrder);
        return ok().body(indexOrderDTO).build();
    }

    /**
     * @desc 查询2017年累计地区排名柱状图（大区）
     * @param indexOrder
     * @return
     */
    @RequestMapping(value = "findOrderRankingRegionIdList",method = RequestMethod.GET)
    public ResponseEntity findOrderRankingRegionIdList(IndexOrder indexOrder){
        List<IndexOrder> indexOrderList = indexTwoLevelOrderService.findOrderRankingRegionIdList(indexOrder);
        return ok().body(indexOrderList).build();
    }

    /**
     * @desc 查询2017年累计地区排名柱状图（小微）
     * @param indexOrder
     * @return
     */
    @RequestMapping(value = "findOrderRankingTradeIdList",method = RequestMethod.GET)
    public ResponseEntity findOrderRankingTradeIdList(IndexOrder indexOrder){
        List<IndexOrder> indexOrderList = indexTwoLevelOrderService.findOrderRankingTradeIdList(indexOrder);
        return ok().body(indexOrderList).build();
    }

    /**
     * @desc 查询2017年累计地区排名柱状图（中心）
     * @param indexOrder
     * @return
     */
    @RequestMapping(value = "findOrderRankingCenterIdList",method = RequestMethod.GET)
    public ResponseEntity findOrderRankingCenterIdList(IndexOrder indexOrder){
        List<IndexOrder> indexOrderList = indexTwoLevelOrderService.findOrderRankingCenterIdList(indexOrder);
        return ok().body(indexOrderList).build();
    }
    /**
     * 查询订单预约及时率
     * @param indexOrder
     * @return
     */
    @RequestMapping(value="getTwoLevelIndexPercent",method = RequestMethod.GET)
    public ResponseEntity findOrderPercent(IndexOrder indexOrder){
        indexOrder=indexTwoLevelOrderService.getOrderPercent(indexOrder);
        return  ok().body(indexOrder).build();
    }

    /**
     * @desc 查询预约完成率、配车完成率、派工完成率、签收准时率、下LES完成率（内部）
     * @param indexOrder
     * @return
     */
    @RequestMapping(value = "getFinishRate",method = RequestMethod.GET)
    public ResponseEntity getFinishRate(IndexOrder indexOrder){
        String finishRate = indexTwoLevelOrderService.getFinishRate(indexOrder);
        return ok().body(finishRate).build();
    }

    /**
     * @desc 查询预约及时率/完成率趋势图（内部）
     * @param indexOrder
     * @return
     */
    @RequestMapping(value = "findRateTrendList",method = RequestMethod.GET)
    public ResponseEntity findRateTrendList(IndexOrder indexOrder){
        IndexOrder indexOrderRate = indexTwoLevelOrderService.findRateTrendList(indexOrder);
        return ok().body(indexOrderRate).build();
    }

}
