package homeWork.sprint3;

public class Epic extends Task{

    public Epic(String name, String description, String status, int parentId) {
        super(name, description, status, parentId);
    }

    @Override
    public String toString() {
        return "Epic{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", parentId=" + parentId +
                '}';
    }
}
