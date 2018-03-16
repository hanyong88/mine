package com.harry.hello.cashbook.service;

import com.github.pagehelper.PageInfo;
import com.harry.hello.entity.cashbook.Consume;

public interface ConsumeService {

    public void add(Consume consume);
    public void delete(Integer id);
    public void update(Consume consume);
    public Consume query(Integer id);
    public PageInfo<Consume> listByCategory(Integer categoryId, Integer start, Integer size);
    public PageInfo<Consume> listByUser(Integer userId, Integer start, Integer size);


}
