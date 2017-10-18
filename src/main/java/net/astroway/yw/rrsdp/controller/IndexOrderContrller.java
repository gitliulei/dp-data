package net.astroway.yw.rrsdp.controller;

import net.astroway.yw.base.controller.BaseController;
import net.astroway.yw.rrsdp.model.IndexOrder;
import net.astroway.yw.rrsdp.model.dto.IndexOrderDTO;
import net.astroway.yw.rrsdp.service.IndexOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Desc 指标数据Controller
 * @Author: zx
 * @Date 2017/10/12
 */
@RestController
@RequestMapping("api/indexorder")
public class IndexOrderContrller extends BaseController{

    @Autowired
    private IndexOrderService indexOrderService;

    /**
     * @desc 查询订单日趋势图数据列表
     * @param indexOrder
     * @return
     */
    @RequestMapping(value = "findTrendList",method = RequestMethod.GET)
    public ResponseEntity findTrendList(IndexOrder indexOrder){
        List<IndexOrder> indexOrderList = indexOrderService.findTrendList(indexOrder);
        return  ok().body(indexOrderList).build();
    }

    /**
     * @desc 查询订单用户好评率、预约及时率、预约完成率、下LES完成率、签收准时率
     * @param indexOrder
     * @return
     */
    @RequestMapping(value = "getIndexPercent",method = RequestMethod.GET)
    public ResponseEntity getIndexPercent (IndexOrder indexOrder){
        IndexOrderDTO indexOrderDTO = indexOrderService.getIndexPercent(indexOrder);
        return  ok().body(indexOrderDTO).build();
    }

    /**
     * @desc 查询订单热力分布图（全国）
     * @param indexOrder
     * @return
     */
    @RequestMapping(value = "getAllHertMap",method = RequestMethod.GET)
    public ResponseEntity getAllHertMap (IndexOrder indexOrder){
        List<IndexOrderDTO> indexOrderDTOList  = indexOrderService.getAllHertMap(indexOrder);
        return  ok().body(indexOrderDTOList).build();
    }

    /**
     * @desc 查询订单热力分布图（大区）
     * @param indexOrder
     * @return
     */
    @RequestMapping(value = "getRegionHertMap",method = RequestMethod.GET)
    public ResponseEntity getRegionHertMap (IndexOrder indexOrder){
        List<IndexOrderDTO> indexOrderDTOList  = indexOrderService.getRegionHertMap(indexOrder);
        return  ok().body(indexOrderDTOList).build();
    }

    /**
     * @desc 查询订单热力分布图（小微）
     * @param indexOrder
     * @return
     */
    @RequestMapping(value = "getTradeHertMap",method = RequestMethod.GET)
    public ResponseEntity getTradeHertMap (IndexOrder indexOrder){
        List<IndexOrderDTO> indexOrderDTOList  = indexOrderService.getTradeHertMap(indexOrder);
        return  ok().body(indexOrderDTOList).build();
    }


    /**
     * @desc 查询当月有效接单数量
     * @param indexOrder
     * @return
     */
    @RequestMapping(value = "getIndexOrders",method = RequestMethod.GET)
    public ResponseEntity getIndexOrders (IndexOrder indexOrder){
        String indexOrders = indexOrderService.getIndexOrders(indexOrder);
        return  ok().body(indexOrders).build();
    }
}
