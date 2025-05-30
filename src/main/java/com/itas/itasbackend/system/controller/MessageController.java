package com.itas.itasbackend.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itas.itasbackend.config.PageResult;
import com.itas.itasbackend.util.BaseClass.ApiResponse;
import com.itas.itasbackend.util.BaseClass.BaseController;
import com.itas.itasbackend.system.entity.Message;
import com.itas.itasbackend.system.service.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 消息管理控制器
 */
@RestController
@RequestMapping("/admin/message")
public class MessageController extends BaseController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/{id}")
    public ApiResponse<Message> getMessage(@PathVariable("id") Long id) {
        Message message = messageService.getById(id);
        return message != null ? success(message) : error("消息不存在");
    }



    @GetMapping("/page")
    public ApiResponse<PageResult<Message>> page(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize,
            @ModelAttribute Message query
    ) {
        Page<Message> page = new Page<>(pageNum, pageSize);
        IPage<Message> result = messageService.selectPageList(page, query);
        return success(new PageResult<>(result));
    }

    @PostMapping
    public ApiResponse<Void> add(@RequestBody Message message) {
        boolean result = messageService.save(message);
        return toResult(result);
    }

    @PutMapping
    public ApiResponse<Void> edit(@RequestBody Message message) {
        boolean result = messageService.updateById(message);
        return toResult(result);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> remove(@PathVariable("id") Long id) {
        boolean result = messageService.removeById(id);
        return toResult(result);
    }

    @DeleteMapping("/batch")
    public ApiResponse<Void> removeBatch(@RequestBody List<Long> ids) {
        boolean result = messageService.removeBatchByIds(ids);
        return toResult(result);
    }
} 