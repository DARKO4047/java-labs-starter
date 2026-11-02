package edu.course.lab03;

public class ProjectTask {
    private final TaskStatus status;
    private final  int effort;
    public ProjectTask(TaskStatus status, int effort){
        if (effort < 0 || effort >100){
            throw new IllegalArgumentException("Неккоректное значение для затраченного усилия на задачу");
        }
        if (status == null ){
            throw new IllegalArgumentException("Неккоректный статус");
        }
        this.effort = effort;
        this.status = status;
    }
    public TaskStatus getStatus(){
        return this.status;
    }
    public int getEffort(){
        return this.effort;
    }
}
