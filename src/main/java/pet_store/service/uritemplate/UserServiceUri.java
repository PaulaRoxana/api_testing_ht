package pet_store.service.uritemplate;

public class UserServiceUri {
    public static final UriTemplate PLACE_ORDER = new UriTemplate("store/order");
    public static final UriTemplate ORDER_BY_ID = new UriTemplate("/store/order/%s");

}
