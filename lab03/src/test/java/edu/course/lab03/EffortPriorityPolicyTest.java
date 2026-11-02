
package edu.course.lab03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EffortPriorityPolicyTest {

    @Test
    public void testPriorityForFiveEffort() {
        EffortPriorityPolicy policy = new EffortPriorityPolicy();

        ProjectTask task = new ProjectTask(TaskStatus.TO_DO, 5);

        assertEquals(5, policy.calculatePriority(task));
    }

    @Test
    public void testPriorityForTenEffort() {
        EffortPriorityPolicy policy = new EffortPriorityPolicy();

        ProjectTask task = new ProjectTask(TaskStatus.IN_WORK, 10);

        assertEquals(10, policy.calculatePriority(task));
    }

    @Test
    public void testPriorityForZeroEffort() {
        EffortPriorityPolicy policy = new EffortPriorityPolicy();

        ProjectTask task = new ProjectTask(TaskStatus.DONE, 0);

        assertEquals(0, policy.calculatePriority(task));
    }
}
