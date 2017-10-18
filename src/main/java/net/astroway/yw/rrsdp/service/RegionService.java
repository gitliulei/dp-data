package net.astroway.yw.rrsdp.service;

import net.astroway.yw.base.dao.Dao;
import net.astroway.yw.rrsdp.model.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
* @author:lj
* @create:2017 - 10 -11
* */
@Service
public class RegionService {
    @Autowired
    private Dao<Region> regionDao;
    /**
    * @description 查询大区
    * @return
    */
    public List<Region> getAllRegion(){
        return regionDao.selectList("getAllRegion",null);
    }
    /**
    *@description 查询大区对应的小微
    *@return
    */
    public List<Region> getAllTrade(String regionId){
        return regionDao.selectList("getAllTrade",regionId);
    }
    /**
    *@description 查询小微对应的中心
    *@return
    */
    public List<Region> getAllCenter(String tradeId){
        return regionDao.selectList("getAllCenter",tradeId);
    }


}
