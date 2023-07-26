package com.atguigu.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.dao.TravelItemDao;
import com.atguigu.pojo.TravelItem;
import com.atguigu.service.TravelItemService;
import com.atguigu.vo.PageResult;
import com.atguigu.vo.QueryPageBean;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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

    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        //分页插件
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();
        // 底层ThreadLocal将数据绑定到当前线程上,传递给后续的流程(dao)
        PageHelper.startPage(currentPage,pageSize);

        Page<TravelItem> page = this.travelItemDao.findPage(queryString);
        return new PageResult(page.getTotal(),page.getResult());
    }

}
