package com.wangxj.springcloud.contorller;

import com.wangxj.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * @author wangxj
 * @date 2020/5/4 17:53
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider iMessageProvider ;

    @GetMapping("/sendMessage")
    public String getMessage(){

        return iMessageProvider.send();
    }
}
