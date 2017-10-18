package net.astroway.yw.rrsdp.service;

import net.astroway.yw.base.dao.Dao;
import net.astroway.yw.rrsdp.model.StaticWareHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * @Desc （外部）仓库二级页面service
 * @Author: syk
 * @Date 2017/10/7
 */
@Service
public class StaticWareHouseService {
    @Autowired
    private Dao<StaticWareHouse> staticWareHouseDao;

    /**
     * 查询所有
     * @return
     */
    public List<StaticWareHouse> getAll() {
        return staticWareHouseDao.selectList("getAll",null);
    }

    /**
     * 新增
     * @param staticWareHouse
     * @return
     */
    @Transactional
    public String add(StaticWareHouse staticWareHouse) {
        String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
        staticWareHouse.setId(uuid);
        staticWareHouse.setCreateBy("admin");//暂时写死
        staticWareHouse.setStatus("0");
        staticWareHouseDao.insert("insert",staticWareHouse);
        return staticWareHouse.getId();
    }

    /**
     * 更新
     * @param staticWareHouse
     */
    @Transactional
    public void edit(StaticWareHouse staticWareHouse) {
        staticWareHouse.setUpdateBy("admin");//暂时写死
        staticWareHouseDao.update("updateById",staticWareHouse);
    }

    /**
     * 查询仓库信息
     * @return
     */
    @Transactional
    public StaticWareHouse getStaticWareHouseInfo() {
        return staticWareHouseDao.selectOne("getStaticWareHouseInfo",null);
    }

    /**
     * 查询各大区仓库信息
     * @return
     */
    @Transactional
    public StaticWareHouse getStaticRegionWareHouseInfo() {
        return staticWareHouseDao.selectOne("getStaticRegionWareHouseInfo",null);
    }
}
