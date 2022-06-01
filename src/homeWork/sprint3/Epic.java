package homeWork.sprint3;

public class Epic extends Task{
    protected int parentId;

    public Epic(String name, String description, String status, int parentId) {
        super(name, description, status);
        this.parentId = parentId;
    }
}
