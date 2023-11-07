package stmallseonmi.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import stmallseonmi.domain.*;
import stmallseonmi.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeliveryCompleted extends AbstractEvent {

    private Long id;
    private String userId;
    private Long orderId;
    private String productName;
    private Long productId;
    private Integer qty;
    private String stauts;
    private Date deliveryDt;

    public DeliveryCompleted(DeliveryManagement aggregate) {
        super(aggregate);
    }

    public DeliveryCompleted() {
        super();
    }
}
//>>> DDD / Domain Event
