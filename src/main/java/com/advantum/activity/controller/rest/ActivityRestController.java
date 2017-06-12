package com.advantum.activity.controller.rest;

import com.advantum.activity.model.Activity;
import com.advantum.activity.service.ActivityNotFoundRuntimeException;
import com.advantum.activity.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author José Sevila <josevilah@gmail.com>
 */
@RestController
@RequestMapping("api/activities")
public class ActivityRestController {

    @Autowired
    private ActivityService activityService;

    /**
     * Rest based method to retrieve the list of activities stored in the repository
     * @return a {@link ResponseEntity} with a {@link List} of {@link Activity} objects
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Activity>> list() {
        List<Activity> activities = activityService.list();
        return new ResponseEntity<List<Activity>>(activities, HttpStatus.OK);
    }

    /**
     * Return an {@link Activity} given its identifier.
     * @param activityId the identifier of the target {@link Activity} to be found
     * @return a {@link ResponseEntity} with code 200 in case the {@link Activity} was found, otherwise returns a 404 status code.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Activity> findOne(@PathVariable("id")  Integer activityId) {
        Activity activity = activityService.findOne(activityId);
        if (activity != null) {
            return new ResponseEntity<Activity>(activity, HttpStatus.OK);
        }  else {
            return new ResponseEntity<Activity>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Adds an {@link Activity} object.
     * @param activity the {@link Activity} to be added
     * @return a {@link ResponseEntity} with code 200 containing the created {@link Activity} object
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Activity> add(@RequestBody Activity activity) {
        Activity createdActivity = activityService.add(activity);
        return new ResponseEntity<Activity>(createdActivity, HttpStatus.OK);
    }

    /**
     * Updates the {@link Activity} identified by {@code activityId} with the given {@code activity} object data.
     * @param activityId the identifier of the target {@link Activity} to be updated
     * @param activity the data object to update the {@link Activity}
     * @return a {@link ResponseEntity} with code 200 containing the updated {@link Activity} object found,
     *          otherwise return a 404 status code, and if the {@code activity}
     *          object is null, then a 400 response code is returned.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Activity> update(@PathVariable("id") Integer activityId, @RequestBody Activity activity) {
        try {
            Activity updatedActivity = activityService.update(activityId, activity);
            return new ResponseEntity<Activity>(updatedActivity, HttpStatus.OK);
        } catch (ActivityNotFoundRuntimeException e) {
            return new ResponseEntity<Activity>(HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<Activity>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Deletes the {@link Activity} with the given {@code activityId}
     * @param activityId
     * @return a {@link ResponseEntity} with status code 200
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Activity> delete(@PathVariable("id") Integer activityId) {
        activityService.delete(activityId);
        return new ResponseEntity<Activity>(HttpStatus.OK);
    }
}
