package com.mjj.mapper;

import com.mjj.pojo.BasicData;
import com.mjj.pojo.BasicDataExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BasicDataMapper {
    long countByExample(BasicDataExample example);

    int deleteByExample(BasicDataExample example);

    int deleteByPrimaryKey(Integer baseId);

    int insert(BasicData record);

    int insertSelective(BasicData record);

    List<BasicData> selectByExample(BasicDataExample example);

    BasicData selectByPrimaryKey(Integer baseId);

    int updateByExampleSelective(@Param("record") BasicData record, @Param("example") BasicDataExample example);

    int updateByExample(@Param("record") BasicData record, @Param("example") BasicDataExample example);

    int updateByPrimaryKeySelective(BasicData record);

    int updateByPrimaryKey(BasicData record);
}