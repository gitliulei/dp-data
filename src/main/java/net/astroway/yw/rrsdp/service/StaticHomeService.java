package net.astroway.yw.rrsdp.service;

import net.astroway.yw.base.dao.Dao;
import net.astroway.yw.rrsdp.model.StaticHome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * @Desc （外部）首页service
 * @Author: syk
 * @Date 2017/10/7
 */
@Service
public class StaticHomeService {
    @Autowired
    private Dao<StaticHome> staticHomeDao;

    /**
     * 查询所有
     * @return
     */
    public List<StaticHome> getAll() {
        return staticHomeDao.selectList("getAll",null);
    }

    /**
     * 新增
     * @param staticHome
     * @return
     */
    @Transactional
    public String add(StaticHome staticHome) {
        String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
        staticHome.setId(uuid);
        staticHome.setCreateBy("admin");//暂时写死
        staticHome.setStatus("0");
        staticHomeDao.insert("insert",staticHome);
        return staticHome.getId();
    }

    /**
     * 更新
     * @param staticHome
     */
    @Transactional
    public void edit(StaticHome staticHome) {
        staticHome.setUpdateBy("admin");//暂时写死
        staticHomeDao.update("updateById",staticHome);
    }

    /**
     * 查询仓库信息数据
     * @return
     */
    public StaticHome getStaticWarehouseInfo() {
        return staticHomeDao.selectOne("getStaticWarehouseInfo",null);
    }

    /**
     * 查询仓库分布图数据
     * @return
     */
    public StaticHome getStaticWarehouseDistributed() {
        return staticHomeDao.selectOne("getStaticWarehouseDistributed",null);
    }

    /**
     * 查询首页中间图数据
     * @return
     */
    public StaticHome getStaticHomeCenter() {
        return staticHomeDao.selectOne("getStaticHomeCenter",null);
    }

    /**
     * （外部首页）查询干线收/发货准时率
     * @return
     */
    public StaticHome getStaticTrunkPunctuality() {
        return staticHomeDao.selectOne("getStaticTrunkPunctuality",null);
    }

    /**
     * （外部首页）查询干线/基地分布图
     * @return
     */
    public StaticHome getStaticTrunkDistributionMap() {
        return staticHomeDao.selectOne("getStaticTrunkDistributionMap",null);
    }

    /**
     * （外部首页）查询中心收/发货准时率
     * @return
     */
    public StaticHome getStaticCenterPunctuality() {
        return staticHomeDao.selectOne("getStaticCenterPunctuality",null);
    }

    /**
     * （外部首页）查询网点分布图
     * @return
     */
    public StaticHome getStaticShopDistributionMap() {
        return staticHomeDao.selectOne("getStaticShopDistributionMap",null);
    }
}
