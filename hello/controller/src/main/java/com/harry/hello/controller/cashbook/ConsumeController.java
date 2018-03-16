package com.harry.hello.controller.cashbook;

import com.github.pagehelper.PageInfo;
import com.harry.hello.cashbook.service.ConsumeService;
import com.harry.hello.common.utils.JsonResult;
import com.harry.hello.controller.common.BaseController;
import com.harry.hello.entity.cashbook.Consume;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RequestMapping("cashbook/consume")
@RestController
public class ConsumeController extends BaseController{

    @Resource
    private ConsumeService consumeService;

    @RequestMapping("add")
    public JsonResult add(@Valid Consume consume, BindingResult bindingResult){
        validate(bindingResult);
        consumeService.add(consume);
        return new JsonResult(true);
    }

    @RequestMapping("delete")
    public JsonResult delete(Integer id){
        consumeService.delete(id);
        return new JsonResult(true);
    }

    @RequestMapping("update")
    public JsonResult update(@Valid Consume consume, BindingResult bindingResult){
        validate(bindingResult);
        consumeService.update(consume);
        return new JsonResult(true);
    }

    @RequestMapping("query")
    public JsonResult query(Integer id){
        Consume consume = consumeService.query(id);
        return new JsonResult(consume);
    }

    @RequestMapping("category/list")
    public JsonResult listByCategory(Integer categoryId, Integer start, Integer size){
        PageInfo<Consume> pageInfo = consumeService.listByCategory(categoryId,start,size);
        return new JsonResult(pageInfo);
    }

    @RequestMapping("user/list")
    public JsonResult listByUser(Integer userId, Integer start, Integer size){
        PageInfo<Consume> pageInfo = consumeService.listByUser(userId,start,size);
        return new JsonResult(pageInfo);
    }




}
