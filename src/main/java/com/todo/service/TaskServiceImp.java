package com.todo.service;

import com.todo.domain.Account;
import com.todo.domain.Task;
import com.todo.repository.AccountRepository;
import com.todo.repository.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class TaskServiceImp implements TasksService {

    private final TaskRepository taskRepository;

    public TaskServiceImp(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task getFirstTask(Account account) {

      //  List<Task> tasks = taskRepository.findAllByAccount(account.getId());
        List<Task> tasks = taskRepository.findAll();
        Optional<Task> task =
                tasks.stream()
                .sorted(Comparator.comparing(Task::getCreationTaskDate, Comparator.nullsLast(Comparator.reverseOrder())))
                .reduce((first, second) -> second);

        if (task.isPresent()) {
            return task.get();
        } else {
            log.error("Ploxo!");
            // TODO: 08.11.2020 Сделать нормальный кастомный эксепшн. ТоДуЭксепшн.
            throw new NullPointerException();
        }

    }

    @Override
    public Task getLastTask(Account account) {

        return null;
    }

    @Override
    public void createTask(Account account, String task) {

    }

    @Override
    public String getTask(Account account, int taskNumber) {
        return null;
    }

    @Override
    public Map<Integer, String> showTasks(Account account) {
        return null;
    }

    @Override
    public void removeTask(Account account, int taskNumber) {

    }
}
