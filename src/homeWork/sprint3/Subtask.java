package homeWork.sprint3;

public class Subtask extends Task{
    protected int parentId;

    public Subtask(String name, String description, String status, int parentId) {
        super(name, description, status);
        this.parentId = parentId;
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
