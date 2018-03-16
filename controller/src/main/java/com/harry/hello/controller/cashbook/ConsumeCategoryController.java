package com.harry.hello.controller.cashbook;

import com.github.pagehelper.PageInfo;
import com.harry.hello.cashbook.service.ConsumeCategoryService;
import com.harry.hello.common.utils.JsonResult;
import com.harry.hello.controller.common.BaseController;
import com.harry.hello.entity.cashbook.ConsumeCategory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("cashbook/category")
public class ConsumeCategoryController extends BaseController{

    @Resource
    private ConsumeCategoryService consumeCategoryService;

    @RequestMapping("add")
    public JsonResult add(@Valid ConsumeCategory consumeCategory, BindingResult bindingResult){
        validate(bindingResult);
        consumeCategoryService.add(consumeCategory);
        return new JsonResult(true);
    }

    @RequestMapping("delete")
    public JsonResult delete(Integer id){
        consumeCategoryService.delete(id);
        return new JsonResult(true);
    }

    @RequestMapping("update")
    public JsonResult update(@Valid ConsumeCategory consumeCategory,BindingResult bindingResult){
        validate(bindingResult);
        consumeCategoryService.update(consumeCategory);
        return new JsonResult(true);
    }

    @RequestMapping("query")
    public JsonResult query(Integer id){
        ConsumeCategory consumeCategory = consumeCategoryService.query(id);
        return new JsonResult(consumeCategory);
    }

    @RequestMapping("list")
    public JsonResult list(Integer userId, Integer start, Integer size){
        PageInfo<ConsumeCategory> pageInfo = consumeCategoryService.list(userId, start, size);
        return new JsonResult(pageInfo);
    }

}
