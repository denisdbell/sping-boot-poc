package com.advantum.activity.service;

import com.advantum.App;
import com.advantum.activity.model.Activity;
import com.advantum.activity.model.ActivityDelay;
import com.advantum.activity.model.ActivityType;
import com.advantum.activity.model.User;
import com.advantum.activity.repository.ActivityTypeRepository;
import com.advantum.activity.repository.UserRepository;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Denis Bell
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional()
@SpringApplicationConfiguration(App.class)
public class ActivityServiceIntegrationTest {

    @Autowired
    private ActivityService activityService;

    @Autowired
    private ActivityTypeRepository activityTypeRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    @Sql("../repository/dummy-data.sql")
    public void testCreateActivity() {
        ActivityType activityType = activityTypeRepository.getOne(1);
        User user = userRepository.getOne(1);
        Activity activity = new Activity(1, "Activity Created from Service", new Date(), new Date(), "test", activityType, new ArrayList<ActivityDelay>(), user);

        activityService.add(activity);

        List<Activity> activityList = activityService.list();
        Assert.assertTrue("There is one created activity", activityList.size() == 1);

        Activity activityFound = activityList.get(0);
        Assert.assertEquals("The found activity is the created one", activityFound.getActivityId(), activity.getActivityId());
    }

    @Test
    @Sql("../repository/dummy-data.sql")
    public void testFindActivity() {
        Activity activity = activityService.findOne(1);
        Assert.assertEquals("Found Activity with Id 1", "Activity description 01", activity.getDescription());
    }

    @Test
    @Sql("../repository/dummy-data.sql")
    public void testFindFakeActivity() {
        Activity activity = activityService.findOne(9999);
        Assert.assertNull("There should be no Activity found", activity);
    }

    @Test
    @Sql("../repository/dummy-data.sql")
    public void testUpdateActivity() {
        Activity activity = activityService.findOne(1);
        activity.setDescription("Activity Modified");
        activityService.update(activity.getActivityId(), activity);

        Activity targetActivity = activityService.findOne(1);
        Assert.assertEquals("Activity description was correctl modified", "Activity Modified", targetActivity.getDescription());
    }

    @Test
    @Sql("../repository/dummy-data.sql")
    public void testUpdateNonExistentActivity() {
        Exception targetException = null;
        try {
            Activity activity = activityService.findOne(1);
            activity.setDescription("Activity Modified");
            activityService.update(100, activity);
        } catch(Exception e) {
            targetException = e;
        }
        Assert.assertNotNull("An exception must be thrown", targetException);
    }

    @Test
    @Sql("../repository/dummy-data.sql")
    public void testDeleteActivity() {
        activityService.delete(1);

        Activity targetActivity = activityService.findOne(1);

        Assert.assertNull("Activity was deleted", targetActivity);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testCreateNullActivity() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("The given activity must not be null");
        activityService.add(null);
    }

    @Test
    public void testFindOneActivityWithIdNull() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("The given id must not be null");
        activityService.findOne(null);
    }

    @Test
    public void testDeleteActivityWithNullAsId() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("The given id must not be null");
        activityService.delete(null);
    }

    @Test
    @Sql("../repository/dummy-data.sql")
    public void testUpdateActivityWithNullAsId() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("The given activityId must not be null");

        Activity activity = activityService.findOne(1);
        activity.setDescription("Activity Modified");
        activityService.update(null, activity);
    }

    @Test
    @Sql("../repository/dummy-data.sql")
    public void testUpdateActivityWithNullAsActivity() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("The given activity must not be null");

        activityService.update(1, null);
    }
}
