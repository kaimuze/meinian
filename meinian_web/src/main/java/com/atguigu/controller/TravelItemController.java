package com.atguigu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.constant.MessageConstant;
import com.atguigu.pojo.TravelItem;
import com.atguigu.service.TravelItemService;
import com.atguigu.vo.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: TravelItemController
 * @Project: meinian_parent
 * @Package: com.atguigu.controller
 * @Author: carry.kaimuze
 * @Date: 2023-2023/7/26-17:00
 * @Description:
 */
@RestController
@RequestMapping("/TravelItem")
public class TravelItemController {

    @Reference
    private TravelItemService travelItemService;

    @PostMapping("/add")
    public Result addTravelItem(@RequestBody TravelItem travelItem){
        try {
            this.travelItemService.addTravelItem(travelItem);
            return new Result(true, MessageConstant.ADD_TRAVELITEM_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.ADD_TRAVELITEM_FAIL);
        }
    }


}
