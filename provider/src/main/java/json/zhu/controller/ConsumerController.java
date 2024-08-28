package json.zhu.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;


    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/customer/{string}")
    public String echoAppName(@PathVariable String string){
        //Access through the combination of LoadBalanceClient and RestTemplate
        /*ServiceInstance serviceInstance = loadBalancerClient.choose("myspringcloud");
        String path = String.format("http://%s:%s/echo/%s",serviceInstance.getHost(),serviceInstance.getPort(), appName);
        System.out.println("request path:" +path);
        return restTemplate.getForObject(path,String.class);*/

        String url = String.format("http://provider/echo/%s", string);
        log.info("url:{}",url);

        return restTemplate.getForObject(url, String.class);
    }
}
