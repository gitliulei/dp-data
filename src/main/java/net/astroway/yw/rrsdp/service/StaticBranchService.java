package net.astroway.yw.rrsdp.service;

import net.astroway.yw.base.dao.Dao;
import net.astroway.yw.rrsdp.model.StaticBranch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * @Desc （外部）网点二级页面service
 * @Author: syk
 * @Date 2017/10/6
 */
@Service
public class StaticBranchService {
    @Autowired
    private Dao<StaticBranch> staticBranchDao;

    /**
     * 查询所有
     * @return
     */
    public List<StaticBranch> getAll() {
        return  staticBranchDao.selectList("getAll",null);
    }

    /**
     * 新增
     * @param staticBranch
     * @return
     */
    @Transactional
    public String add(StaticBranch staticBranch) {

        String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
        staticBranch.setId(uuid);
        staticBranch.setCreateBy("admin");//暂时写死
        staticBranch.setStatus("0");
        staticBranchDao.insert("insert",staticBranch);
        return staticBranch.getId();
    }

    /**
     * 更新
     * @param staticBranch
     */
    @Transactional
    public void edit(StaticBranch staticBranch) {
        staticBranch.setUpdateBy("admin");//暂时写死
        staticBranchDao.update("updateById",staticBranch);
    }
    /**
    *@description:查询网点好评率
    *@return
    */
    public StaticBranch getBranchPraise(){
        return staticBranchDao.selectOne("getBranchPraise",null);
    }
    /**
    *@description:查询形象店好评率
    *@return
    */
    public StaticBranch getImagePraise(){
        return staticBranchDao.selectOne("getImagePraise",null);
    }
}
