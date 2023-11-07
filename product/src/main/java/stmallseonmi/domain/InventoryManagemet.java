package stmallseonmi.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import stmallseonmi.ProductApplication;
import stmallseonmi.domain.InventoryIncrease;

@Entity
@Table(name = "InventoryManagemet_table")
@Data
//<<< DDD / Aggregate Root
public class InventoryManagemet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productId;

    private String productName;

    private String producting;

    private Integer stock;

    @PostUpdate
    public void onPostUpdate() {
        InventoryIncrease inventoryIncrease = new InventoryIncrease(this);
        inventoryIncrease.publishAfterCommit();
    }

    public static InventoryManagemetRepository repository() {
        InventoryManagemetRepository inventoryManagemetRepository = ProductApplication.applicationContext.getBean(
            InventoryManagemetRepository.class
        );
        return inventoryManagemetRepository;
    }

    //<<< Clean Arch / Port Method
    public static void increaseInventory(DeliveryReturned deliveryReturned) {
        //implement business logic here:

        /** Example 1:  new item 
        InventoryManagemet inventoryManagemet = new InventoryManagemet();
        repository().save(inventoryManagemet);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryReturned.get???()).ifPresent(inventoryManagemet->{
            
            inventoryManagemet // do something
            repository().save(inventoryManagemet);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
