package ActivityTests;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;

import models.Activity;
import models.ActivityDao;
import models.ProjectDao;

public class TestDeleteActivity {
	
	private ActivityDao activityDao = new ActivityDao();

	@Test
	//testing deletion of an Activity by using "activity id"
	public void deleteActivity() {

		System.out.println("Testing Deletion of an Activty");
		Activity temp = null;

		try {
			temp = new Activity(20, "testDeleteActivity", "2016-05-29", "2016-05-31", 1);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Failed to create activity");
		}
		
		assertTrue(activityDao.InsertActivity(temp));
		activityDao.DeleteActivity(20);
		
		//TODO actually check if it's deleted in the database
	}	
}
