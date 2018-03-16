package com.harry.hello.cashbook.service;

import com.github.pagehelper.PageInfo;
import com.harry.hello.entity.cashbook.ConsumeCategory;
import org.springframework.validation.BindingResult;

public interface ConsumeCategoryService {

    public void add(ConsumeCategory category);
    public void delete(Integer id);
    public void update(ConsumeCategory category);
    public ConsumeCategory query(Integer id);
    public PageInfo<ConsumeCategory> list(Integer userId, Integer start, Integer size);


}
