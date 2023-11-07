package stmallseonmi.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import stmallseonmi.domain.*;

@Component
public class InventoryManagemetHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<InventoryManagemet>> {

    @Override
    public EntityModel<InventoryManagemet> process(
        EntityModel<InventoryManagemet> model
    ) {
        return model;
    }
}
