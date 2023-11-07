package stmallseonmi.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import stmallseonmi.domain.*;
import stmallseonmi.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeliveryReturned extends AbstractEvent {

    private Long id;
    private String userId;
    private Long orderId;
    private String productName;
    private Long productId;
    private Integer qty;
    private String stauts;
    private Date deliveryDt;

    public DeliveryReturned(DeliveryManagement aggregate) {
        super(aggregate);
    }

    public DeliveryReturned() {
        super();
    }
}
//>>> DDD / Domain Event
