package com.harry.hello.entity.cashbook;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.util.Date;

public class Consume {
    private Integer id;

    @NotNull(message = "不能为空")
    @NotBlank(message = "不能为空")
    private String title;

    private String description;

    @NotNull(message = "不能为空")
    @Pattern(regexp = "^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$",message = "消费金额错误")
    private BigDecimal money;

    @NotNull(message = "不能为空")
    @Past(message = "消费时间错误")
    private Date consumeTime;

    private Date recordTime;

    @NotNull(message = "不能为空")
    private Integer categoryId;

    @NotNull(message = "不能为空")
    @Pattern(regexp = "^[0-9]*$",message = "格式错误")
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Date getConsumeTime() {
        return consumeTime;
    }

    public void setConsumeTime(Date consumeTime) {
        this.consumeTime = consumeTime;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}