package com.harry.hello.mapper.cashbook;

import com.harry.hello.entity.cashbook.ConsumeCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumeCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConsumeCategory record);

    int insertSelective(ConsumeCategory record);

    ConsumeCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConsumeCategory record);

    int updateByPrimaryKey(ConsumeCategory record);

    //查询某用户的所有消费分类
    List<ConsumeCategory> selectByUser(Integer userId);
}