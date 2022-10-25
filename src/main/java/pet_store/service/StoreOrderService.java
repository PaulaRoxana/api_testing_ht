package pet_store.service;

import io.restassured.response.Response;
import pet_store.service.uritemplate.UriTemplate;

public class StoreOrderService extends CommonService {

    private StoreOrderService() {
    }

    ;//default constructor
    private static StoreOrderService instance;

    //singleton; saves, creates
    public static StoreOrderService getInstance() {
        if (instance == null) {
            instance = new StoreOrderService();
        }
        return instance;
    }

    public Response getRequest(UriTemplate uri) {
        return super.getRequest(uri.getUri());
    }

    public Response getRequest(UriTemplate uri, int id) {
        return super.getRequest(uri.getUri(id));
    }

    public Response getRequestAfterDelete(UriTemplate uri, int id) {
        return super.getRequestAfterDelete(uri.getUri(id));
    }

    public Response postRequest(UriTemplate uri, Object body) {
        return super.postRequest(uri.getUri(), body);
    }

    public void deleteRequest(UriTemplate uri, int id) {
        super.deleteRequest(uri.getUri(id));
    }
}
