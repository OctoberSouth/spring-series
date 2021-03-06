package com.lp.controller;

import com.lp.common.ResultJson;
import com.lp.mq.MyProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

/**
 * @author 刘攀
 * @version 1.0
 * @date 2020/11/17 14:09
 */
@RestController
public class TestController {

    @Autowired
    private MyProcessor myProcessor;

    @GetMapping(value = "test")
    public ResultJson test( @RequestParam String txt){
        //发送消息队列消息
        Message<String> stringMessage = MessageBuilder.withPayload(txt).build();
        myProcessor.testOutput().send(stringMessage);
        return ResultJson.success(txt);
    }

}
