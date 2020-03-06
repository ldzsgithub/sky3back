package com.ask.sky3back.common.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GlobalExceptionHandler {

    //@ExceptionHandler({ ValidateException.class })
    @ResponseBody
    public static JsonResult validateExceptionHandler(String msg, int code) {
        return new JsonResult(msg, code, "");
    }
}
