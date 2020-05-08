package com.kuang.edu.controller;

import com.kuang.edu.entity.Log;
import com.kuang.edu.service.LogService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 系统日志(Log)表控制层
 *
 * @author makejava
 * @since 2020-05-08 11:15:16
 */
@RestController
@RequestMapping("/api/logs")
@Api(tags = "监控：日志管理")
public class LogController {
    /**
     * 服务对象
     */
    @Resource
    private LogService logService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Log selectOne(Long id) {
        return this.logService.queryById(id);
    }

}