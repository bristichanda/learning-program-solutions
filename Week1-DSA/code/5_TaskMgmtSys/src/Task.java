class Task {
    int taskId;
    String taskName;
    String status;

    public Task(int id, String name, String status) {
        this.taskId = id;
        this.taskName = name;
        this.status = status;
    }

    @Override
    public String toString() {
        return taskId + " - " + taskName + " [" + status + "]";
    }
}
