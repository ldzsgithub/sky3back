package com.ask.sky3back.controller;

import com.ask.sky3back.common.JsonResult;
import com.ask.sky3back.common.util.validate.ValidateException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GlobalExceptionHandler {

    //@ExceptionHandler({ ValidateException.class })
    @ResponseBody
    public JsonResult handleNoAuthException(String e) {
        return new JsonResult(e);
    }
}
