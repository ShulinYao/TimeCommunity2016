package com.example.TimeCommunityVaadin.scheduleView;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//This class is only for testing and can be replaced by a class which has access to the database.
//It is assumed that only this program edits the DataFile.xml.
public class DatabaseProxy {
	
	private static final DatabaseProxy databaseProxy = new DatabaseProxy();
	
	private Course[] courses;
	private final File file;
	
	public static DatabaseProxy getDatabaseProxy(){
		return databaseProxy;
	}
	
	private DatabaseProxy(){
		file = new File();
		this.courses = retrieveCourses();
		//courses = createCourses();
		//createCourseSessions();
	}
	
	public Course[] getCourses(){
		//Course[] courses = file.retrieveCourses();
		//this.courses = courses;
		return this.courses;
	}
	
	public void addCourse(Course newCourse){
		Course[] currentCourses = getCourses();
		ArrayList<Course> ccal = new ArrayList<Course>(Arrays.asList(currentCourses));
		ccal.add(newCourse);
		Course[] allCourses = ccal.toArray(new Course[0]);
		this.courses = allCourses;
		file.saveData(this);
	}
	
	public void saveCurrentCourses(){
		file.saveData(this);
	}
	
	private Course[] retrieveCourses(){
		Course[] courses = file.retrieveCourses();
		return courses;
	}
	
	/////////////////////////////////////
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
