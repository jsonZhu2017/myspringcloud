package json.zhu.controller;


import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zjs
 * @since 2024-07-04
 */
@Configuration
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Resource
    private Environment environment;

    @Autowired
    private TestService testService;

    @GetMapping(value = "/list")
    public List<TestEntity> list(HttpServletRequest request){
        String url1 = environment.getProperty("spring.datasource.url");
        log.error("url1:{}",url1);
        if(request != null){
            String remoteAddr = request.getRemoteAddr();
            String remoteHost = request.getRemoteHost();
            int remotePort = request.getRemotePort();
            log.error("remoteAddr:{}",remoteAddr);
            log.error("remoteHost:{}",remoteHost);
            log.error("remotePort:{}",remotePort);

            String localAddr = request.getLocalAddr();
            int localPort = request.getLocalPort();
            log.error("localAddr:{}",localAddr);
            log.error("localPort:{}",localPort);
        }


        List<TestEntity>  list = testService.list();
        return list;
    }

}

