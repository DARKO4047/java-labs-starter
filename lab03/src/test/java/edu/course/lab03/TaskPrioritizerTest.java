
package edu.course.lab03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class TaskPrioritizerTest {

    @Test
    public void testChooseByEffort() {
        TaskPrioritizer prioritizer =
                new TaskPrioritizer(new EffortPriorityPolicy());

        ProjectTask firstTask =
                new ProjectTask(TaskStatus.TO_DO, 5);

        ProjectTask secondTask =
                new ProjectTask(TaskStatus.IN_WORK, 10);

        assertSame(secondTask,
                prioritizer.calculate(firstTask, secondTask));
    }

    @Test
    public void testChooseByStatus() {
        TaskPrioritizer prioritizer =
                new TaskPrioritizer(new StatusPriorityPolicy());

        ProjectTask firstTask =
                new ProjectTask(TaskStatus.TO_DO, 5);

        ProjectTask secondTask =
                new ProjectTask(TaskStatus.IN_WORK, 10);

        assertSame(firstTask,
                prioritizer.calculate(firstTask, secondTask));
    }

    @Test
    public void testEqualPriorities() {
        TaskPrioritizer prioritizer =
                new TaskPrioritizer(new EffortPriorityPolicy());

        ProjectTask firstTask =
                new ProjectTask(TaskStatus.TO_DO, 5);

        ProjectTask secondTask =
                new ProjectTask(TaskStatus.IN_WORK, 5);

        assertSame(firstTask,
                prioritizer.calculate(firstTask, secondTask));
    }

    @Test
    public void testReplaceStrategy() {
        ProjectTask firstTask =
                new ProjectTask(TaskStatus.TO_DO, 5);

        ProjectTask secondTask =
                new ProjectTask(TaskStatus.IN_WORK, 10);

        TaskPrioritizer effortPrioritizer =
                new TaskPrioritizer(new EffortPriorityPolicy());

        TaskPrioritizer statusPrioritizer =
                new TaskPrioritizer(new StatusPriorityPolicy());

        assertSame(secondTask,
                effortPrioritizer.calculate(firstTask, secondTask));

        assertSame(firstTask,
                statusPrioritizer.calculate(firstTask, secondTask));
    }

    @Test
    public void testTasksAreNotChanged() {
        TaskPrioritizer prioritizer =
                new TaskPrioritizer(new EffortPriorityPolicy());

        ProjectTask firstTask =
                new ProjectTask(TaskStatus.TO_DO, 5);

        ProjectTask secondTask =
                new ProjectTask(TaskStatus.IN_WORK, 10);

        prioritizer.calculate(firstTask, secondTask);

        assertSame(TaskStatus.TO_DO, firstTask.getStatus());
        assertSame(TaskStatus.IN_WORK, secondTask.getStatus());

        org.junit.jupiter.api.Assertions.assertEquals(
                5, firstTask.getEffort());

        org.junit.jupiter.api.Assertions.assertEquals(
                10, secondTask.getEffort());
    }
}
