package com.example.canary.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * result entity
 *
 * @since 1.0
 * @author zhaohongliang
 */
@Setter
@Getter
public class ResultEntity<T> {

    /**
     * 响应状态码
     */
    private Integer code;

    /**
     * 响应状态
     */
    private Boolean status;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;

    /**
     * 无参构造器
     */
    private ResultEntity() {
        this.code = ResultCodeEnum.SUCCESS.getCode();
        this.status = true;
        this.message = ResultCodeEnum.SUCCESS.getMessage();
    }

    /**
     * 带参构造器
     *
     * @param data
     */
    private ResultEntity(T data) {
        this.code = ResultCodeEnum.SUCCESS.getCode();
        this.status = true;
        this.data = data;
        this.message = ResultCodeEnum.SUCCESS.getMessage();
    }

    /**
     * 带参构造器
     *
     * @param errorEnum
     */
    private ResultEntity(ErrorEnum errorEnum) {
        this.code = errorEnum.getCode();
        this.status = false;
        this.message = errorEnum.getMessage();
    }

    /**
     * 带参构造器
     *
     * @param message
     */
    private ResultEntity(String message) {
        this.code = ResultCodeEnum.ERROR.getCode();
        this.status = false;
        this.message = message;
    }

    /**
     * 带参构造器
     *
     * @param code
     * @param message
     */
    private ResultEntity(Integer code, String message) {
        this.code = code;
        this.status = false;
        this.message = message;
    }

    /**
     * suceees method，but no result
     *
     * @return
     * @param <T>
     */
    public static <T> ResultEntity<T> success() {
        return new ResultEntity<>();
    }

    /**
     * suceees method, and has a return value
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResultEntity<T> success(T data) {
        return new ResultEntity<>(data);
    }

    /**
     * fail method, default is server internal exception
     *
     * @return
     * @param <T>
     */
    public static <T> ResultEntity<T> fail() {
        return new ResultEntity<>(ResultCodeEnum.ERROR);
    }

    /**
     * fail method, default is server internal exception，but you can customize the code
     *
     * @param errorEnum
     * @return
     * @param <T>
     */
    public static <T> ResultEntity<T> fail(ErrorEnum errorEnum) {
        return new ResultEntity<>(errorEnum);
    }

    /**
     * fail method, default is server internal exception，but you can customize the prompt
     *
     * @param message
     * @return
     * @param <T>
     */
    public static <T> ResultEntity<T> fail(String message) {
        return new ResultEntity<>(message);
    }

    /**
     * fail method, default is server internal exception，but you can customize the code and prompt
     *
     * @param code
     * @param message
     * @return
     * @param <T>
     */
    public static <T> ResultEntity<T> fail(Integer code, String message) {
        return new ResultEntity<>(code, message);
    }
}
