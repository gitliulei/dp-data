package net.astroway.yw.rrsdp.service;

import net.astroway.yw.base.dao.Dao;
import net.astroway.yw.rrsdp.model.StaticTrunk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Desc 外部干线二级页面service
 * @Author: lj
 * @Date 2017/10/16
 */
@Service
public class StaticTrunkService {

    @Autowired
    private Dao<StaticTrunk> staticTrunkDao;

    /**
     * @Desc 查询总吞吐量接口
     * @param staticTrunk
     * @return
     */
    public StaticTrunk getThroughput(StaticTrunk staticTrunk) {
        return  staticTrunkDao.selectOne("getThroughput",staticTrunk);
    }

    /**
     * @Desc 查询各大区发运和干线吞吐量接口
     * @param staticTrunk
     * @return
     */
    public StaticTrunk findThroughputList(StaticTrunk staticTrunk) {
        staticTrunk.setStaticTrunkList(staticTrunkDao.selectList("findThroughputList",staticTrunk));
        return  staticTrunk;
    }

    /**
     *@Desc 查询干线发货、到货准时率，中心发货到货准时率
     *@param staticTrunk
     *@return
    */
    public StaticTrunk getPunctuality(StaticTrunk staticTrunk){
        return staticTrunkDao.selectOne("getPunctuality",staticTrunk);
    }
    /**
    *@Desc 查询发运基地数，干线数
    *@param staticTrunk
    *@return
    */
    public StaticTrunk getJDNumber(StaticTrunk staticTrunk){
        return staticTrunkDao.selectOne("getJDNumber",staticTrunk);
    }

    /**
    *@Desc 查询干线、中心运输时效平均周期
    *@param staticTrunk
    *@return
    */
    public StaticTrunk getTransportList(StaticTrunk staticTrunk){
        staticTrunk.setStaticTrunkList(staticTrunkDao.selectList("getTransportList",staticTrunk));
        String trunkTransportTime = "0";//平均时效
        String centerTransportTime = "0";//平均时效
        int i = 0;
        for(StaticTrunk obj : staticTrunk.getStaticTrunkList()){
            if(obj != null){
                i++;
                trunkTransportTime = (Integer.valueOf(trunkTransportTime) + Integer.valueOf(obj.getTrunkTransportTime())) + "";
                centerTransportTime = (Integer.valueOf(centerTransportTime) + Integer.valueOf(obj.getCenterTransportTime())) + "";
            }
        }
        trunkTransportTime = (Integer.valueOf(trunkTransportTime)/i) + "";
        centerTransportTime = (Integer.valueOf(centerTransportTime)/i) + "";
        staticTrunk.setTrunkTransportTime(trunkTransportTime);
        staticTrunk.setCenterTransportTime(centerTransportTime);
        return staticTrunk;
    }

}
