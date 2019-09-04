package com.qfjy.service;

import com.qfjy.dto.QuestionsDTO;

import java.util.List;

/**
 * QuestionService
 *
 * @author GuiYuan Zhang
 * @date 2019/9/2
 */
public interface QuestionService {
    List<QuestionsDTO> selectAll();
}
