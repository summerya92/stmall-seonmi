package stmallseonmi.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import stmallseonmi.DeliveryApplication;
import stmallseonmi.domain.DeliveryCancelled;
import stmallseonmi.domain.DeliveryCompleted;
import stmallseonmi.domain.DeliveryReturned;
import stmallseonmi.domain.DeliveryStarted;

@Entity
@Table(name = "DeliveryManagement_table")
@Data
//<<< DDD / Aggregate Root
public class DeliveryManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;

    private Long orderId;

    private String productName;

    private Long productId;

    private Integer qty;

    private String stauts;

    private Date deliveryDt;

    @PostPersist
    public void onPostPersist() {
        DeliveryStarted deliveryStarted = new DeliveryStarted(this);
        deliveryStarted.publishAfterCommit();

        DeliveryCancelled deliveryCancelled = new DeliveryCancelled(this);
        deliveryCancelled.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        DeliveryReturned deliveryReturned = new DeliveryReturned(this);
        deliveryReturned.publishAfterCommit();
    }

    @PreUpdate
    public void onPreUpdate() {
        DeliveryCompleted deliveryCompleted = new DeliveryCompleted(this);
        deliveryCompleted.publishAfterCommit();
    }

    public static DeliveryManagementRepository repository() {
        DeliveryManagementRepository deliveryManagementRepository = DeliveryApplication.applicationContext.getBean(
            DeliveryManagementRepository.class
        );
        return deliveryManagementRepository;
    }

    //<<< Clean Arch / Port Method
    public static void startDelivery(OrderPlaced orderPlaced) {
        //implement business logic here:

        /** Example 1:  new item 
        DeliveryManagement deliveryManagement = new DeliveryManagement();
        repository().save(deliveryManagement);

        DeliveryStarted deliveryStarted = new DeliveryStarted(deliveryManagement);
        deliveryStarted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(deliveryManagement->{
            
            deliveryManagement // do something
            repository().save(deliveryManagement);

            DeliveryStarted deliveryStarted = new DeliveryStarted(deliveryManagement);
            deliveryStarted.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
