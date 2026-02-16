package com.back.config;

public final class GetEnv {

    private GetEnv() {
        // impede instanciação
    }

    public static String mongoUri() {
        return getenv("MONGO_URI");
    }

    public static String mongoDatabase() {
        return getenv("DATABASE_NAME");
    }

    public static String redisHost() {
        return getenv("REDIS_HOST");
    }

    public static int redisPort() {
        return Integer.parseInt(getenv("REDIS_PORT"));
    }

 
    private static String getenv(String key) {
        String value = System.getenv(key);

        return value;
    }
}
