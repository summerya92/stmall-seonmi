package stmallseonmi.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import stmallseonmi.config.kafka.KafkaProcessor;
import stmallseonmi.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryCancelled'"
    )
    public void wheneverDeliveryCancelled_UpdateStatus(
        @Payload DeliveryCancelled deliveryCancelled
    ) {
        DeliveryCancelled event = deliveryCancelled;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + deliveryCancelled + "\n\n"
        );

        // Sample Logic //
        Order.updateStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='InventoryIncrease'"
    )
    public void wheneverInventoryIncrease_NotifyToWatingCustomer(
        @Payload InventoryIncrease inventoryIncrease
    ) {
        InventoryIncrease event = inventoryIncrease;
        System.out.println(
            "\n\n##### listener NotifyToWatingCustomer : " +
            inventoryIncrease +
            "\n\n"
        );

        // Sample Logic //
        Order.notifyToWatingCustomer(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
