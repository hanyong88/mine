package com.harry.hello.entity.cashbook;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ConsumeCategory {
    private Integer id;

    @NotNull(message = "不能为空")
    @NotBlank(message = "不能为空")
    private String category;

    @NotNull(message = "不能为空")
    @NotBlank(message = "不能为空")
    private String description;

    @NotNull(message = "不能为空")
//    @Pattern(regexp="^[0-9]*$", message="用户ID必须为数字")
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}