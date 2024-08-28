package json.zhu.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@RefreshScope
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Data
public class StuInfo implements Serializable {

    @Value("${stu.username}")
    private String username;

    @Value("${stu.age}")
    private Integer age;
}
