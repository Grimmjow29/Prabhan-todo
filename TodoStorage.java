package com.prabhan.todo;




import java.util.List;


public interface TodoStorage {
    void save(Todo todo);
    Todo retrieve(String id);
    List<Todo> retrieveAll();
    void update(Todo todo);
    void delete(String id);
}
