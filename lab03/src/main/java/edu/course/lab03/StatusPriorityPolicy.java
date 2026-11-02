package edu.course.lab03;

public class StatusPriorityPolicy implements PriorityPolicy{
    @Override
    public int calculatePriority(ProjectTask task){
        if (task.getStatus()== TaskStatus.TO_DO){
            return 100;
        } else if (task.getStatus()==TaskStatus.IN_WORK){
            return 50;
        }
        else {
            return 0;
        }
    }
}
