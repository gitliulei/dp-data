package net.astroway.yw.rrsdp.controller;

import net.astroway.yw.base.controller.BaseController;
import net.astroway.yw.rrsdp.model.StaticOrder;
import net.astroway.yw.rrsdp.service.StaticOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Desc 外部订单二级页面controller
 * @Author: lj
 * @Date 2017/10/6
 */
@RestController
@RequestMapping("/api/staticOrder")
public class StaticOrderController extends BaseController{
    @Autowired
    private StaticOrderService staticOrderService;
    /**
     * @desc 查询订单
     * @return
     */
    @RequestMapping(value = "getAllOrder",method = RequestMethod.GET)
    public ResponseEntity getAllOrder(){
        List<StaticOrder> staticOrderList = staticOrderService.getAllOrder();
        return ok().body(staticOrderList).build();
    }

    /*
    * @desc 新增
    * @param staticOrder
    * @return
    * */
    @RequestMapping(value="addOrder",method = RequestMethod.POST)
    public ResponseEntity addOrder(@RequestBody StaticOrder staticOrder){
        String publicityId= staticOrderService.addOrder(staticOrder);
        return ok().body(publicityId).build();
    }

    /*
   * @desc 修改
   * @param staticOrder
   * @return
   * */
    @RequestMapping(value = "updateOrderById",method = RequestMethod.POST)
    public ResponseEntity updateOrderById(@RequestBody StaticOrder staticOrder){
        staticOrderService.updateOrderById(staticOrder);
        return ok().build();
    }
    /**
     * @desc 删除
     * @param id
     * @return
     */
    @RequestMapping(value = "delOrderById",method = RequestMethod.GET)
    public ResponseEntity delOrderById(String id){
        staticOrderService.delOrderById(id);
        return ok().build();
    }
    /*
    * @desc 查询2016年有效接单数
    * @return
    * */
    @RequestMapping(value = "getOrderTocal",method = RequestMethod.GET)
    public ResponseEntity getOrderTocal(){
        StaticOrder staticOrder = staticOrderService.getOrderTocal();
        return ok().body(staticOrder).build();
    }
    /*
    * @desc 查询用户好评率,各地区好评率
    * @return
    * */
    @RequestMapping(value = "getUserPrais",method = RequestMethod.GET)
    public ResponseEntity getUserPrais(){
        StaticOrder staticOrder = staticOrderService.getUserPrais();
        return ok().body(staticOrder).build();
    }
}
