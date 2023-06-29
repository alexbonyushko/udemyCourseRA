package constants;

public class Constants {

    //https://maps.googleapis.com/maps/api/place/findplacefromtext/output?parameters
    //domain name
    public static class ServerName {
        public static String GOOGLE_PLACE_SERVER = "https://maps.googleapis.com/maps/";
    }

    //path
    public static class Path {
        public static String GOOGLE_PLACE_PATH = "/api/place/";
    }

    //endpoint
    public static class Endpoint {
        public static String GOOGLE_PLACE_ENDPOINT_SEARCH_JSON = "findplacefromtext/json";
    }

}
