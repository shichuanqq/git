package com.example.demo.dao;

import com.example.demo.entity.InventoryDetailDTO;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Mapper
public interface CreateDetailDao extends BaseMapper<InventoryDetailDTO> {
    List<InventoryDetailDTO> queryDetail();

}
