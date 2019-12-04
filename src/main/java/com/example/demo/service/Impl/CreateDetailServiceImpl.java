package com.example.demo.service.Impl;

import com.example.demo.config.database.ReadOnlyAnnotation;
import com.example.demo.dao.CreateDetailDao;
import com.example.demo.entity.InventoryDetailDTO;
import com.example.demo.service.CreateDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateDetailServiceImpl implements CreateDetailService {

    @Autowired
    private CreateDetailDao createDetailDao;

    @Override
    public List<InventoryDetailDTO> queryDetail() {
        return createDetailDao.queryDetail();
    }

    @ReadOnlyAnnotation
    @Override
    public List<InventoryDetailDTO> queryDetail1() {
        return createDetailDao.queryDetail();
    }
}
