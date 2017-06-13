package com.advantum.activity.controller.rest;

import com.advantum.App;
import com.advantum.activity.model.Activity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

/**
 * @author Denis Bell
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
@ActiveProfiles("integration")
@WebIntegrationTest
//@Transactional
//@Sql("../../repository/dummy-data.sql")
public class ActivityRestControllerWebIntegrationTest {

    @Test
    public void testFindOneActivity() {
        Activity foundActivity = getActivityRest(1);
        Assert.assertNotNull("An Activity was found", foundActivity);
        Assert.assertEquals("The \"Activity description 01\" should be found", "Activity description 01", foundActivity.getDescription());
    }

    private Activity getActivityRest(Integer activityId) {
        RestTemplate restTemplate = new TestRestTemplate();
        ResponseEntity<Activity> response = restTemplate.getForEntity("http://localhost:8282/api/activities/" + activityId, Activity.class);
        return response.getBody();
    }

    @Test
    public void testExistentActivityDelaysInFoundActivity() {
        Activity foundActivity = getActivityRest(1);
        Assert.assertNotNull("An Activity was found", foundActivity);
        Assert.assertEquals("The \"The activity was delayed\" ActivityDelay should be found", "The activity was delayed", foundActivity.getActivityDelays().get(0).getReason());
    }

    @Test
    public void testUpdateActivity() {
        Activity activity = getActivityRest(1);
        activity.setDescription("Modified activity");

        updateActivityRest(activity);

        activity = getActivityRest(1);

        Assert.assertNotNull(activity);
        Assert.assertEquals("The activity was modified", "Modified activity", activity.getDescription());

        activity.setDescription("Activity description 01");

        activity = updateActivityRest(activity);
        Assert.assertEquals("The activity was modified back", "Activity description 01", activity.getDescription());
    }

    private Activity updateActivityRest(Activity activity) {
        HttpEntity<Activity> updateRequestEntity = new HttpEntity<Activity>(activity);
        RestTemplate restTemplate = new TestRestTemplate();
        ResponseEntity<Activity> responseEntity = restTemplate.exchange("http://localhost:8282/api/activities/1", HttpMethod.PUT, updateRequestEntity, Activity.class);
        return responseEntity.getBody();
    }

    @Test
    public void testDeleteActivity() {
        RestTemplate restTemplate = new TestRestTemplate();
        restTemplate.delete("http://localhost:8282/api/activities/1");

        ResponseEntity<Activity> response = restTemplate.getForEntity("http://localhost:8282/api/activities/1", Activity.class);

        Assert.assertEquals("The deleted activity was not found", HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
