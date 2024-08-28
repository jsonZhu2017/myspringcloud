package json.zhu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class OrderDto implements Serializable {

    private String orderId;

    private String customerId;
}
