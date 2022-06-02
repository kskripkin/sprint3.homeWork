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
        createTask(new Task("Убраться в квартире", "Плановая уборка в квартире", "NEW", 1));
        createEpic(new Epic("Убрать комнату", "Уборка комнаты","NEW", 1));
        createSubtask(new Subtask("Помыть полы", "Мойка полов", "NEW", 1));
       // createSubtask(new Subtask("Выбрать туроператора", "Выбор туроператора", "DONE", 1));

        createTask(new Task("Собраться в отпуск", "Отпуск", "NEW", 3));
        createEpic(new Epic("Купить тур", "Выбор тура","NEW", 3));
        createSubtask(new Subtask("Выбрать страну", "Выбор страны", "DONE", 3));
        System.out.println("Задачи : " + tasks.toString());
        System.out.println("Эпики : " + epics.toString());
        System.out.println("Поздазачи : " + subtasks.toString() + "\n");
        createSubtask(new Subtask("Выбрать туроператора", "Выбор туроператора", "DONE", 3));
        //TODO Распечатайте списки эпиков, задач и подзадач, через
        System.out.println("Задачи : " + tasks.toString());
        System.out.println("Эпики : " + epics.toString());
        System.out.println("Подзадачи : " + subtasks.toString());

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

    private static void createTask(Task task) {
        tasks.put(id, task);
    }

    private static void createEpic(Epic epic) {
        epics.put(generateId(), epic);
    }

    private static void createSubtask(Subtask subtask) {
        subtasks.put(generateId(), subtask);
        int statusNew = 0;
        int statusDone = 0;
        int statusInProgress = 0;
        for (int i : subtasks.keySet())
            if(subtasks.get(i).parentId == subtask.parentId)
            switch (subtasks.get(i).status){
                case "NEW":
                    statusNew++;
                    break;
                case "DONE":
                    statusDone++;
                    break;
                case "IN_PROGRESS":
                    statusInProgress++;
                    break;
        }
        if (statusNew == 0 && statusInProgress == 0) {
            epics.get(subtask.parentId).status = "DONE";
        } else if (statusInProgress == 0 && statusDone == 0){
            epics.get(subtask.parentId).status = "NEW";
        } else {
            epics.get(subtask.parentId).status = "IN_PROGRESS";
        }


    }

    private void updateTask(Task task) {
  //      tasks.put(task.getId(), task);
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
