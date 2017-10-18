package net.astroway.yw.rrsdp.controller;

import net.astroway.yw.base.controller.BaseController;
import net.astroway.yw.rrsdp.model.SysUser;
import net.astroway.yw.rrsdp.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 系统用户
 * Created by zx on 2017/10/10.
 */
@Controller
@RequestMapping("/api/sysuser")
public class SysUserController extends BaseController{
    @Autowired
    SysUserService sysUserService;

    /**
     * 查询
     * @return
     */
    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        SysUser sysUser = sysUserService.getAll();
        return ok().body(sysUser).build();
    }

    /**
     * 新增
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity add(@RequestBody SysUser sysUser) {
        String key = sysUserService.add(sysUser);
        return ok().body(key).build();
    }

    /**
     * 更新
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public ResponseEntity edit(@RequestBody SysUser sysUser) {
        sysUserService.edit(sysUser);
        return ok().build();
    }

    /**
     * 根据userCode查询
     * @return
     */
    @RequestMapping(value = "getByUserCode", method = RequestMethod.GET)
    public ResponseEntity getByUserCode(String userCode) {
        SysUser sysUser = sysUserService.getByUserCode(userCode);
        return ok().body(sysUser).build();
    }

    @RequestMapping(value = "login")
    String login() {
        return "login";
    }

}
