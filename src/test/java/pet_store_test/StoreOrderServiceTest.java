package pet_store_test;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.testng.Assert;
import org.testng.annotations.Test;
import pet_store.entities.StoreOrder;
import pet_store.steps.StoreOrderServiceSteps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Data
public class StoreOrderServiceTest {


    @Test
    public void createOrderTest() {
        StoreOrder expectedOrder = createOrderBody();
        StoreOrder actualOrder = StoreOrderServiceSteps.createStoreOrder(expectedOrder);
        Assert.assertEquals(actualOrder.getPetId(), expectedOrder.getPetId(), "Expected user does not have the expected name");
    }

    private StoreOrder createOrderBody() {
        return new StoreOrder()
                .setId(4444)
                .setPetId(333)
                .setQuantity(1)
                .setShipDate("2022-10-24T17:24:25.381Z")
                .setStatus("placed")
                .setComplete(true);

    }
    }

//    private User createUser() {
//        Random random = new Random();
//        return new User()
//                .setName("test" + random.nextInt())
//                .setEmail("testEmail" + random.nextInt() + "@gmail.com")
//                .setGender("Male")
//                .setStatus("active");
//    }
//}
