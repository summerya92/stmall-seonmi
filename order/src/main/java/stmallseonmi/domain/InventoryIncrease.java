package stmallseonmi.domain;

import java.util.*;
import lombok.*;
import stmallseonmi.domain.*;
import stmallseonmi.infra.AbstractEvent;

@Data
@ToString
public class InventoryIncrease extends AbstractEvent {

    private Long id;
    private String productId;
    private String productName;
    private String producting;
    private Integer stock;
}
