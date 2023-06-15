package constants;

public class Constants {
    public static class RunVariable {
        public static String server = Servers.JSON_PLACE_HOLDER_URL;
        public static String path = Path.JSON_PLACE_HOLDER_PATH;
    }

    public static class Servers {
        public static String SWAPI_URL = "https://swapi.dev/";
        public static String JSON_PLACE_HOLDER_URL = "https://jsonplaceholder.typicode.com/";
        public static String XML_REQUEST_BIN_URL = "https://eoamta8v0ruexhh.m.pipedream.net";

        public static String GOOGLE_PLACES_URL;
    }

    public static class Path {
        public static String SWAPI_PATH = "api/";
        public static String JSON_PLACE_HOLDER_PATH = "";
        public static String GOOGLE_PLACES_PATH;
    }

    public static class Actions {
        /**
         * swapi actions
         */
        public static String SWAPI_GET_PEOPLE = "people/";
        /**
         * google actions
         */
        public static String GOOGLE_ACTIOND;
        /**
         * json place holder
         */
        public static String JSON_PLACE_HOLDER_GET = "comments/";
        public static String JSON_PLACE_HOLDER_PUT = "posts/1/";
        public static String JSON_PLACE_HOLDER_DELETE = "posts/1/";
        public static String JSON_PLACE_HOLDER_POST = "posts/";
        public static String XML_REQUEST_BIN_POST = "";
    }
}
