package pet_store.entities;

import lombok.Data;
import lombok.experimental.Accessors;

//@EqualsAndHashCode
@Data
@Accessors(chain = true)
public class StoreOrder {
    private int id;
    private int petId;
    private int quantity;
    private String shipDate;
    private String status;
    private boolean complete;
}
/**
 order placed for purchasing the pet

 Example Value
 Model
 {
 "id": 0,
 "petId": 0,
 "quantity": 0,
 "shipDate": "2022-10-24T16:59:13.720Z",
 "status": "placed",
 "complete": true
 }*/