package com.qfjy.dto;

import lombok.Data;

/**
 * QuestionsDTO
 *
 * @author GuiYuan Zhang
 * @date 2019/9/2
 */
@Data
public class QuestionsDTO {
    private String question;

    private Short correctAnswer;
    //选项
    private String [] answers; //List[]

}
