package net.astroway.yw.rrsdp.controller;

import net.astroway.yw.base.controller.BaseController;
import net.astroway.yw.rrsdp.model.Region;
import net.astroway.yw.rrsdp.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * 区域查询
* @author:lj
* @create:2017 - 10 -11 下午 4:59
*
* */
@RestController
@RequestMapping("api/region")
public class RegionContrller extends BaseController{
    @Autowired
    private RegionService regionService;
    /**
    *@description 查询
    *@return
    */
    @RequestMapping(value = "getAllRegion",method = RequestMethod.GET)
    public ResponseEntity getAllRegion(){
        List<Region> regionList=regionService.getAllRegion();
        return ok().body(regionList).build();
    }
    /**
    *@description 查询大区对应小微
    *@return
    */
    @RequestMapping(value = "getAllTrade",method = RequestMethod.GET)
    public ResponseEntity getAllTrade(String regionId){
        List<Region> regionList=regionService.getAllTrade(regionId);
        return  ok().body(regionList).build();
    }
    /**
    *@description 查询小微对应中心
    *@return
    */
    @RequestMapping(value = "getAllCenter",method = RequestMethod.GET)
    public ResponseEntity getAllCenter(String tradeId){
        List<Region> regionList=regionService.getAllCenter(tradeId);
        return  ok().body(regionList).build();
    }
}
