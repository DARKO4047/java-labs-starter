package edu.course.lab02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProjectTaskTest {

    @Test
    void createsTaskWithCorrectValues() {
        ProjectTask task = new ProjectTask("TASK-1", "Test task", TaskStatus.TODO, 5);
        assertEquals("TASK-1", task.getId());
        assertEquals("Test task", task.getTitle());
        assertEquals(TaskStatus.TODO, task.getStatus());
        assertEquals(5, task.getEstimatedHours());
    }

    @Test
    void rejectsNullId() {
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask(null, "Test task", TaskStatus.TODO, 5));
    }

    @Test
    void rejectsEmptyId() {
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("", "Test task", TaskStatus.TODO, 5));
    }

    @Test
    void rejectsNullTitle() {
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("TASK-1", null, TaskStatus.TODO, 5));
    }

    @Test
    void rejectsEmptyTitle() {
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("TASK-1", "", TaskStatus.TODO, 5));
    }

    @Test
    void rejectsNullStatus() {
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("TASK-1", "Test task", null, 5));
    }

    @Test
    void rejectsNegativeEstimatedHours() {
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("TASK-1", "Test task", TaskStatus.TODO, -1));
    }

    @Test
    void allowsZeroEstimatedHours() {
        ProjectTask task = new ProjectTask("TASK-1", "Test task", TaskStatus.TODO, 0);
        int result = task.getEstimatedHours();
        assertEquals(0, result);
    }

    @Test
    void changeStatusUpdatesStatus() {
        ProjectTask task = new ProjectTask("TASK-1", "Test task", TaskStatus.TODO, 5);
        task.changeStatus(TaskStatus.IN_PROGRESS);
        TaskStatus result = task.getStatus();
        assertEquals(TaskStatus.IN_PROGRESS, result);
    }

    @Test
    void rejectsNullStatusChange() {
        ProjectTask task = new ProjectTask("TASK-1", "Test task", TaskStatus.TODO, 5);
        assertThrows(IllegalArgumentException.class, () -> task.changeStatus(null));
        assertEquals(TaskStatus.TODO, task.getStatus());
    }

    @Test
    void returnsFalseForUnfinishedTask() {
        ProjectTask task = new ProjectTask("TASK-1", "Test task", TaskStatus.TODO, 5);
        boolean result = task.isTaskDone();
        assertFalse(result);
    }

    @Test
    void returnsTrueForCompletedTask() {
        ProjectTask task = new ProjectTask("TASK-1", "Test task", TaskStatus.DONE, 5);
        boolean result = task.isTaskDone();
        assertTrue(result);
    }

    @Test
    void addingHoursIncreasesEstimate() {
        ProjectTask task = new ProjectTask("TASK-1", "Test task", TaskStatus.TODO, 5);
        task.addEstimatedHours(3);
        int result = task.getEstimatedHours();
        assertEquals(8, result);
    }

    @Test
    void rejectsZeroAdditionalHours() {
        ProjectTask task = new ProjectTask("TASK-1", "Test task", TaskStatus.TODO, 5);
        assertThrows(IllegalArgumentException.class, () -> task.addEstimatedHours(0));
        assertEquals(5, task.getEstimatedHours());
    }

    @Test
    void rejectsNegativeAdditionalHours() {
        ProjectTask task = new ProjectTask("TASK-1", "Test task", TaskStatus.TODO, 5);
        assertThrows(IllegalArgumentException.class, () -> task.addEstimatedHours(-2));
        assertEquals(5, task.getEstimatedHours());
    }

    @Test
    void idAndTitleRemainUnchanged() {
        ProjectTask task = new ProjectTask("TASK-1", "Test task", TaskStatus.TODO, 5);
        task.changeStatus(TaskStatus.IN_PROGRESS);
        task.addEstimatedHours(2);
        assertEquals("TASK-1", task.getId());
        assertEquals("Test task", task.getTitle());
    }
}