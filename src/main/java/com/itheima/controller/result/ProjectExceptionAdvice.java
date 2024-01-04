package com.itheima.controller.result;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 凯祥
 */
//作为springmvc的异常处理器
@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler //拦截所有的异常信息
    public Result doException(Exception ex) {
        ex.printStackTrace();
        return new Result("服务器超时！");

    }

}
