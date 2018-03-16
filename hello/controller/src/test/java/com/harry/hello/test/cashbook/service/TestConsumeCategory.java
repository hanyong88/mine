package com.harry.hello.test.cashbook.service;

import com.harry.hello.cashbook.service.ConsumeCategoryService;
import com.harry.hello.entity.cashbook.ConsumeCategory;
import com.harry.hello.test.base.BaseCase;
import org.junit.Test;

import javax.annotation.Resource;

public class TestConsumeCategory extends BaseCase{

    @Resource
    private ConsumeCategoryService consumeCategoryService;

    @Test
    public void testAdd(){
        ConsumeCategory consumeCategory = new ConsumeCategory();
        consumeCategory.setCategory("测试3");
        consumeCategory.setUserId(null);
        consumeCategory.setDescription("测试3的描述信息");
        consumeCategoryService.add(consumeCategory);

    }



}
