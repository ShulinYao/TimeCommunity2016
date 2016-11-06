package com.example.TimeCommunityVaadin;

import com.example.TimeCommunityVaadin.scheduleView.Course;
import com.vaadin.ui.Label;

public class InspectCourseView extends InspectCourseDesign{

	public InspectCourseView(Course course){
		super();
		Label name = new Label(course.getName());
		name.setCaption("Course name");
		//Course id not implemented
		//Label courseId = new Label(course.getCourseId());
		//courseId.setCaption("Course id");
		Label timeAndPlace = new Label(course.getCourseTimePlaceText());
		timeAndPlace.setCaption("Time and place");
		Label introduction = new Label(course.getShortDescription());
		introduction.setCaption("Description");
		formLayout.addComponent(name);
		formLayout.addComponent(timeAndPlace);
		formLayout.addComponent(introduction);
		//System.out.println("InspectCourseView has been crated");
	}
	
}
