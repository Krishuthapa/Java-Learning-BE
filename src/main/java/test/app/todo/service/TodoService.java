package test.app.todo.service;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.node.ObjectNode;
import test.app.todo.model.Todo;
import test.app.todo.repository.TodoRepository;

@Singleton
public class TodoService {
  @Inject
  private TodoRepository todoAppRepository;

  /**
   * Calls the function from the repository to
   * obtain all the todos.
   *
   * @return Iterable<Todo>
   */
  @Transactional
  public Iterable<Todo> findAll() {
    return todoAppRepository.findAll();
  }

  /**
   *  Calls the function from the repository to
   *  add the new todo.
   *
   * @param todo
   * @return Todo
   */
  @Transactional
  public Todo add(Todo todo) {
    return todoAppRepository.save(todo);
  }

  /**
   * Deletes the given todo based on the obtained id.
   * @param id
   * @return ObjectNode
   */
  @Transactional
  public ObjectNode deleteById(Long id){
    todoAppRepository.deleteById(id);

    ObjectNode deleteResponse = new ObjectMapper().createObjectNode();

    deleteResponse.put("id",id);

    return deleteResponse;
  }

  /**
   *  Updates the todo based on the given id.
   *
   * @param id
   * @param updatedTodo
   * @return ObjectNode
   */
  @Transactional
  public ObjectNode updateById(Long id, Todo updatedTodo ){
    todoAppRepository.updateById(id, updatedTodo.getIsCompleted());

    ObjectNode updateResponse = new ObjectMapper().createObjectNode();

    updateResponse.put("id", id);

    return updateResponse;
  }
}
