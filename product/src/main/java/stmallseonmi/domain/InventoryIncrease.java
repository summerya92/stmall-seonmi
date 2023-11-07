package stmallseonmi.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import stmallseonmi.domain.*;
import stmallseonmi.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class InventoryIncrease extends AbstractEvent {

    private Long id;
    private String productId;
    private String productName;
    private String producting;
    private Integer stock;

    public InventoryIncrease(InventoryManagemet aggregate) {
        super(aggregate);
    }

    public InventoryIncrease() {
        super();
    }
}
//>>> DDD / Domain Event
