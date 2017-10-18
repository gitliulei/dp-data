package net.astroway.yw.rrsdp.service;

import net.astroway.yw.base.dao.Dao;
import net.astroway.yw.rrsdp.model.CompanyPublicity;
import net.astroway.yw.rrsdp.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
*企业宣传
* @author:lj
* @create:2017 - 10 -07 下午 2:37
* */
@Service
public class CompanyPublicityService {
    @Autowired
    Dao<CompanyPublicity> companyPublicityDao;
    /**
    * 查询所有
    * @return
     * */
    public List<CompanyPublicity> getAllPublicity(){
        return companyPublicityDao.selectList("getAllPublicity",null);
    }
    /**
    *添加
    *@param companyPublicity
    *@return
    */
    @Transactional
    public String addPublicity(CompanyPublicity companyPublicity){
        companyPublicity.setId(UuidUtil.get32UUID());
        companyPublicityDao.insert("addPublicity",companyPublicity);
        return  companyPublicity.getId();
    }
    /**
    *Description:修改
    *@param companyPublicity
    *@return
    */
    @Transactional
    public void updatePublicityById(CompanyPublicity companyPublicity){
        companyPublicityDao.update("updatePublicityById",companyPublicity);
    }
    /**
    *@description 删除
    *@param id
    */
    @Transactional
    public void delPublicityById(String id){
        companyPublicityDao.update("delPublicityById",id);
    }
    /**
    *@description:查询二级页面宣传文字、视频地址
    *@return
    */
    public CompanyPublicity getPublicIntroduction(){
        return companyPublicityDao.selectOne("getPublicIntroduction",null);
    }
    /**
     *@description:查询二级页面合作伙伴图片地址
     *@return
     */
    public CompanyPublicity getPublicPartner(){
        return companyPublicityDao.selectOne("getPublicPartner",null);
    }
    /**
     *@description:查询二级页面荣誉图片地址
     *@return
     */
    public CompanyPublicity getPublicHonor(){
        return companyPublicityDao.selectOne("getPublicHonor",null);
    }

}
