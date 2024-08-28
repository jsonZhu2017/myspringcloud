package json.zhu.feign;

import jakarta.servlet.http.HttpServletRequest;
import json.zhu.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "provider")
public interface EchoFeignService {

    @GetMapping(value = "/echo/{string}")
    String echo(@PathVariable String string);

    /**
     * @RequestParam 请求参数为userId & userName
     * @param userId
     * @param userName
     * @return
     */
    @RequestMapping(value = "/fun1")
    String fun1(@RequestParam String userId,@RequestParam String userName);

    /**
     * 无注解时，默认请求是requestBody，且无注解时，只能有一个参数
     * @param requestBody
     * @return
     */
    @RequestMapping(value = "/fun2",method = RequestMethod.POST)
    String fun2( String requestBody);

    /**
     * 请求是requestBody
     * @param requestBody
     * @return
     */
    @RequestMapping(value = "/fun3")
    String fun3( @RequestBody String requestBody);

    /**
     * @SpringQueryMap 请求类型可以是 ？a=a1&b=b1这种
     * @param orderDto
     * @return
     */
    @RequestMapping(value = "/fun4")
    String fun4( @SpringQueryMap OrderDto orderDto);
}
