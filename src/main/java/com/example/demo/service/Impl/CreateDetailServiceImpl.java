package com.example.demo.service.Impl;

import com.example.demo.config.database.ReadOnlyAnnotation;
import com.example.demo.dao.CreateDetailDao;
import com.example.demo.entity.InventoryDetailDTO;
import com.example.demo.service.CreateDetailService;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
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
}
