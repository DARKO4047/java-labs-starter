package edu.course.lab03;

public class TaskPrioritizer{
    private final PriorityPolicy policy;
    public TaskPrioritizer(PriorityPolicy policy){
        this.policy=policy;
    }
    public ProjectTask calculate(ProjectTask firstTask, ProjectTask secondTask){
        int firstTaskPriority = policy.calculatePriority(firstTask);
        int secondTaskPriority = policy.calculatePriority(secondTask);
        if (firstTaskPriority >= secondTaskPriority){
            return firstTask;
        }
        else {
            return secondTask;
        }
    }
}
