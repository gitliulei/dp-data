package net.astroway.yw.rrsdp.controller;

import net.astroway.yw.base.controller.BaseController;
import net.astroway.yw.rrsdp.model.CompanyPublicity;
import net.astroway.yw.rrsdp.service.CompanyPublicityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/*
* 企业宣传RRS_COMPANY_PUBLICITY
* @author:lj
* @create:2017 - 10 -07 下午 2:39
* */
@RestController
@RequestMapping(value = "/api/publicity")
public class CompanyPublicityController extends BaseController{
    @Autowired
    CompanyPublicityService companyPublicityService;

    /**
    *@description:查询
    *@return
    */
    @RequestMapping(value = "getAllPublicity",method = RequestMethod.GET)
    public ResponseEntity getAllPublicity(){
        List<CompanyPublicity> companyPublicityList=companyPublicityService.getAllPublicity();
        return ok().body(companyPublicityList).build();
    }
    /**
    *@description:添加
    *@param:companyPublicity
    *
    */
    @RequestMapping(value = "addPublicity",method = RequestMethod.POST)
    public ResponseEntity addPublicity(@RequestBody CompanyPublicity companyPublicity){
        String key=companyPublicityService.addPublicity(companyPublicity);
        return ok().body(key).build();
    }
    /**
    *@description:修改
    *@param：companyPublicity
    *@return
    */
    @RequestMapping(value = "updatePublicityById",method = RequestMethod.POST)
    public ResponseEntity updatePublicityById(@RequestBody CompanyPublicity companyPublicity){
        companyPublicityService.updatePublicityById(companyPublicity);
        return ok().build();
    }
    /**
    *@description:删除
    *@param:id
    */
    @RequestMapping(value = "delPublicityById/{id}")
    public ResponseEntity delPublicityById(@PathVariable String id){
        companyPublicityService.delPublicityById(id);
        return ok().build();
    }
    /**
     *@description:查询二级页面宣传文字及视频地址
     *@return
     */
    @RequestMapping(value = "getPublicIntroduction",method = RequestMethod.GET)
    public ResponseEntity getPublicIntroduction(){
            CompanyPublicity companyPublicity=companyPublicityService.getPublicIntroduction();
            return ok().body(companyPublicity).build();
    }
    /**
     *@description:查询二级页面合作伙伴图片地址
     *@return
     */
    @RequestMapping(value = "getPublicPartner",method = RequestMethod.GET)
    public ResponseEntity getPublicPartner(){
        CompanyPublicity companyPublicity=companyPublicityService.getPublicPartner();
        return ok().body(companyPublicity).build();
    }
    /**
     *@description:查询二级页面企业荣誉图片地址
     *@return
     */
    @RequestMapping(value = "getPublicHonor",method = RequestMethod.GET)
    public ResponseEntity getPublicHonor(){
        CompanyPublicity companyPublicity=companyPublicityService.getPublicHonor();
        return ok().body(companyPublicity).build();
    }

}
