package com.example.canary.task.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.canary.common.api.ApiVersion;
import com.example.canary.common.exception.ResultEntity;
import com.example.canary.common.exception.ValidGroup;
import com.example.canary.task.entity.TaskAO;
import com.example.canary.task.entity.TaskQuery;
import com.example.canary.task.service.TaskService;
import com.example.canary.task.entity.TaskVO;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 任务
 *
 * @since 1.0
 * @author zhaohongliang
 */
@ApiVersion
@Validated
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    /**
     * pages
     *
     * @param query request query parameters
     * @return response page result
     */
    @GetMapping("/pages")
    public ResultEntity<Page<TaskVO>> pagesTask(TaskQuery query) {
        return taskService.pagesTask(query);
    }

    /**
     * add
     *
     * @param taskAo request object
     * @return response result
     */
    @PostMapping("/add")
    @SuppressWarnings("rawtypes")
    public ResultEntity addTask(@Validated({ ValidGroup.Add.class }) @RequestBody TaskAO taskAo) {
        return taskService.addTask(taskAo);
    }

    /**
     * edit
     *
     * @param taskAo request object
     * @return response result
     */
    @PutMapping("/edit")
    @SuppressWarnings("rawtypes")
    public ResultEntity editTask(@Validated({ ValidGroup.Edit.class }) @RequestBody TaskAO taskAo) {
        return taskService.editTask(taskAo);
    }

    /**
     * delete
     *
     * @param taskId task primary key
     * @return response result
     */
    @DeleteMapping("/delete")
    @SuppressWarnings("rawtypes")
    public ResultEntity deleteTask(@NotBlank String taskId) {
        return taskService.deleteTask(taskId);
    }

    /**
     * execute
     *
     * @param taskId task primary key
     * @return response result
     */
    @GetMapping("/execute")
    @SuppressWarnings("rawtypes")
    public ResultEntity executeTask(@NotBlank String taskId) {
        return taskService.executeTask(taskId);
    }

    /**
     * start
     *
     * @param taskId task primary key
     * @return response result
     */
    @GetMapping("/start")
    @SuppressWarnings("rawtypes")
    public ResultEntity startTask(@NotBlank String taskId) {
        return taskService.startTask(taskId);
    }

    /**
     * stop
     *
     * @param taskId task primary key
     * @return response result
     */
    @GetMapping("/stop")
    @SuppressWarnings("rawtypes")
    public ResultEntity stopTask(@NotBlank String taskId) {
        return taskService.stopTask(taskId);
    }

}
