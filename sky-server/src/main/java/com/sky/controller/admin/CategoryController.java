package com.sky.controller.admin;

import com.github.pagehelper.Page;
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

        @Autowired
        private CategoryService categoryService;


        @GetMapping("/page")
        @ApiOperation("分类分配查询")
        public Result<PageResult> page(CategoryPageQueryDTO categoryPageQueryDTO){
            log.info("进行分类分页查询");
            PageResult pageResult = categoryService.PageQuery(categoryPageQueryDTO);
            return Result.success(pageResult);
        }

        @PostMapping
        @ApiOperation("新增分类")
        public Result insert(@RequestBody CategoryDTO categoryDTO){
            log.info("进行分类添加:{},{}",categoryDTO.getId(),categoryDTO.getName());
            categoryService.insert(categoryDTO);
            return Result.success();
        }

        @DeleteMapping
        @ApiOperation("删除分类")
        public Result delete(Long id){
            log.info("开始删除ID:{}的菜单",id);
            categoryService.delete(id);
            return Result.success();
        }

        @PutMapping
        @ApiOperation("更新分类")
        public Result update(@RequestBody CategoryDTO categoryDTO){
            log.info("开始更新{}的菜单",categoryDTO.getName());
            categoryService.update(categoryDTO);
            return Result.success();
        }

        @PostMapping("/status/{status}")
        @ApiOperation("启用禁用分类")
        public Result startorStop(@PathVariable Integer status,Long id){
            log.info("开始更改分类状态{}",id);
            categoryService.startorStop(status,id);
            return Result.success();
        }

        @GetMapping("/list")
        @ApiOperation("根据类型查询分类")
        public Result<PageResult> listQuery(CategoryPageQueryDTO categoryPageQueryDTO){
            Result<PageResult> page = this.page(categoryPageQueryDTO);
            return page;
        }
}
