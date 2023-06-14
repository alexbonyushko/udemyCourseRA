package constants;

public class Constants {
    public static class RunVariable {
        public static String server = Servers.SWAPI_URL;
        public static String path = Path.SWAPI_PATH;
    }

    public static class Servers {
        public static String SWAPI_URL = "https://swapi.dev/";
        public static String GOOGLE_PLACES_URL;
    }

    public static class Path {
        public static String SWAPI_PATH = "api/";
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
    }
}
