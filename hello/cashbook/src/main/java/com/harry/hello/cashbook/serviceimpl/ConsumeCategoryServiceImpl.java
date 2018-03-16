package com.harry.hello.cashbook.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.harry.hello.entity.cashbook.ConsumeCategory;
import com.harry.hello.cashbook.service.ConsumeCategoryService;
import com.harry.hello.mapper.cashbook.ConsumeCategoryMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Service("consumeCategoryService")
public class ConsumeCategoryServiceImpl implements ConsumeCategoryService {

    @Resource
    private ConsumeCategoryMapper consumeCategoryMapper;

    @Override
    public void add(ConsumeCategory category) {
        consumeCategoryMapper.insert(category);
    }

    @Override
    public void delete(Integer id) {
        consumeCategoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(ConsumeCategory category) {
        consumeCategoryMapper.updateByPrimaryKeySelective(category);
    }

    @Override
    public ConsumeCategory query(Integer id) {
        return consumeCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<ConsumeCategory> list(Integer userId, Integer start, Integer size) {
        PageHelper.offsetPage(start,size);
        List<ConsumeCategory> list = consumeCategoryMapper.selectByUser(userId);
        return new PageInfo<ConsumeCategory>(list);
    }
}
