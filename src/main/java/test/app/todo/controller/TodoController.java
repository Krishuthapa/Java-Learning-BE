package test.app.todo.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

import test.app.todo.model.Todo;
import test.app.todo.service.TodoService;

import javax.inject.Inject;

@Controller("/todos")
public class TodoController {
  @Inject
  private TodoService todoAppService;

  @Get("/")
  public HttpResponse findAll() {
    return HttpResponse.ok(todoAppService.findAll());
  }

  @Post("/")
  public HttpResponse add(@Body Todo todo) {
    return HttpResponse.ok(todoAppService.add(todo));
  }


  @Delete("/{id}")
  public HttpResponse deleteById(@PathVariable("id") Long id) {
    return HttpResponse.ok(todoAppService.deleteById(id));
  }

  @Patch("/{id}")
    public HttpResponse update(@PathVariable("id") Long id, @Body Todo todo) {
        return HttpResponse.ok(todoAppService.updateById(id, todo));
    }
}
