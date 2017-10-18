package net.astroway.yw.rrsdp.controller;

import net.astroway.yw.base.controller.BaseController;
import net.astroway.yw.rrsdp.model.StaticTrunk;
import net.astroway.yw.rrsdp.service.StaticTrunkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Desc 外部干线二级页面Controller
 * @Author: lj
 * @Date 2017/10/16
 */
@RestController
@RequestMapping("api/staticTrunk")
public class StaticTrunkController extends BaseController {

    @Autowired
    private StaticTrunkService staticTrunkService;

    /**
     * @desc 查询总吞吐量接口
     * @param staticTrunk
     * @return
     */
    @RequestMapping(value = "getThroughput", method = RequestMethod.GET)
    public ResponseEntity getThroughput(StaticTrunk staticTrunk) {
        StaticTrunk obj = staticTrunkService.getThroughput(staticTrunk);
        return ok().body(obj).build();
    }

    /**
     * @desc 查询各大区发运和干线吞吐量接口
     * @param staticTrunk
     * @return
     */
    @RequestMapping(value = "findThroughputList", method = RequestMethod.GET)
    public ResponseEntity findThroughputList(StaticTrunk staticTrunk) {
        List<StaticTrunk> staticTrunkList = staticTrunkService.findThroughputList(staticTrunk).getStaticTrunkList();
        return ok().body(staticTrunkList).build();
    }

    /**
     *@desc 查询干线发货、到货准时率，中心发货到货准时率
     *@param staticTrunk
     *@return
     */
    @RequestMapping(value = "getPunctuality",method = RequestMethod.GET)
    public ResponseEntity getPunctuality(StaticTrunk staticTrunk){
        staticTrunk=staticTrunkService.getPunctuality(staticTrunk);
        return ok().body(staticTrunk).build();
    }
    /**
     *@desc 查询发运基地数，干线数
     *@param  staticTrunk
     *@return
     */
    @RequestMapping(value = "getJDNumber",method = RequestMethod.GET)
    public ResponseEntity getJDNumber(StaticTrunk staticTrunk){
        StaticTrunk st = staticTrunkService.getJDNumber(staticTrunk);
        return ok().body(st).build();
    }

    /**
     * @desc 查询干线、中心运输时效平均周期接口
     * @param staticTrunk
     * @return
     */
    @RequestMapping(value = "getTransportList",method = RequestMethod.GET)
    public ResponseEntity getTransportList(StaticTrunk staticTrunk){
        staticTrunk = staticTrunkService.getTransportList(staticTrunk);
        return ok().body(staticTrunk).build();
    }


}
