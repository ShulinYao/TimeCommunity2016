package com.example.TimeCommunityVaadin;

import java.util.function.Consumer;

import com.example.TimeCommunityVaadin.scheduleView.Course;
import com.vaadin.event.LayoutEvents;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.event.MouseEvents;
import com.vaadin.ui.Label;

public class InspectCourseView extends InspectCourseDesign implements
		LayoutClickListener{

	private Consumer<Course> toCourseView;
	private Course course;
	
	public InspectCourseView(Course course){
		super();
		initialize(course);
	}
	
	public InspectCourseView(Course course, Consumer<Course> toCourseView){
		super();
		initialize(course);
		this.toCourseView = toCourseView;
	}
	
	private void initialize(Course course){
		this.course = course;
		Label name = new Label(course.getName());
		name.setCaption("Course name");
		//Course id not implemented
		//Label courseId = new Label(course.getCourseId());
		//courseId.setCaption("Course id");
		Label timeAndPlace = new Label(course.getCourseTimePlaceText() + " (May be false "
				+ "information. We didn't have enough time to fix this bug)");
		timeAndPlace.setCaption("Time and place");
		Label startDate = new Label(course.getStartDate().toString());
		startDate.setCaption("Start date");
		Label introduction = new Label(course.getShortDescription());
		introduction.setCaption("Description");
		name.setWidth("500px");
		timeAndPlace.setWidth("500px");
		introduction.setWidth("500px");
		formLayout.addComponent(name);
		formLayout.addComponent(timeAndPlace);
		formLayout.addComponent(startDate);
		formLayout.addComponent(introduction);
		addLayoutClickListener((LayoutClickListener) this);
	}
	
//	public void click(MouseEvents.ClickEvent e){
//		System.out.println("Clicked in InspectCourseView");
//		if(toCourseView != null){
//			this.toCourseView.accept(this.course);
//		}
//	}
	
	public void layoutClick(LayoutEvents.LayoutClickEvent e){
		System.out.println("Clicked in InspectCourseView");
		if(toCourseView != null){
			this.toCourseView.accept(this.course);
		}
	}
	
}
