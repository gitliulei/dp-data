package net.astroway.yw.rrsdp.service;

import com.google.common.collect.ImmutableMap;
import net.astroway.yw.base.dao.Dao;
import net.astroway.yw.rrsdp.model.StaticOrder;
import net.astroway.yw.rrsdp.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Desc 外部订单二级页面
 * @Author: lj
 * @Date 2017/10/6
 */
@Service
public class StaticOrderService {
    @Autowired
    private Dao<StaticOrder> staticOrderDao;
    /**
    * @desc 查询订单
    * @return
    */
    public List<StaticOrder> getAllOrder(){
        return staticOrderDao.selectList("getAllOrder",null);
    }
    /**
    * @desc 新增
    * @param staticOrder
    * @return
    */
    @Transactional
    public String addOrder(StaticOrder staticOrder){
        staticOrder.setId(UuidUtil.get32UUID());
        staticOrderDao.insert("addOrder",staticOrder);
        return staticOrder.getId();
    }

    /**
    * @desc 修改
    * @param staticOrder
    * @return
    */
    @Transactional
    public void updateOrderById(StaticOrder staticOrder){
        staticOrderDao.update("updateOrderById",staticOrder);
    }
    /**
    * @desc 删除
    * @param id
    * @return
    */
    @Transactional
    public void delOrderById(String id){
        staticOrderDao.update("delOrderById",id);
    }
    /**
    * @desc 查询2016年有效接单数
    * @return
    */
    public StaticOrder  getOrderTocal(){
        return staticOrderDao.selectOne("getOrderTocal",null);
    }
    /**
    * @desc 查询用户好评率，各地区好评率
    * @return
    */
    public StaticOrder  getUserPrais(){
        return staticOrderDao.selectOne("getUserPrais",null);
    }

}
