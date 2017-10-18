package net.astroway.yw.rrsdp.service;

import net.astroway.yw.base.dao.Dao;
import net.astroway.yw.rrsdp.model.Template;
import net.astroway.yw.rrsdp.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Desc 页面模板service
 * @Author: liguohua
 * @Date 2017/10/10
 */
@Service
public class TemplateService {

    @Autowired
    private Dao<Template> templateDao;

    /*
   * @Desc 新增页面模块
   * @Param template
   * @return
   */
    public String add(Template template) {
        template.setId(UuidUtil.get32UUID());
        template.setCreate_by("admin");
        template.setStatus(0);
        template.setRemarks("");
        templateDao.insert("insert", template);
        return template.getId();
    }

    /*
    * @Desc 删除页面模块
    * @Param modularId
    * @return
    */
    public void delByModularId(String modularId) {
        templateDao.delete("delByModularId", modularId);
    }

    /*
    * @Desc 查询页面模块
    * @param pageId
    * @return
    * */
    public Template getPageModular(String pageId) {
        return templateDao.selectOne("selectByPageId", pageId);
    }

    /*
    * @Desc 编辑页面模块
    * @param template
    * @return
    */
    public void edit(Template template) {
        template.setUpdate_by("admin");
        templateDao.update("updateModular", template);
    }
}
