package com.advantum.activity.repository;

import com.advantum.App;
import com.advantum.activity.model.Activity;
import com.advantum.activity.model.ActivityDelay;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Denis Bell
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional()
@SpringApplicationConfiguration(App.class)
@Profile(value = "integration")
public class ActivityRepositoryIntegrationTest {

    @Autowired
    private ActivityRepository activityRepository;

    @Test
    @Sql("dummy-data.sql")
    public void testCorrectFetch() {
        Activity activity = activityRepository.findOne(1);
        Assert.assertTrue("Activity delays is not empty", !activity.getActivityDelays().isEmpty());

        ActivityDelay activityDelay = activity.getActivityDelays().get(0);
        Assert.assertEquals("\"The activity was delayed\" was found", "The activity was delayed", activityDelay.getReason());
    }

    @Test
    @Sql("dummy-data.sql")
    public void testCreateActivity(){
        Activity activity = new Activity();
        activity.setActivityId(2);
        activity.setDescription("Activity Description -- 02");
        activity.setValue("Activity value");

        activityRepository.saveAndFlush(activity);

        Assert.assertEquals("There are two activities in the repository", 2, activityRepository.findAll().size());

        Activity activityFound = activityRepository.findOne(2);

        Assert.assertNotNull("One activity was found", activityFound);
        Assert.assertEquals("\"Activity Description -- 02\" was found", "Activity Description -- 02", activityFound.getDescription());
    }

    @Test
    @Sql("dummy-data.sql")
    public void testFindAll() {
        Assert.assertEquals(1, activityRepository.findAll().size());
    }

    @Test
    @Sql("dummy-data.sql")
    public void testUpdate() {
        Activity activity = activityRepository.findOne(1);
        activity.setDescription("Modified Activity description");

        activityRepository.save(activity);

        Activity activityFound = activityRepository.findOne(1);
        Assert.assertNotNull("One activity was found", activityFound);
        Assert.assertEquals("\"Modified Activity description\" was found", "Modified Activity description", activityFound.getDescription());
    }

    @Test
    @Sql("dummy-data.sql")
    public void testDeleteActivity() {
        activityRepository.delete(1);

        Activity activityFound = activityRepository.findOne(1);

        Assert.assertNull("Activity could not be found", activityFound);
    }
}
