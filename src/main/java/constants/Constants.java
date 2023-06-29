package constants;

import api.utils.UtilsMethod;

public class Constants {

    public static final String API_TOKEN = UtilsMethod.getValue("TOKEN");

    //https://maps.googleapis.com/maps/api/place/findplacefromtext/output?parameters
    //domain name
    public static class ServerName {
        public static String GOOGLE_PLACE_SERVER = "https://maps.googleapis.com/";
    }

    //path
    public static class Path {
        public static String GOOGLE_PLACE_PATH = "maps/api/place/";
    }

    //endpoint
    public static class Endpoint {
        public static String GOOGLE_PLACE_ENDPOINT_SEARCH_JSON = "findplacefromtext/json";
    }

}
