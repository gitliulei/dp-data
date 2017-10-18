package net.astroway.yw.rrsdp.service;

import net.astroway.yw.base.dao.Dao;
import net.astroway.yw.rrsdp.model.StaticBranchInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Desc （外部）网点二级页面详情service
 * @Author: syk
 * @Date 2017/10/16
 */
@Service
public class StaticBranchInfoService {
    @Autowired
    private Dao<StaticBranchInfo> staticBranchInfoDao;

    /**
     * 查询所有
     * @return
     */
    public List<StaticBranchInfo> getAll(StaticBranchInfo staticBranchInfo) {
        return  staticBranchInfoDao.selectList("getAll",staticBranchInfo);
    }
}
