package com.atguigu.service;

import com.atguigu.pojo.TravelItem;
import com.atguigu.vo.PageResult;
import com.atguigu.vo.QueryPageBean;

public interface TravelItemService {

    void addTravelItem(TravelItem travelItem);

    PageResult findPage(QueryPageBean queryPageBean);
}
