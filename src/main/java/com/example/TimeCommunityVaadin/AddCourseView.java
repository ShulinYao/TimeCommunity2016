package com.example.TimeCommunityVaadin;

import com.example.TimeCommunityVaadin.scheduleView.Course;
import com.example.TimeCommunityVaadin.scheduleView.DatabaseProxy;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification;

public class AddCourseView extends AddCourseDesign{

	public AddCourseView(){
		super();
		completebutton.addClickListener(this::onCompleteButtonClick);
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
		Course c = new Course(name);
		DatabaseProxy dbp = DatabaseProxy.getDatabaseProxy();
		//dbp.addNewCourse(c);
		//...
	}
	
}
