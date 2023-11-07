package stmallseonmi.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import stmallseonmi.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "inventoryManagemets",
    path = "inventoryManagemets"
)
public interface InventoryManagemetRepository
    extends PagingAndSortingRepository<InventoryManagemet, Long> {}
