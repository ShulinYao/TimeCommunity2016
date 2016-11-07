package com.example.TimeCommunityVaadin;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import com.example.TimeCommunityVaadin.scheduleView.Course;
import com.example.TimeCommunityVaadin.scheduleView.DatabaseProxy;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification;

public class AddCourseView extends AddCourseDesign{

	private Runnable closeWindow;
	
	public AddCourseView(Runnable closeWindow){
		super();
		completebutton.addClickListener(this::onCompleteButtonClick);
		cancelbutton.addClickListener(this::onCancelButtonClick);
		this.closeWindow = closeWindow;
	}
	
	public void onCompleteButtonClick(Button.ClickEvent e){
		System.out.println("It has been clicked");
		String name = course.getValue();
		if(name == ""){
			Notification.show("Enter course name");
			return;
		}
		String courseCodeString = courseCode.getValue(); //Ignored
		String description = introduction.getValue();
		
		Date startDateInput = time.getValue();
		LocalDate startDate =
				startDateInput.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		Date endDateInput = endTime.getValue();
		LocalDate endDate =
				endDateInput.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		LocalTime lectureStartTime1 = hourToLocalTime(
				Integer.parseInt((String)startTimeOfDay.getValue()));
		int duration1 = Integer.parseInt((String)durationHours.getValue());
		String weekDay1Val = (String)weekDay.getValue();
		DayOfWeek weekDay1 = inputStringToDow(weekDay1Val);
		String location1Val = (String)location.getValue();
		
		Course c1 = new Course(name);
		c1.addSessions(startDate, endDate, lectureStartTime1, duration1, location1Val, weekDay1);
		DatabaseProxy dbp = DatabaseProxy.getDatabaseProxy();
		dbp.addCourse(c1);
		
		if(startTimeOfDay2.getValue() != null && durationHours2 != null && weekDay2.getValue() !=
				null && location2.getValue() != null){
			LocalTime lectureStartTime2 = hourToLocalTime(
					Integer.parseInt((String)startTimeOfDay2.getValue()));
			int duration2 = Integer.parseInt((String)durationHours2.getValue());
			String weekDay2Val = (String)weekDay2.getValue();
			DayOfWeek weekDay2 = inputStringToDow(weekDay2Val);
			String location2Val = (String)location2.getValue();
			Course c2 = new Course(name);
			c2.addSessions(startDate, endDate, lectureStartTime2, duration2, location2Val,
					weekDay2);
			dbp.addCourse(c2);
		}
		Notification.show("Course " + name +  " created");
		this.closeWindow.run();
		//...
		//dbp.addNewCourse(c);
		//...
	}
	
	public void onCancelButtonClick(Button.ClickEvent e){
		this.closeWindow.run();
	}
	
	private LocalTime hourToLocalTime(int h){
		return LocalTime.of(h, 0);
	}
	
	private DayOfWeek inputStringToDow(String s){
		String[] dowStrings = new String[]{"(zero index)", "Mon", "Tue", "Wed", "Thu", "Fri"};
		int stringsIndex = Arrays.asList(dowStrings).indexOf(s);
		if(stringsIndex == -1){
			try {
				throw new Exception("Incorrect argument");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return DayOfWeek.of(stringsIndex);
	}
	
}
