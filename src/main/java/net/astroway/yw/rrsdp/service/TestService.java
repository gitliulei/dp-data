package net.astroway.yw.rrsdp.service;

import net.astroway.yw.base.dao.Dao;
import net.astroway.yw.rrsdp.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Created by 98794 on 2017/9/29.
 */
@Service
public class TestService {
    @Autowired
    private Dao<Test> testDao;

    public List<Test> getAll() {
        return testDao.selectList("getAll", null);
    }

    @Transactional
    public void updateById(Test test) {
        System.out.println(test.getId());
        System.out.println(test.getName());
        testDao.update("updateById",test);
    }

    @Transactional
    public String add() {
        Test test = new Test();
        String uuid = UUID.randomUUID().toString();
        test.setId(uuid);
        test.setName("test");
        testDao.insert("insert",test);
        return test.getId();
    }
}
