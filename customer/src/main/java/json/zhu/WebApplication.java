package json.zhu;


import json.zhu.config.LoadBalanceConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @LoadBalancerClient(value = "customer", configuration = {LoadBalanceConfig.class})
 * 坑---只有请求端和被调用端的服务名相同时才根据cluster-name: WH 相同时相互调用。
 * 推荐配置：@LoadBalancerClients(defaultConfiguration = LoadBalanceConfig.class)
 */

@EnableFeignClients
@LoadBalancerClients(defaultConfiguration = LoadBalanceConfig.class)
@Slf4j
@EnableDiscoveryClient
@SpringBootApplication
public class WebApplication {

    //Instantiate RestTemplate Instance
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


    public static void main(String[] args) {
        log.info("jsonZhu--app-started=====================================================");
        ConfigurableApplicationContext applicationContext = SpringApplication.run(WebApplication.class, args);

        /*while (true) {
            //当动态配置刷新时，会更新到 Enviroment中，因此这里每隔3秒中从Enviroment中获取配置
            String userName = applicationContext.getEnvironment().getProperty("stu.username");
            String userAge = applicationContext.getEnvironment().getProperty("stu.age");
            System.err.println("common name:" + userName + "; age: " + userAge);
            try {
                TimeUnit.SECONDS.sleep(3);
            }catch (Exception e){
                e.printStackTrace();
            }

        }*/

    }




}
