package com.qianfeng.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class GoodInfo {
    int id;
    long supplierId;
    long categoryId;
    long brandId;
    String goodsTitle;
    String goodsNo;
    String goodsName;
    long basePrice;
    long price;
    long costPrice;
    int stockNum;
    int saleNum;
    long installmentPrice;
    int installmentCount;
    long commissionRate;
    String goodsDesc;
    int goodsHot;
    String status;
    String shipMethod;
    String goodsType;
    long thirdCategoryId;
    long secondCategoryId;
    long firstCategoryId;
    String shipAddress;
    String originImageUrl;
    String origin;
    String warehouse;
    String remark;
    String carriageTime;
    String os;
    String brandName;


}
