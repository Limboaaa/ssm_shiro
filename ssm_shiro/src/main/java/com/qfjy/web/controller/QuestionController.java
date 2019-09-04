package com.qfjy.web.controller;

import com.qfjy.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


/**
 * QuestionController
 *
 * @author GuiYuan Zhang
 * @date 2019/9/2
 */
@RestController
@RequestMapping("questions")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @RequestMapping("all")//questions/all
    public Object sellctAll(){
        //使用Map将数据转化为前端需要的数据格式
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("questions",questionService.selectAll());

        return map;
    }

}

