package net.astroway.yw.rrsdp.controller;

import net.astroway.yw.base.controller.BaseController;
import net.astroway.yw.rrsdp.model.SysUserDim;
import net.astroway.yw.rrsdp.service.SysUserDimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Desc 用户组织Controller
 * @Author: syk
 * @Date 2017/10/12.
 */
@Controller
@RequestMapping("/api/sysuserdim")
public class SysUserDimController extends BaseController{
    @Autowired
    SysUserDimService sysUserDimService;

    /**
     * 根据userCode查询
     * @return
     */
    @RequestMapping(value = "getByUserCode", method = RequestMethod.GET)
    public ResponseEntity getByUserCode(@RequestParam String userCode) {
        List<SysUserDim> sysUserDimList = sysUserDimService.getByUserCode(userCode);
        return ok().body(sysUserDimList).build();
    }
}
