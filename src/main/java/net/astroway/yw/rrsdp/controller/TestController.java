package net.astroway.yw.rrsdp.controller;

import net.astroway.yw.base.controller.BaseController;
import net.astroway.yw.rrsdp.model.Test;
import net.astroway.yw.rrsdp.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by 98794 on 2017/9/29.
 */
@Controller
@RequestMapping("/api/test")
public class TestController extends BaseController{

    @Autowired
    TestService testService;

@RequestMapping(value = "getAll", method = RequestMethod.GET)
public ResponseEntity getAll() {
    List<Test> list = testService.getAll();
    return ok().body(list).build();
}

}
