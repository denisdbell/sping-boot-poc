package com.advantum.activity.controller.rest;

import com.advantum.App;
import com.advantum.activity.model.Activity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
@Transactional
public class ActivityRestControllerIntegrationTest {

    @Autowired
    private ActivityRestController activityRestController;

    @Test
    @Sql("../../repository/dummy-data.sql")
    public void testFindOneActivity() {
        ResponseEntity<Activity> response = activityRestController.findOne(1);
        Activity foundActivity = response.getBody();
        Assert.assertEquals("The \"Activity description 01\" should be found", "Activity description 01", foundActivity.getDescription());
    }

    @Test
    @Sql("../../repository/dummy-data.sql")
    public void testActivityDelaysInFoundActivity() {
        ResponseEntity<Activity> response = activityRestController.findOne(1);
        Activity foundActivity = response.getBody();
        Assert.assertEquals("The \"The activity was delayed\" ActivityDelay should be found", "The activity was delayed", foundActivity.getActivityDelays().get(0).getReason());
    }

    @Test
    @Sql("../../repository/dummy-data.sql")
    public void testUpdateActivity() {
        Activity activity = new Activity();
        activity.setDescription("Modified activity Description");
        activityRestController.update(1, activity);

        ResponseEntity<Activity> response = activityRestController.findOne(1);
        Activity foundActivity = response.getBody();
        Assert.assertEquals("The activity was modified", "Modified activity Description", foundActivity.getDescription());
    }

    @Test
    @Sql("../../repository/dummy-data.sql")
    public void testUpdateActivityWithNullValue() {
        ResponseEntity<Activity> update = activityRestController.update(1, null);
        Assert.assertEquals("400 Bad Request", HttpStatus.BAD_REQUEST, update.getStatusCode());
    }
}
