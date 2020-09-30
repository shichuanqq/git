package com.example.demo.service.Impl;

import com.example.demo.entity.InventoryDetailDTO;
import com.example.demo.service.CreateDetailService;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Author: shichuan
 * @Description:
 * @Date: create in 2020/7/31 15:31
 */
@Service("CreateDetailDataServiceImpl")
public class CreateDetailDataServiceImpl implements CreateDetailService {

    @Override
    public List<InventoryDetailDTO> queryDetail() {
        return null;
    }

    @Override
    public List<InventoryDetailDTO> queryDetail1() {
        return null;
    }

    @Override
    public String logDebug() {
        return null;
    }
}
