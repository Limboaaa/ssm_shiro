package com.qianfeng.dto;

import lombok.Data;
import lombok.Getter;

@Data
public class GoodInfoDTO {
    String goodsName;
    long startPrcie;
    long endPrcie;
    String goodsTitle;
    long basePrice;
    long price;
    long costPrice;
    int stockNum;
    String goodsDesc;
    String status;


}
