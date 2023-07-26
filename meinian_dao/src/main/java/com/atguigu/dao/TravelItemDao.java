package com.atguigu.dao;

import com.atguigu.pojo.TravelItem;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

public interface TravelItemDao {

    void addTravelItem(TravelItem travelItem);

    Page<TravelItem> findPage(@Param("value") String queryString);
}
