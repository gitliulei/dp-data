package net.astroway.yw.rrsdp.controller;

import net.astroway.yw.base.controller.BaseController;
import net.astroway.yw.rrsdp.model.StaticBranch;
import net.astroway.yw.rrsdp.service.StaticBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * （外部）网点二级页面Controller
 * 静态指标接口
 * Created by syk on 2017/10/6.
 */
@Controller
@RequestMapping("/api/staticbranch")
public class StaticBranchController extends BaseController{
    @Autowired
    StaticBranchService staticBranchService;

    /**
     * 查询所有
     * @return
     */
    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        List<StaticBranch> staticBranchList = staticBranchService.getAll();
        return ok().body(staticBranchList).build();
    }

    /**
     * 新增
     * @param staticBranch
     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity add(@RequestBody StaticBranch staticBranch) {
        String key = staticBranchService.add(staticBranch);
        return ok().body(key).build();
    }

    /**
     * 更新
     * @param staticBranch
     * @return
     */
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public ResponseEntity edit(@RequestBody StaticBranch staticBranch) {
        staticBranchService.edit(staticBranch);
        return ok().build();
    }
    /**
    *@description:查询网点好评率
    *@return StaticBranch
    */
    @RequestMapping(value = "getBranchPraise",method = RequestMethod.GET)
    public ResponseEntity getBranchPrais(){
        StaticBranch staticBranch=staticBranchService.getBranchPraise();
        return ok().body(staticBranch).build();
    }
    /**
    *@description:查询形象店好评率
    *@return
    */
    @RequestMapping(value = "getImagePraise",method = RequestMethod.GET)
    public ResponseEntity getImagePraise(){
        StaticBranch staticBranch=staticBranchService.getImagePraise();
        return ok().body(staticBranch).build();
    }

}
