
package edu.course.lab03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatusPriorityPolicyTest {

    @Test
    public void testToDoPriority() {
        StatusPriorityPolicy policy = new StatusPriorityPolicy();

        ProjectTask task = new ProjectTask(TaskStatus.TO_DO, 5);

        assertEquals(100, policy.calculatePriority(task));
    }

    @Test
    public void testInWorkPriority() {
        StatusPriorityPolicy policy = new StatusPriorityPolicy();

        ProjectTask task = new ProjectTask(TaskStatus.IN_WORK, 10);

        assertEquals(50, policy.calculatePriority(task));
    }

    @Test
    public void testDonePriority() {
        StatusPriorityPolicy policy = new StatusPriorityPolicy();

        ProjectTask task = new ProjectTask(TaskStatus.DONE, 0);

        assertEquals(0, policy.calculatePriority(task));
    }
}
