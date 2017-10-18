package net.astroway.yw.rrsdp.controller;

import net.astroway.yw.base.controller.BaseController;
import net.astroway.yw.rrsdp.model.StaticWareHouse;
import net.astroway.yw.rrsdp.service.StaticWareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Desc （外部）仓库二级页面Controller
 * 静态指标接口
 * @Author: syk
 * @Date 2017/10/12.
 */
@Controller
@RequestMapping("/api/staticwarehouse")
public class StaticWareHouseController extends BaseController{
    @Autowired
    StaticWareHouseService staticWareHouseService;

    /**
     * 查询
     * @return
     */
    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        List<StaticWareHouse> wareHouseList = staticWareHouseService.getAll();
        return ok().body(wareHouseList).build();
    }

    /**
     * 新增
     * @param staticWareHouse
     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity add(@RequestBody StaticWareHouse staticWareHouse) {
        String key = staticWareHouseService.add(staticWareHouse);
        return ok().body(key).build();
    }

    /**
     * 更新
     * @param staticWareHouse
     * @return
     */
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public ResponseEntity edit(@RequestBody StaticWareHouse staticWareHouse) {
        staticWareHouseService.edit(staticWareHouse);
        return ok().build();
    }

    /**
     * 查询仓库信息
     * @return
     */
    @RequestMapping(value = "getStaticWareHouseInfo", method = RequestMethod.GET)
    public ResponseEntity getStaticWareHouseInfo() {
        StaticWareHouse wareHouse = staticWareHouseService.getStaticWareHouseInfo();
        return ok().body(wareHouse).build();
    }

    /**
     * 查询各大区仓库信息
     * @return
     */
    @RequestMapping(value = "getStaticRegionWareHouseInfo", method = RequestMethod.GET)
    public ResponseEntity getStaticRegionWareHouseInfo() {
        StaticWareHouse wareHouse = staticWareHouseService.getStaticRegionWareHouseInfo();
        return ok().body(wareHouse).build();
    }
}
