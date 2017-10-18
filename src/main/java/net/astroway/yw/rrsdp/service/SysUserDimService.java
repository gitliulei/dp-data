package net.astroway.yw.rrsdp.service;

import net.astroway.yw.base.dao.Dao;
import net.astroway.yw.rrsdp.model.SysUserDim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Desc 系统用户组织service
 * @Author: syk
 * @Date 2017/10/12
 */
@Service
public class SysUserDimService {
    @Autowired
    private Dao<SysUserDim> sysUserDimDao;

    public List<SysUserDim> getByUserCode(String userCode){
        return sysUserDimDao.selectList("getByUserCode",userCode);
    }
}
