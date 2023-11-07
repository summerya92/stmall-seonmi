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
    InventoryManagemetRepository inventoryManagemetRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryCompleted'"
    )
    public void wheneverDeliveryCompleted_ReduceInventory(
        @Payload DeliveryCompleted deliveryCompleted
    ) {
        DeliveryCompleted event = deliveryCompleted;
        System.out.println(
            "\n\n##### listener ReduceInventory : " + deliveryCompleted + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryReturned'"
    )
    public void wheneverDeliveryReturned_IncreaseInventory(
        @Payload DeliveryReturned deliveryReturned
    ) {
        DeliveryReturned event = deliveryReturned;
        System.out.println(
            "\n\n##### listener IncreaseInventory : " +
            deliveryReturned +
            "\n\n"
        );

        // Sample Logic //
        InventoryManagemet.increaseInventory(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
