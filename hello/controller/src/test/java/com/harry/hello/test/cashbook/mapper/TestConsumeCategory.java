package com.harry.hello.test.cashbook.mapper;

import com.harry.hello.entity.cashbook.ConsumeCategory;
import com.harry.hello.mapper.cashbook.ConsumeCategoryMapper;
import com.harry.hello.test.base.BaseCase;
import org.junit.Test;

import javax.annotation.Resource;

public class TestConsumeCategory extends BaseCase {

    @Resource
    private ConsumeCategoryMapper consumeCategoryMapper;

    @Test
    public void testAdd(){
        ConsumeCategory consumeCategory = new ConsumeCategory();
        consumeCategory.setCategory("测试1");
        consumeCategory.setDescription("测试1的描述信息");
        consumeCategory.setUserId(1);
        consumeCategoryMapper.insert(consumeCategory);
    }


}
