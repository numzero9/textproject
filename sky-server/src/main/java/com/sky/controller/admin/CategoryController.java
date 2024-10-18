package com.sky.controller.admin;

import com.github.pagehelper.PageHelper;
import com.sky.context.BaseContext;
import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.dto.EmployeeDTO;
import com.sky.mapper.CategoryMapper;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RequestMapping("/admin/category")
@Slf4j
@RestController
@Api(tags = "分类相关接口")
public class CategoryController implements Serializable {
        private CategoryService categoryService;

        @GetMapping("/page")
        public PageResult page(CategoryPageQueryDTO categoryPageQueryDTO){
            log.info("进行分类分页查询");


            return
        }

        @PostMapping
        @ApiOperation("新增分类")
        public Result insert(@RequestBody CategoryDTO categoryDTO){
            log.info("进行分类添加:{},{}",categoryDTO.getId(),categoryDTO.getName());
            categoryService.insert(categoryDTO);
            return Result.success();
        }




}
