package homeWork.sprint3;

public class Subtask extends Task{

    public Subtask(String name, String description, String status, int parentId) {
        super(name, description, status, parentId);
    }

    @Override
    public String toString() {
        return "Subtask{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", parentId=" + parentId +
                '}';
    }
}
