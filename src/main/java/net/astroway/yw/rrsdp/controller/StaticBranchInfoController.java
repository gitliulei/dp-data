package net.astroway.yw.rrsdp.controller;

import net.astroway.yw.base.controller.BaseController;
import net.astroway.yw.rrsdp.model.StaticBranchInfo;
import net.astroway.yw.rrsdp.service.StaticBranchInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Desc 网点二级页面详情Controller
 * @Author: syk
 * @Date 2017/10/16
 */
@Controller
@RequestMapping("/api/staticbranchinfo")
public class StaticBranchInfoController extends BaseController {
    @Autowired
    StaticBranchInfoService staticBranchInfoService;

    /*
    * @desc 查询所有
    * @param staticBranchInfo
    * @return
    * */
    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public ResponseEntity getAll(StaticBranchInfo staticBranchInfo) {
        List<StaticBranchInfo> staticBranchInfoList = staticBranchInfoService.getAll(staticBranchInfo);
        return ok().body(staticBranchInfoList).build();
    }
}
