package com.prabhan.todo;

import java.util.List;


public class TodoService {
    private final TodoStorage storage;

    public TodoService(TodoStorage storage) {
        this.storage = storage;
    }

    public void create(Todo todo) {
        storage.save(todo);
    }

    public Todo retrieve(String id) {
        return storage.retrieve(id);
    }

    public List<Todo> retrieveAll() {
        return storage.retrieveAll();
    }

    public void update(Todo todo) {
        storage.update(todo);
    }

    public void delete(String id) {
        storage.delete(id);
    }
}
