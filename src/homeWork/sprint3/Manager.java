package homeWork.sprint3;

import java.util.ArrayList;

public class Manager {

    private static ArrayList<Task> tasks = new ArrayList();
    private static ArrayList<Epic> epics = new ArrayList();
    private static ArrayList<Subtask> subtasks =  new ArrayList();

    public static void main(String[] args) {
        int parentId;
        //TODO Создайте 2 задачи, один эпик с 2 подзадачами, а другой эпик с 1 подзадачей.
        createTask(new Task("Убраться в квартире", "Плановая уборка в квартире", "NEW"));
        parentId = tasks.indexOf(new Task("Убраться в квартире", "Плановая уборка в квартире", "NEW"));
        createEpic(new Epic("Убрать комнату", "Уборка комнаты","NEW", parentId));
        createSubtask(new Subtask("Помыть полы", "Мойка полов", "NEW", parentId));

        createTask(new Task("Собраться в отпуск", "Отпуск", "NEW"));
        parentId = tasks.indexOf(new Task("Собраться в отпуск", "Отпуск", "NEW"));
        createEpic(new Epic("Купить тур", "Выбор тура","NEW", parentId));
        createSubtask(new Subtask("Выбрать страну", "Выбор страны", "DONE", parentId));
        createSubtask(new Subtask("Выбрать туроператора", "Выбор туроператора", "NEW", parentId));
        //TODO Распечатайте списки эпиков, задач и подзадач, через System.out.println
        System.out.println("Задачи : " + tasks.toString());
        System.out.println("Эпики : " + epics.toString());
        System.out.println("Поздазачи : " + subtasks.toString() + "\n");

        //TODO Измените статусы созданных объектов, распечатайте. Проверьте, что статус задачи и подзадачи сохранился, а статус эпика рассчитался по статусам подзадач.
        updateSubtask(subtasks.indexOf(
                new Subtask("Выбрать туроператора",
                        "Выбор туроператора",
                        "NEW",
                        tasks.indexOf(new Task(
                                "Собраться в отпуск",
                                "Отпуск",
                                "NEW")))),
                new Subtask("Выбрать туроператора",
                        "Выбор туроператора",
                        "DONE", parentId));

        System.out.println("Задачи : " + tasks.toString());
        System.out.println("Эпики : " + epics.toString());
        System.out.println("Подзадачи : " + subtasks.toString() + "\n");

        System.out.println("getListTask = " + getListTask()  + "\n");

        System.out.println("getTaskById = " + getTaskById(1)  + "\n");

        updateTask(tasks.indexOf(new Task("Убраться в квартире", "Плановая уборка в квартире", "NEW")),
                new Task("Убраться в квартире на выходных", "Плановая уборка в квартире", "NEW"));

        System.out.println("Задачи : " + tasks.toString());
        System.out.println("Эпики : " + epics.toString());
        System.out.println("Подзадачи : " + subtasks.toString() + "\n");

        updateEpic(epics.indexOf(new Epic("Купить тур", "Выбор тура","DONE", tasks.indexOf(new Task("Собраться в отпуск", "Отпуск", "NEW")))),
                new Epic("Купить тур на море", "Выбор тура","DONE", tasks.indexOf(new Task("Собраться в отпуск", "Отпуск", "NEW"))));

        System.out.println("Задачи : " + tasks.toString());
        System.out.println("Эпики : " + epics.toString());
        System.out.println("Подзадачи : " + subtasks.toString() + "\n");

        System.out.println("getSubtasksByEpic = " + getSubtasksByEpic(1)  + "\n");

        //TODO И, наконец, попробуйте удалить одну из задач и один из эпиков.
        deleteByIdTask(1);
        deleteByIdEpic(1);
        deleteByIdSubtask(1);

        System.out.println("Задачи : " + tasks.toString());
        System.out.println("Эпики : " + epics.toString());
        System.out.println("Подзадачи : " + subtasks.toString() + "\n");

        deleteAllTask();

        System.out.println("Задачи : " + tasks.toString());
        System.out.println("Эпики : " + epics.toString());
        System.out.println("Подзадачи : " + subtasks.toString() + "\n");
    }

    private static ArrayList<Task> getListTask() {
        return tasks;
    }

    private static void deleteAllTask() {
        tasks.clear();
    }

    private static Task getTaskById(int id) {
        return tasks.get(id);
    }

    private static void createTask(Task task) {
        tasks.add(task);
    }

    private static void createEpic(Epic epic) {
        epics.add(epic);
    }

    private static void createSubtask(Subtask subtask) {
        subtasks.add(subtask);
        calculateStatusEpic(subtask);
    }

    private static void updateTask(int id, Task task) {
        tasks.set(id, task);
    }

    private static void updateEpic(int id, Epic epic) {
        epics.set(id, epic);
    }

    private static void updateSubtask(int id, Subtask subtask) {
        subtasks.set(id, subtask);

        calculateStatusEpic(subtask);
    }

    private static void deleteByIdTask(int id) {
        tasks.remove(id);
    }

    private static void deleteByIdEpic(int id) {
        epics.remove(id);
    }

    private static void deleteByIdSubtask(int id) {
        subtasks.remove(id);
    }

    private static ArrayList<Subtask> getSubtasksByEpic(int epicParentId) {
        ArrayList<Subtask> buf = new ArrayList<>();
        for (Subtask s : subtasks)
            if(s.parentId == epicParentId)
                buf.add(s);
        return buf;
    }

    private static void calculateStatusEpic(Subtask subtask){
        int statusNew = 0;
        int statusDone = 0;
        int statusInProgress = 0;
        for (Subtask s : subtasks)
            if(s.parentId == subtask.parentId)
                switch (s.status){
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
}
