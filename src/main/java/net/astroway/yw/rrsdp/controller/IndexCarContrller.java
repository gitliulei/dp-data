package net.astroway.yw.rrsdp.controller;

import net.astroway.yw.base.controller.BaseController;
import net.astroway.yw.rrsdp.model.IndexCar;
import net.astroway.yw.rrsdp.service.IndexCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Desc 车辆指标数据Controller
 * @Author: lj
 * @Date 2017/10/17
 */
@RestController
@RequestMapping("api/indexcar")
public class IndexCarContrller extends BaseController{

    @Autowired
    private IndexCarService indexCarService;

    /**
     * @desc 查询车辆、五星车小微、司机类型对应数量
     * @param indexCar
     * @return
     */
    @RequestMapping(value = "getTypeNum",method = RequestMethod.GET)
    public ResponseEntity getTypeNum(IndexCar indexCar){
        List<IndexCar> indexCarList=indexCarService.getTypeNum(indexCar);
        return ok().body(indexCarList).build();
    }
    /**
     * @desc 查询车辆总数量
     * @param indexCar
     * @return
     */
    @RequestMapping(value = "getIndexCar",method = RequestMethod.GET)
    public ResponseEntity getIndexCar(IndexCar indexCar){
        List<IndexCar> indexCarList=indexCarService.getIndexCar(indexCar);
        return ok().body(indexCarList).build();
    }

    /*
    * @desc 查询车辆信息
    * @param indexCar
    * @return
    * */
    @RequestMapping(value = "getCarInfo", method = RequestMethod.GET)
    public ResponseEntity getCarInfo(IndexCar indexCar) {
        List<IndexCar> indexCarList = indexCarService.getCarInfo(indexCar);
        return ok().body(indexCarList).build();
    }
}
