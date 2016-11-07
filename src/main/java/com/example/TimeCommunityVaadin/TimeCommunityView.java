package com.example.TimeCommunityVaadin;

import java.util.EventObject;

import com.example.TimeCommunityVaadin.scheduleView.Course;
import com.example.TimeCommunityVaadin.scheduleView.ScheduleComponent;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;

public class TimeCommunityView extends TimeCommunityDesign implements
		Property.ValueChangeListener, View{
	
	public static final String NAME = "";

	public TimeCommunityView(){
		super();
		//System.out.println("TimeCommunityView has been created");
		listview.addValueChangeListener(this);
		listview.select("Community");
		
	}
	
	@Override
	public void valueChange(ValueChangeEvent event) {
		// TODO Auto-generated method stub
		String listviewstr=event.getProperty().getValue().toString();
		System.out.println("TimeCommunityView list view: value has been changed");
		
		switch(listviewstr){
		
		case"Community": 
			             CommunityViewDesign communityview=new CommunityViewView(this);
			             communitylayout.removeAllComponents();
		                 communitylayout.addComponent(communityview);
		                 hsplit.setSecondComponent(communitylayout);
			break;
		case"My Schedule":
			             //AddCourseDesign addview=new AddCourseDesign();
			             communitylayout.removeAllComponents();
			             //communitylayout.addComponent(addview);
			             //hsplit.setSecondComponent(communitylayout);
			             hsplit.setSecondComponent(initializeScheduleComponent());
			
			             
			             //Notification.show(listviewstr+"Hello !!!!");
			break;
		case"My Event":
			             communitylayout.removeAllComponents();
			             Notification.show(listviewstr + " is not implemented.");
			break;
		default:
			break;
		}
	}
	
	@Override
    public void enter(ViewChangeEvent event) {
        // Get the user name from the session
        String username = String.valueOf(getSession().getAttribute("user"));
        //Notification.show("Entered to MainView");

        // And show the username
        //text.setValue("Hello " + username);
    }
	
	public void toCourseView(Course course){
		communitylayout.removeAllComponents();//?
		hsplit.setSecondComponent(new InspectCourseView(course));
		listview.select(null);
	}
	
	private ScheduleComponent initializeScheduleComponent(){
		//Courses have to be retrieved from a database class, which is connected to database
		//Course[] courses = new DatabaseProxy().getCourses();
		//ScheduleComponent sc = new ScheduleComponent(courses);
		return new ScheduleComponent();
	}
	
//	public class ToCourseView extends EventObject{
//		public Course course;
//		public ToCourseView(Object source, Course course){
//			super(source);
//			this.course = course;
//		}
//		
//	}
}
