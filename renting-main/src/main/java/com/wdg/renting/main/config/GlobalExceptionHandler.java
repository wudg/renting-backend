//package com.wdg.renting.main.config;
//
//import com.wdg.renting.main.base.common.Result;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletResponse;
//
///**
// * @BelongsProject: renting-backend
// * @BelongsPackage: com.wdg.renting.main.config
// * @Author: 吴第广
// * @CreateTime: 2023-04-26  22:51
// * @Description: TODO
// * @Version: 1.0
// */
//@Slf4j
//@ControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ResponseBody
//    @ExceptionHandler(Exception.class)
//    public Result globalException(HttpServletResponse response, NullPointerException ex){
//        return Result.error("request error:"+response.getStatus() + ",GlobalExceptionHandler:"+ex.getMessage());
//    }
//}