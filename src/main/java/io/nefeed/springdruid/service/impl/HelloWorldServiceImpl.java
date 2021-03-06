package io.nefeed.springdruid.service.impl;

import io.nefeed.springdruid.annotation.AnalysisActuator;
import io.nefeed.springdruid.service.HelloWorldService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author 章华隽
 * @mail nefeed@163.com
 * @time 2018-03-09 09:09
 */
@Service
public class HelloWorldServiceImpl implements HelloWorldService {

    @AnalysisActuator(note = "获取聊天信息方法")
    @Override
    public String getHelloMessage(String name) {
        return "Hello " + Optional.ofNullable(name).orElse("World!");
    }

}
