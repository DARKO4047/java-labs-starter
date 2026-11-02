
package edu.course.lab03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProjectTaskTest {

    @Test
    public void testCreateProjectTask() {
        ProjectTask task = new ProjectTask(TaskStatus.TO_DO, 5);

        assertEquals(TaskStatus.TO_DO, task.getStatus());
        assertEquals(5, task.getEffort());
    }

    @Test
    public void testZeroEffort() {
        ProjectTask task = new ProjectTask(TaskStatus.TO_DO, 0);

        assertEquals(0, task.getEffort());
    }

    @Test
    public void testMaximumEffort() {
        ProjectTask task = new ProjectTask(TaskStatus.IN_WORK, 100);

        assertEquals(100, task.getEffort());
    }

    @Test
    public void testNegativeEffort() {
        assertThrows(IllegalArgumentException.class,
                () -> new ProjectTask(TaskStatus.TO_DO, -5));
    }

    @Test
    public void testEffortAboveLimit() {
        assertThrows(IllegalArgumentException.class,
                () -> new ProjectTask(TaskStatus.TO_DO, 101));
    }

    @Test
    public void testNullStatus() {
        assertThrows(IllegalArgumentException.class,
                () -> new ProjectTask(null, 5));
    }
}
