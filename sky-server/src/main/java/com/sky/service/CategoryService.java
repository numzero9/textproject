package com.sky.service;

import com.github.pagehelper.Page;
import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;

public interface CategoryService {

    /**
     * 新增分类
     * @param categoryDTO
     */
    void insert(CategoryDTO categoryDTO);


    PageResult PageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    void delete(Long id);

    void update(CategoryDTO categoryDTO);

    void startorStop(Integer status,Long id);

}
