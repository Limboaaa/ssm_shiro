package com.qfjy.service.impl;

import com.qfjy.dao.QuestionsMapper;
import com.qfjy.dto.QuestionsDTO;
import com.qfjy.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * QuestionServiceImpl
 *
 * @author GuiYuan Zhang
 * @date 2019/9/2
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionsMapper questionsMapper;


    public List<QuestionsDTO> selectAll() {
        return questionsMapper.selectAll();
    }
}
