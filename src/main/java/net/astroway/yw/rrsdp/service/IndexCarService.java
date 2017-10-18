package net.astroway.yw.rrsdp.service;

import net.astroway.yw.base.dao.Dao;
import net.astroway.yw.rrsdp.model.IndexCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Desc 车辆指标service
 * @Author: lj
 * @Date 2017/10/17
 */
@Service
public class IndexCarService {

    @Autowired
    private Dao<IndexCar> indexCarDao;

    /**
     * @desc  查询车辆、五星车小微、司机类型对应数量
     * @param indexCar
     * @return
     */
    public List<IndexCar> getTypeNum(IndexCar indexCar){
        return indexCarDao.selectList("getTypeNum",indexCar);
    }
    /*
  * @desc 查询车辆信息
  * @param indexCar
  * @return
  * */
    public List<IndexCar> getIndexCar(IndexCar indexCar) {
        return  indexCarDao.selectList("getIndexCar",indexCar);
    }

    /*
    * @desc 查询车辆总数量
    * @param indexCar
    * @return
    * */
    public List<IndexCar> getCarInfo(IndexCar indexCar) {
        return  indexCarDao.selectList("getCarInfo",indexCar);
    }
}
