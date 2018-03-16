package com.harry.hello.mapper.cashbook;

import com.harry.hello.entity.cashbook.Consume;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Consume record);

    int insertSelective(Consume record);

    Consume selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Consume record);

    int updateByPrimaryKey(Consume record);

    List<Consume> selectByCategory(Integer categoryId);

    List<Consume> selectByUser(Integer userId);
}