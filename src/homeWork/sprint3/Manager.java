package homeWork.sprint3;

import java.util.HashMap;

public class Manager {
    static int id = 0;
    static Task task;
    static Subtask subtask;
    static Epic epic;
    static HashMap<Integer, Task> tasks = new HashMap<>();
    static HashMap<Integer, Epic> epics = new HashMap<>();
    static HashMap<Integer, Subtask> subtasks =  new HashMap<>();

    public static void main(String[] args) {
        //TODO Создайте 2 задачи, один эпик с 2 подзадачами, а другой эпик с 1 подзадачей.
        createTask(generateId(), new Task("Убраться в квартире", "Плановая уборка в квартире", "NEW"));
        createEpic(generateId(), new Epic("Убрать комнату", "Уборка комнаты","NEW", 1));
        createSubtask(generateId(), new Subtask("Помыть полы", "Мойка полов", "NEW", 1));

        createTask(generateId(), new Task("Собраться в отпуск", "Отпуск", "NEW"));
        createEpic(generateId(), new Epic("Купить тур", "Выбор тура","NEW", 4));
        createSubtask(generateId(), new Subtask("Выбрать страну", "Выбор страны", "NEW", 4));
        createSubtask(generateId(), new Subtask("Выбрать туроператора", "Выбор туроператора", "NEW", 4));
        //TODO Распечатайте списки эпиков, задач и подзадач, через
        System.out.println(tasks.toString());
        System.out.println(epics.toString());
        System.out.println(subtasks.toString());

        //TODO Измените статусы созданных объектов, распечатайте. Проверьте, что статус задачи и подзадачи сохранился, а статус эпика рассчитался по статусам подзадач.

        //TODO И, наконец, попробуйте удалить одну из задач и один из эпиков.

    }

    private void getListTask() {

    }

    private void deleteAllTask() {
        tasks.clear();
    }

    private void getTaskById(int id) {
        tasks.get(id);
    }

    private static void createTask(int id, Task task) {
        tasks.put(id, task);
    }

    private static void createEpic(int parentId, Epic epic) {
        epics.put(parentId, epic);
    }

    private static void createSubtask(int parentId, Subtask subtask) {
        subtasks.put(parentId, subtask);
    }

    private void updateTask(Task task) {
 //       tasks.put(task.getId(), task);
    }

    private void deleteById(Task task) {
 //       tasks.remove(task.getId());
    }

    private void getSubtaskByEpic() {

    }

    private static int generateId() {
        return ++id;
    }
}
