package edu.course.lab02;
public class ProjectTask {
    private final String id;
    private final String title;
    private TaskStatus status;
    private int estimatedHours;

    public ProjectTask(String id, String title, TaskStatus status, int estimatedHours){
        if (id == null || id.isEmpty()){
            throw new IllegalArgumentException("Значение не может быть пустым");
        }
        if (title == null || title.isEmpty()){
            throw new IllegalArgumentException("Значение не может быть пустым");
        }
        if (status == null ){
            throw new IllegalArgumentException("Значение не может быть пустым");
        }
        if (estimatedHours < 0 ){
            throw new IllegalArgumentException("Значение не может быть отрицательным");
        }
        this.id = id;
        this.title = title;
        this.status = status;
        this.estimatedHours = estimatedHours;
    }

    public void changeStatus(TaskStatus newStatus){
        if (newStatus == null ){
            throw new IllegalArgumentException("Значение не может быть пустым");
        }
        else {
            this.status= newStatus;
        }
    }

    public boolean isTaskDone (){
        if (status == TaskStatus.DONE){
            return true;
        }
        else {
            return false;
        }
    }
    public void addEstimatedHours(int hours){
        if ( hours <= 0 ){
            throw new IllegalArgumentException("Значение олжно быть положительным");
        }
        else {
            this.estimatedHours += hours;
        }
    }
    public String getId (){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public TaskStatus getStatus(){
        return status;
    }
    public int getEstimatedHours(){
        return estimatedHours;
    }

}
