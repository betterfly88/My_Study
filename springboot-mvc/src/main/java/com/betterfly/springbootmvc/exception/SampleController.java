package com.betterfly.springbootmvc.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by betterfly
 * Date : 2019.03.18
 */

@Controller
public class SampleController {

    @GetMapping("/exception")
    public String exception(){
        throw new SampleException();
    }

    // 이 컨트롤러에서 Exception발생시 다음의 핸들러를 실행하겠다
//    @ExceptionHandler(SampleException.class)
//    public @ResponseBody AppError sampleError(SampleException e){
//        AppError appError = new AppError();
//        appError.setMessage(e.getMessage());
//        appError.setReason(e.getReason());
//
//        return appError;
//    }
}
