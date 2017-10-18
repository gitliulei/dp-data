package net.astroway.yw.rrsdp.controller;

import net.astroway.yw.base.controller.BaseController;
import net.astroway.yw.rrsdp.model.Template;
import net.astroway.yw.rrsdp.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @Desc 页面模板Controller
 * @Author: liguohua
 * @Date 2017/10/10
 */
@Controller
@RequestMapping("/api/template")
public class TemplateController extends BaseController{

    @Autowired
    private TemplateService templateService;

    /*
    * @desc 新增页面模块
    * @param template
    * @return
    * */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity addTemplate(Template template) {
        String id = templateService.add(template);
        return ok().body(id).build();
    }

    /*
    * @desc 删除页面模块
    * @param modularId
    * @return
    * */
    @RequestMapping(value = "del", method = RequestMethod.POST)
    public ResponseEntity delTemplate(String modularId) {
        templateService.delByModularId(modularId);
        return ok().build();
    }

    /*
    * @desc 查询页面模块
    * @param pageId
    * @return
    * */
    @RequestMapping(value = "getPageModular", method = RequestMethod.GET)
    public ResponseEntity getPageModular(String pageId) {
        Template template = templateService.getPageModular(pageId);
        return ok().body(template).build();
    }

    /*
    * @desc 编辑页面模块
    * @param template
    * @return
    * */
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public ResponseEntity editTemplate(Template template) {
        templateService.edit(template);
        return ok().build();
    }
}
