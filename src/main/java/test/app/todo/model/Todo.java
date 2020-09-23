package test.app.todo;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import test.constant.DatabaseEntityName;
import test.constant.DatabaseSchemaName;

@Entity(name = DatabaseEntityName.TODO_ENTITY)
@Table(schema = DatabaseSchemaName.TODO_SCHEMA)
public class Todo {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "todo_info")
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
