package homeWork.sprint3;

import java.util.HashMap;

public class Manager {
    Task task = new Task();
    Subtask subtask = new Subtask();
    Epic epic = new Epic();
    HashMap<Integer, Task> tasks = new HashMap<>();
    HashMap<Integer, Epic> epics = new HashMap<>();
    HashMap<Integer, Subtask> subtasks =  new HashMap<>();

    public static void main(String[] args) {
//TO DO Создайте 2 задачи, один эпик с 2 подзадачами, а другой эпик с 1 подзадачей.

    }

    private void getListTask() {

    }

    private void deleteAllTask() {
        tasks.clear();
    }

    private void getTaskById(int id) {
        tasks.get(id);
    }

    private void createTask(Task task) {
        tasks.put(task.getId(), task);
    }

    private void updateTask(Task task) {
        tasks.put(task.getId(), task);
    }

    private void deleteById(Task task) {
        tasks.remove(task.getId());
    }

    private void getSubtaskByEpic() {

    }
}
