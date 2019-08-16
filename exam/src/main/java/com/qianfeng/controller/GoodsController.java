package com.qianfeng.controller;

import com.qianfeng.dto.GoodInfoDTO;
import com.qianfeng.pojo.GoodInfo;
import com.qianfeng.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    /**
     * 获取所有商品信息
     * @return
     */
    @RequestMapping("selectAllGoods")
    public Object selectAllGoods(){
        return goodsService.selectAllGoods();
    }

    /**
     *根据商品id删除商品
     * @param id
     * @return
     */
    @RequestMapping("delGoodsInfoById")
    public Object delGoodsInfoById(@RequestParam int id){
        boolean flage = goodsService.delGoodsInfoById(id);
        return flage;
    }

    /**
     * 条件查询（商品名 价格区间 是否上架）
     * @param goodInfoDTO
     * @return
     */
    public Object ConditionsOfTheQuery(@RequestBody GoodInfoDTO goodInfoDTO){
        return  goodsService.ConditionsOfTheQuery(goodInfoDTO);
    }
    /**
     * 添加商品信息
     * @param goodInfo
     * @return
     */
    @RequestMapping("addGoodsInfo")
    public Object addGoodsInfo(@RequestBody GoodInfo goodInfo){
        boolean flag = goodsService.addGoodsInfo(goodInfo);
        return flag;
    }

    /**
     * 修改商品的id修改商品信息
     * @param goodInfo
     * @return
     */
    public Object upDateGoodsInfo(@RequestBody GoodInfo goodInfo){
        return  goodsService.upDateGoodsInfoById(goodInfo);
    }
}
