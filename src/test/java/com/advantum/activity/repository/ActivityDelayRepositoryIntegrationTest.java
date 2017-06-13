package com.advantum.activity.repository;

import com.advantum.App;
import com.advantum.activity.model.ActivityDelay;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author Denis Bell
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional()
@SpringApplicationConfiguration(App.class)
public class ActivityDelayRepositoryIntegrationTest {

    @Autowired
    private ActivityDelayRepository activityDelayRepository;

    @Test
    public void testCreateActivityDelay() {
        ActivityDelay activityDelay = createActivityDelay();
        activityDelayRepository.saveAndFlush(activityDelay);
        activityDelayRepository.flush();

        Assert.assertNotNull("Created object found", activityDelayRepository.findOne(1));
    }

    private ActivityDelay createActivityDelay() {
        ActivityDelay activityDelay = new ActivityDelay();
        activityDelay.setActivityDelayId(1);
        activityDelay.setReason("Delayed activity");
        activityDelay.setStartDateTime(new Date());
        activityDelay.setEndDateTime(new Date());
        return activityDelay;
    }

    @Test
    @Sql("dummy-data.sql")
    public void testFetchAll() {
        List<ActivityDelay> all = activityDelayRepository.findAll();
        Assert.assertTrue("List is not empty", !all.isEmpty());
    }
}
