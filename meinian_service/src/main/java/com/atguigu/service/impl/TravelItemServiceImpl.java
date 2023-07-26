package com.atguigu.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.dao.TravelItemDao;
import com.atguigu.pojo.TravelItem;
import com.atguigu.service.TravelItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: TravelItemServiceImpl
 * @Project: meinian_parent
 * @Package: com.atguigu.service
 * @Author: carry.kaimuze
 * @Date: 2023-2023/7/26-17:02
 * @Description:
 */
@Service(interfaceClass = TravelItemService.class)
@Transactional
public class TravelItemServiceImpl implements TravelItemService {

    @Autowired
    private TravelItemDao travelItemDao;


    @Override
    public void addTravelItem(TravelItem travelItem) {
        travelItemDao.addTravelItem(travelItem);
    }

}
