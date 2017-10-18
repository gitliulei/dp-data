package net.astroway.yw.rrsdp.service;

import com.google.common.collect.ImmutableMap;
import net.astroway.yw.base.controller.AppException;
import net.astroway.yw.base.dao.Dao;
import net.astroway.yw.base.util.Is;
import net.astroway.yw.rrsdp.model.SysUser;
import net.astroway.yw.rrsdp.model.dto.SysUserDTO;
import net.astroway.yw.rrsdp.util.Md5Utils;
import net.astroway.yw.rrsdp.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Desc 系统用户service
 * @Author: syk
 * @Date 2017/10/6
 */
@Service
public class SysUserService {
    @Autowired
    private Dao<SysUser> sysUserDao;

    /**
     * 查询所有
     * @return
     */
    public SysUser getAll() {
        return sysUserDao.selectOne("getAll",null);
    }

    /**
     * 新增
     * @param sysUser
     * @return
     */
    @Transactional
    public String add(SysUser sysUser) {
        sysUser.setId(UuidUtil.get32UUID());
        sysUser.setCreateBy("admin");//暂时写死
        sysUser.setStatus("0");
        sysUserDao.insert("insert",sysUser);
        return sysUser.getId();
    }

    /**
     * 更新
     * @param sysUser
     */
    @Transactional
    public void edit(SysUser sysUser) {
        sysUser.setUpdateBy("admin");//暂时写死
        sysUserDao.update("updateById",sysUser);
    }

    /**
     * 根据userCode 查询
     * @return
     */
    public SysUser getByUserCode(String userCode) {

        return sysUserDao.selectOne("getByUserCode",userCode);
    }

    /**
     * 登录校验
     * @param userCode
     * @param password
     * @return
     */
    public SysUserDTO loginCheck(String userCode, String password) {
        //将密码进行MD5加密
        password = Md5Utils.toMD5(password);
        SysUserDTO sysUserDTO = sysUserDao.selectOne("getByUserCodeAndPassword", ImmutableMap.of("userCode", userCode, "password", password, "status", 0));
        if (Is.empty(sysUserDTO)) {
            throw new AppException("用户名或密码错误");
        }
        return sysUserDTO;
    }
}
