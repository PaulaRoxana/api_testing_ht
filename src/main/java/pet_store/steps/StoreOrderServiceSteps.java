package pet_store.steps;


import pet_store.entities.StoreOrder;
import pet_store.service.StoreOrderService;

import static pet_store.service.uritemplate.UserServiceUri.PLACE_ORDER;

public class StoreOrderServiceSteps {

    private static final StoreOrderService STORE_ORDER_SERVICE = StoreOrderService.getInstance();


    public static StoreOrder createStoreOrder(StoreOrder expectedOrder) {
        return STORE_ORDER_SERVICE.postRequest(PLACE_ORDER, expectedOrder).as(StoreOrder.class);
    }
}