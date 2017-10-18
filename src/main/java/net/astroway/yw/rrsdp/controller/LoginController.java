package net.astroway.yw.rrsdp.controller;

import com.alibaba.fastjson.JSON;
import net.astroway.yw.base.controller.BaseController;
import net.astroway.yw.rrsdp.model.dto.SysUserDTO;
import net.astroway.yw.rrsdp.service.SysUserService;
import net.astroway.yw.rrsdp.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录Controller
 * Created by syk on 2017/10/11.
 */
@RestController
@RequestMapping("/api/login")
public class LoginController extends BaseController{
    @Autowired
    SysUserService sysUserService;

    /**
     * 用户登录校验
     * @param userCode
     * @param password
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseEntity login(@RequestParam String userCode, @RequestParam String password) {
        SysUserDTO sysUserDTO = sysUserService.loginCheck(userCode,password);
        SessionUtil.setUser(JSON.toJSONString(sysUserDTO));
        return ok().body(sysUserDTO).build();
    }

    /**
     * 退出登录
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ResponseEntity logout() {
        SessionUtil.removeUser();
        return ok().build();
    }
}
