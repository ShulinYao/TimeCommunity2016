package com.example.TimeCommunityVaadin.scheduleView;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

//This class is only for testing and can be replaced by a class which has access to the database.
public class DatabaseProxy {
	
	private static final DatabaseProxy databaseProxy = new DatabaseProxy();
	
	private Course[] courses; //EI KÄYTÖSSÄ
	private final File file;
	
	public static DatabaseProxy getDatabaseProxy(){
		return databaseProxy;
	}
	
	private DatabaseProxy(){
		file = new File();
		//courses = createCourses();
		//createCourseSessions();
	}
	
	public Course[] getCourses(){
		Course[] courses = file.retrieveCourses();
		return courses;
	}
	
	//HYÖDYTTÖMIÄ
	private Course[] createCourses(){
		Course c1 = new Course("Test Course");
		Course c2 = new Course("Golf Course");
		return new Course[]{c1, c2};
	}

	private void createCourseSessions(){
		LocalDateTime[] dts = {
				LocalDateTime.of(2016, Month.OCTOBER, 25, 14, 0),
				LocalDateTime.of(2016, Month.OCTOBER, 25, 14, 30),
				LocalDateTime.of(2016, Month.OCTOBER, 26, 14, 0),
				LocalDateTime.of(2016, Month.OCTOBER, 27, 14, 0)
		};
		CourseSession[] css = {
				new CourseSession(courses[0], dts[0], 2, "Agora 110C"),
				new CourseSession(courses[1], dts[1], 2, "Agora 110B"),
				new CourseSession(courses[0], dts[2], 2, "Agora 110C"),
				new CourseSession(courses[1], dts[3], 6, "TuKKK Ls1")
		};
	}
}
