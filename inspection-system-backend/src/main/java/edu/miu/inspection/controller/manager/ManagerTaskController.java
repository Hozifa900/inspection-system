package edu.miu.inspection.controller.manager;

import edu.miu.inspection.model.Task;
import edu.miu.inspection.model.User;
import edu.miu.inspection.model.dto.request.CreateTaskRequest;
import edu.miu.inspection.model.dto.response.PageableResponse;
import edu.miu.inspection.model.enums.TaskStatus;
import edu.miu.inspection.service.TaskService;
import edu.miu.inspection.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ManagerTaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;

    @PostMapping("/api/manager/tasks")
    public ResponseEntity<Task> save(@RequestBody CreateTaskRequest taskRequest) {

        User inspector = userService.findById(taskRequest.getInspectorId());
        User manager = userService.getCurrentUser();

        Task task = new Task();
        task.setTitle(taskRequest.getTitle());
        task.setInspector(inspector);
        task.setFormType(taskRequest.getFormType());
        task.setLocation(taskRequest.getLocation());
        task.setStatus(TaskStatus.CREATED.getValue());
        task.setDueDate(taskRequest.getDueDate());
        task.setManager(manager);

        Task createdTask = taskService.save(task);

        return ResponseEntity.ok(createdTask);
    }

    @GetMapping("/api/manager/tasks")
    public ResponseEntity<PageableResponse<Task>> getTasksWithPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Task> taskPage = taskService.findAllByManager(this.userService.getCurrentUser(), pageRequest);

        PageableResponse<Task> response = new PageableResponse<>();
        response.setContent(taskPage.getContent());
        response.setTotalElements(taskPage.getTotalElements());
        response.setTotalPages(taskPage.getTotalPages());
        response.setNumber(page);
        response.setSize(size);
        response.setNumberOfElements(taskPage.getNumberOfElements());

        return ResponseEntity.ok(response);

    }

}
