package stmallseonmi.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import stmallseonmi.domain.*;
import stmallseonmi.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class MailSent extends AbstractEvent {

    private Long id;

    public MailSent(Order aggregate) {
        super(aggregate);
    }

    public MailSent() {
        super();
    }
}
//>>> DDD / Domain Event
