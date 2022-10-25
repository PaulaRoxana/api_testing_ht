package pet_store.steps;


import io.restassured.response.Response;
import pet_store.entities.StoreOrder;
import pet_store.service.StoreOrderService;

import static pet_store.service.uritemplate.UserServiceUri.ORDER_BY_ID;
import static pet_store.service.uritemplate.UserServiceUri.PLACE_ORDER;

public class StoreOrderServiceSteps {

    private static final StoreOrderService STORE_ORDER_SERVICE = StoreOrderService.getInstance();


    public static Response createStoreOrder(StoreOrder expectedOrder) {
        return STORE_ORDER_SERVICE.postRequest(PLACE_ORDER, expectedOrder);
    }

    public static Response getStoreOrderById(int id) {
        return STORE_ORDER_SERVICE.getRequest(ORDER_BY_ID, id);
    }

    public static Response getStoreOrderById2(int id) {
        return STORE_ORDER_SERVICE.getRequest2(ORDER_BY_ID, id);
    }

    public static void deleteStoreOrderById(int id) {
        STORE_ORDER_SERVICE.deleteRequest(ORDER_BY_ID, id);
    }
}