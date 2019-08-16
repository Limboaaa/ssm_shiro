package com.qianfeng.dao;

import com.qianfeng.dto.GoodInfoDTO;
import com.qianfeng.pojo.GoodInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GoodsMapper {
    public List<GoodInfo> selectAllGoods();
    public int delGoodsInfoById(int id);
    public int addGoodsInfo(GoodInfo goodInfo);
    public List<GoodInfo> ConditionsOfTheQuery(GoodInfoDTO goodInfoDTO);
    public int upDateGoodsInfoById(GoodInfo goodInfo);
}
