package com.example.demo.dao;

import com.example.demo.entity.InventoryDetailDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CreateDetailDao {
    List<InventoryDetailDTO> queryDetail();
}
