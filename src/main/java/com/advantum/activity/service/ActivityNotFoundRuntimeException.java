package com.advantum.activity.service;

/**
 * The <code>ActivityNotFoundRuntimeException</code> may be raised by a method to indicate that
 * the <code>Activity</code> instance with the given <code>activityId</code> was not found in the
 * repository.
 *
 * @author Sevila <josevilah@gmail.com>
 */
public class ActivityNotFoundRuntimeException extends RuntimeException {

    /**
     * Identifier that does not correspond to any Activity
     */
    private final  Integer activityId;

    public ActivityNotFoundRuntimeException(Integer activityId) {
        this.activityId = activityId;
    }

    @Override
    public String getMessage() {
        return "Activity with id: " + activityId + " not found.";
    }
}
