package pet_store_test;

import io.restassured.response.Response;
import lombok.Data;
import org.testng.Assert;
import org.testng.annotations.Test;
import pet_store.entities.StoreOrder;
import pet_store.steps.StoreOrderServiceSteps;

import java.util.List;
import java.util.Random;

@Data
public class StoreOrderServiceTest {


    @Test
    public void createStoreOrderTest() {
        StoreOrder expectedOrder = createOrderBody();
        Response actualOrder = StoreOrderServiceSteps.createStoreOrder(expectedOrder);
        Assert.assertEquals(actualOrder.as(StoreOrder.class).getPetId(), expectedOrder.getPetId(), "This is not the expected petId");
    }

    @Test
    public void getStoreOrdersByIdTest() {
           Response getStoreOrderById = StoreOrderServiceSteps.getStoreOrderById(1780834899);
        Assert.assertEquals(getStoreOrderById.getStatusCode(), 200, "This is not the expected status code");
    }

    @Test
    public void deleteStoreOrderTest() {
      //  User createdUser = UserServiceSteps.createUser(createUserBody());
        StoreOrder expectedOrder = createOrderBody();
        Response actualOrder = StoreOrderServiceSteps.createStoreOrder(expectedOrder);
       StoreOrderServiceSteps.deleteStoreOrderById(actualOrder.as(StoreOrder.class).getId());
        Response getStoreOrderById = StoreOrderServiceSteps.getStoreOrderById(4411);
        Assert.assertEquals(getStoreOrderById.getStatusCode(), 404, "This is not the expected status code");
      //Assert.assertFalse(users.contains(createdUser), "Expected users list doesn't contain deleted element");
    }

    /**  Response getStoreOrderById = StoreOrderServiceSteps.getStoreOrderById(4400);
     Assert.assertFalse(getStoreOrderById.getBody().asPrettyString().contains("404"));*/

    private StoreOrder createOrderBody() {
        Random random = new Random();
        return new StoreOrder()
                .setId(4411)
                .setPetId(12)
                .setQuantity(1)
                .setShipDate("2022-10-24T17:24:25.381Z")
                .setStatus("placed")
                .setComplete(true);

    }
    }

//[main] INFO Test logger - Response body is {
//        "id": 1780834899,
//        "petId": -659380931,
//        "quantity": 1,
//        "shipDate": "2022-10-24T17:24:25.381+0000",
//        "status": "placed",
//        "complete": true
//        }
