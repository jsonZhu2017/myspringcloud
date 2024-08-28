package json.zhu.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class EchoController {

    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string) {
        log.info("string:{}", string);

        try {
            Thread.sleep(6000L);
        }catch (Exception e){
            log.info("echo-error:{}",e);
        }
        return "Hello Nacos Discovery " + string;
    }

    @RequestMapping(value = "/fun1")
    public String fun1(@RequestParam String userId, @RequestParam String userName){
        return userId + ":" + userName;
    }

    @RequestMapping(value = "/fun2",method = RequestMethod.POST)
    public String fun2(@RequestBody String requestBody){
        return requestBody;
    }
}
