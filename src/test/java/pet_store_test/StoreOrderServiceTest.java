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
        StoreOrder expectedOrder = createOrder();
        StoreOrder actualOrder = StoreOrderServiceSteps.createStoreOrder(expectedOrder);
        Assert.assertEquals(actualOrder.getPetId(), expectedOrder.getPetId(), "Expected user does not have the expected name");
    }

    private StoreOrder createOrder() {
        Random rand = new Random();
        return new StoreOrder()
                .setId(rand.nextInt())
                .setPetId(rand.nextInt())
                .setQuantity(1)
                .setShipDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
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
