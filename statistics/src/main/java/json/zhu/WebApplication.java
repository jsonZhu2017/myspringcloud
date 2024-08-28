package json.zhu;


import json.zhu.config.LoadBalanceConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@Slf4j
@EnableDiscoveryClient
@LoadBalancerClient(value = "myspringcloud", configuration = LoadBalanceConfig.class)
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
        SpringApplication.run(WebApplication.class, args);
    }




}
