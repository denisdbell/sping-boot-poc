package com.advantum.activity.service;

import com.advantum.activity.model.Activity;
import com.advantum.activity.repository.ActivityRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Allows operations on Activity business object according to business rules.
 *
 * @author Denis Bell
 */
@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    /**
     * Adds an activity to the repository.
     * @param activity the object to be added. The method does not allow {@code null} value.
     * @return the created activity
     * @throws IllegalArgumentException if the argument passed is null
     */
    public Activity add(Activity activity) {
        checkNull("activity", activity);
        return activityRepository.saveAndFlush(activity);
    }

    /**
     * Returns all the activities in the repository.
     * @return list of activities
     */
    public List<Activity> list() {
        return activityRepository.findAll();
    }

    /**
     * Returns an activity given its id.
     * @param id the {@code Activity} identifier
     * @return the found {@code Activity}
     * @throws IllegalArgumentException if the {@code id} argument is {@code null}
     */
    public Activity findOne(Integer id) {
        checkNull("id", id);
        return activityRepository.findOne(id);
    }

    private void checkNull(String name, Object object) {
        if (object == null) {
            throw new IllegalArgumentException("The given " + name + " must not be null");
        }
    }

    /**
     * Updates the {@link Activity} identified by {@code id} with the given {@code activity} data.
     * @param activityId the {@link Activity} identifier
     * @param activity the data used to update the activity
     * @return the updated {@link Activity}
     * @throws IllegalArgumentException if the {@code activityId} or the {@code activity} are null
     */
    public Activity update(Integer activityId, Activity activity) {
        checkNull("activityId", activityId);
        checkNull("activity", activity);
        Activity targetActivity = activityRepository.getOne(activityId);
        if (targetActivity == null) {
            throw new ActivityNotFoundRuntimeException(activityId);
        }
        BeanUtils.copyProperties(activity, targetActivity);
        return activityRepository.save(targetActivity);
    }

    /**
     * Deletes the {@link Activity} with the given {@code id}.
     * @param id the {@link Activity} identifier to delete
     * @throws IllegalArgumentException if the {@code id} is null
     */
    public void delete(Integer id) {
        checkNull("id", id);
        activityRepository.delete(id);
    }
}
