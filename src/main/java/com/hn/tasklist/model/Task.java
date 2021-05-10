package com.hn.tasklist.model;

/**
 * The entity of task
 *
 * @author fsaldanha
 */
public class Task {

    private Integer id;

    private String label;

    private boolean complete;

    public Task(){}

    public Task(Integer id, String label) {
        this.id = id;
        this.label = label;
        this.complete = false;
    }

    /**
     * Return the id of task.
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Return the label of task.
     *
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Set the label of task.
     *
     * @param label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Return true if the task is completed.
     *
     * @return complete
     */
    public boolean isComplete() {
        return complete;
    }

    /**
     * Change the status of task.
     *
     * @param complete
     */
    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
