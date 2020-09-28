package test.app.todo.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import test.app.todo.model.Todo;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {

    /**
     * Function to update the value of "is_completed" based on the id given.
     *
     * @param id
     * @param isCompleted
     */
    void updateById(Long id, Boolean isCompleted);
}
