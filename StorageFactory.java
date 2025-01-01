package com.prabhan.todo;

public class StorageFactory {
    public static TodoStorage getStorage(String storageType) {
        return switch (storageType.toUpperCase()) {
            case "MYSQL" -> new MySQLTodoStorage();
            // return new MongoDBTodoStorage();
            // return new PostgreSQLTodoStorage();
            default -> throw new IllegalArgumentException("Unsupported storage type: " + storageType);
        };
    }
}
