package com.example.demo.service.Impl;

import com.example.demo.config.database.ReadOnlyAnnotation;
import com.example.demo.dao.CreateDetailDao;
import com.example.demo.entity.InventoryDetailDTO;
import com.example.demo.service.CreateDetailService;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@Service("CreateDetailServiceImpl")
public class CreateDetailServiceImpl implements CreateDetailService {

    @Autowired
    private CreateDetailDao createDetailDao;

    @Override
    public List<InventoryDetailDTO> queryDetail() {
        PageHelper.startPage(2,5);
        return createDetailDao.queryDetail();
    }

    @ReadOnlyAnnotation
    @Override
    public List<InventoryDetailDTO> queryDetail1() {
        return createDetailDao.queryDetail();
    }


    @Override
    public String logDebug() {
        try {
            Thread.sleep(25000);
        } catch (InterruptedException e) {
            log.info("logDebug is error :{} ", e.getMessage());
        }
        return "5";
    }

    /** 里面有多少个数据 */
    private static final int EXPECT_SIZE = 100_0000;
    /** 期望的误判率 */
    private static final double FPP = 0.0000_5;

    //布隆过滤用法
    private static BloomFilter<String> bf = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8),EXPECT_SIZE,FPP);

    public void init(){
        List<InventoryDetailDTO> list =  this.queryDetail();
        list.forEach(item -> bf.put(item.getCode()));
    }

    public List<InventoryDetailDTO> testBloomFilter(String code){
        //当缓存失效的时候可以
        if(!bf.mightContain(code)){
            System.out.println("没有这个数据--非法访问" + System.currentTimeMillis());
            return Lists.newArrayList();
        }
        //查DB
        return Lists.newArrayList();
    }

}
