package test.app.todo.model;

import io.micronaut.core.annotation.Introspected;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import test.constant.DatabaseEntityName;
import test.constant.DatabaseSchemaName;

@Entity(name = DatabaseEntityName.TODO_ENTITY)
@Table(schema = DatabaseSchemaName.TODO_SCHEMA)
@Introspected
public class Todo {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "todo_info")
  @Size(min = 0, max= 255 , message = "Min char count is 0 and Max char count is 255")
  private String todoInfo;

  @Column(name = "is_completed")
  private Boolean isCompleted;

  public Long getId() {
    return id;
  }

  public String getTodoInfo() {
    return todoInfo;
  }

  public Boolean getIsCompleted() {
    return isCompleted;
  }

  public void setTodoId(Long id) {
    this.id = id;
  }

  public void setTodoInfo(String todoInfo) {
    this.todoInfo = todoInfo;
  }

  public void setIsCompleted(Boolean isCompleted) {
    this.isCompleted = isCompleted;
  }
}
