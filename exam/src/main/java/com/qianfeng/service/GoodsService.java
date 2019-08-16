package com.qianfeng.service;

import com.qianfeng.dto.GoodInfoDTO;
import com.qianfeng.pojo.GoodInfo;

import java.util.List;

public interface GoodsService {
    public List<GoodInfo> selectAllGoods();//查询所有
    public boolean delGoodsInfoById(int id);
    public boolean addGoodsInfo(GoodInfo goodInfo);
    public List<GoodInfo> ConditionsOfTheQuery(GoodInfoDTO goodInfoDTO);
    public boolean upDateGoodsInfoById(GoodInfo goodInfo);
}
