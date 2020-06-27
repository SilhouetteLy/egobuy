package com.silhouette.search.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liuyi
 * @version 1.0
 * @create -- 23:23
 * @description: 全局异常处理器
 */
public class GlobalExceptionResolver implements HandlerExceptionResolver {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView = new ModelAndView("error/exception");
        ex.printStackTrace();
        logger.error("系统出错", ex.getMessage());
        //发邮件，短信，电话
        //响应友好的界面
        modelAndView.addObject("message", "您的网络出现问题，请稍后再试！");
        return modelAndView;
    }
}
