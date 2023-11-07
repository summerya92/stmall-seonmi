package stmallseonmi.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import stmallseonmi.domain.*;
import stmallseonmi.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class SatusUpdated extends AbstractEvent {

    private Long id;

    public SatusUpdated(Order aggregate) {
        super(aggregate);
    }

    public SatusUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
