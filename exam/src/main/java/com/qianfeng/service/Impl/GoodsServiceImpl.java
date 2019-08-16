package com.qianfeng.service.Impl;

import com.qianfeng.dao.GoodsMapper;
import com.qianfeng.dto.GoodInfoDTO;
import com.qianfeng.pojo.GoodInfo;
import com.qianfeng.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;
    public List<GoodInfo> selectAllGoods() {

        return goodsMapper.selectAllGoods();
    }

    public boolean delGoodsInfoById(int id) {

        return goodsMapper.delGoodsInfoById(id)>0;
    }

    public boolean addGoodsInfo(GoodInfo goodInfo) {
        return goodsMapper.addGoodsInfo(goodInfo)>0;
    }

    public List<GoodInfo> ConditionsOfTheQuery(GoodInfoDTO goodInfoDTO) {
        return goodsMapper.ConditionsOfTheQuery(goodInfoDTO);
    }

    public boolean upDateGoodsInfoById(GoodInfo goodInfo) {
        return goodsMapper.upDateGoodsInfoById(goodInfo)>0;
    }
}
