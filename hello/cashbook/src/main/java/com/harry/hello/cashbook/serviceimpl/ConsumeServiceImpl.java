package com.harry.hello.cashbook.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.harry.hello.cashbook.service.ConsumeService;
import com.harry.hello.entity.cashbook.Consume;
import com.harry.hello.mapper.cashbook.ConsumeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("consumeService")
public class ConsumeServiceImpl implements ConsumeService {

    @Resource
    private ConsumeMapper consumeMapper;

    @Override
    public void add(Consume consume) {
        consumeMapper.insert(consume);
    }

    @Override
    public void delete(Integer id) {
        consumeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Consume consume) {
        consumeMapper.updateByPrimaryKeySelective(consume);
    }

    @Override
    public Consume query(Integer id) {
        return consumeMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<Consume> listByCategory(Integer categoryId, Integer start, Integer size) {
        PageHelper.offsetPage(start,size);
        List<Consume> list = consumeMapper.selectByCategory(categoryId);
        return new PageInfo<Consume>(list);
    }

    @Override
    public PageInfo<Consume> listByUser(Integer userId, Integer start, Integer size) {
        PageHelper.offsetPage(start,size);
        List<Consume> list = consumeMapper.selectByUser(userId);
        return new PageInfo<Consume>(list);
    }
}
