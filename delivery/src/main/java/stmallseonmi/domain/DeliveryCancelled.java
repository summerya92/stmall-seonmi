package stmallseonmi.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import stmallseonmi.domain.*;
import stmallseonmi.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeliveryCancelled extends AbstractEvent {

    private Long id;
    private String userId;
    private Long orderId;
    private Long productId;
    private Integer qty;

    public DeliveryCancelled(DeliveryManagement aggregate) {
        super(aggregate);
    }

    public DeliveryCancelled() {
        super();
    }
}
//>>> DDD / Domain Event
