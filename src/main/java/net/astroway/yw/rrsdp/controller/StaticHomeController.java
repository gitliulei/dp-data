package net.astroway.yw.rrsdp.controller;

import net.astroway.yw.base.controller.BaseController;
import net.astroway.yw.rrsdp.model.StaticHome;
import net.astroway.yw.rrsdp.service.StaticHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Desc （外部）首页Controller
 * @Author: syk
 * @Date 2017/10/7
 */
@Controller
@RequestMapping("/api/statichome")
public class StaticHomeController extends BaseController{
    @Autowired
    StaticHomeService staticHomeService;

    /**
     * @desc 查询
     * @param
     * @return
     */
    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        List<StaticHome> staticHomeList = staticHomeService.getAll();
        return ok().body(staticHomeList).build();
    }

    /**
     * @desc 新增
     * @param staticHome
     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity add(@RequestBody StaticHome staticHome) {
        String key = staticHomeService.add(staticHome);
        return ok().body(key).build();
    }

    /**
     * @desc 更新
     * @param staticHome
     * @return
     */
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public ResponseEntity edit(@RequestBody StaticHome staticHome) {
        staticHomeService.edit(staticHome);
        return ok().build();
    }

    /**
     * @desc 查询仓库信息数据
     * @param
     * @return
     */
    @RequestMapping(value = "getStaticWarehouseInfo",method = RequestMethod.GET)
    public ResponseEntity getStaticWarehouseInfo(){
        StaticHome staticHome = staticHomeService.getStaticWarehouseInfo();
        return  ok().body(staticHome).build();
    }

    /**
     * @desc 查询仓库分布图数据
     * @param
     * @return
     */
    @RequestMapping(value = "getStaticWarehouseDistributed",method = RequestMethod.GET)
    public ResponseEntity getStaticWarehouseDistributed(){
        StaticHome staticHome = staticHomeService.getStaticWarehouseDistributed();
        return  ok().body(staticHome).build();
    }

    /**
     * @desc 查询首页中间图数据
     * @param
     * @return
     */
    @RequestMapping(value = "getStaticHomeCenter",method = RequestMethod.GET)
    public ResponseEntity getStaticHomeCenter(){
        StaticHome staticHome = staticHomeService.getStaticHomeCenter();
        return  ok().body(staticHome).build();
    }

    /**
     * @desc （外部首页）查询干线收/发货准时率
     * @param
     * @return
     */
    @RequestMapping(value = "getStaticTrunkPunctuality", method = RequestMethod.GET)
    public ResponseEntity getStaticTrunkPunctuality() {
        StaticHome staticHome = staticHomeService.getStaticTrunkPunctuality();
        return ok().body(staticHome).build();
    }

    /**
     * @desc （外部首页）查询干线/基地分布图
     * @param
     * @return
     */
    @RequestMapping(value = "getStaticTrunkDistributionMap", method = RequestMethod.GET)
    public ResponseEntity getStaticTrunkDistributionMap() {
        StaticHome staticHome = staticHomeService.getStaticTrunkDistributionMap();
        return ok().body(staticHome).build();
    }

    /**
     * @desc （外部首页）查询中心收/发货准时率
     * @param
     * @return
     */
    @RequestMapping(value = "getStaticCenterPunctuality", method = RequestMethod.GET)
    public ResponseEntity getStaticCenterPunctuality() {
        StaticHome staticHome = staticHomeService.getStaticCenterPunctuality();
        return ok().body(staticHome).build();
    }

    /**
     * @desc（外部首页）查询网点分布图
     * @param
     * @return
     */
    @RequestMapping(value = "getStaticShopDistributionMap", method = RequestMethod.GET)
    public ResponseEntity getStaticShopDistributionMap() {
        StaticHome staticHome = staticHomeService.getStaticShopDistributionMap();
        return ok().body(staticHome).build();
    }

}
