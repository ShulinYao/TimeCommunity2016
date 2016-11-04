package com.example.TimeCommunityVaadin;

import com.example.TimeCommunityVaadin.scheduleView.ScheduleComponent;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.Notification;

public class TimeCommunityView extends TimeCommunityDesign implements
		Property.ValueChangeListener{

	public TimeCommunityView(){
		super();
		System.out.println("TimeCommunityView has been created");
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
			             CommunityViewDesign communityview=new CommunityViewView();
			             communitylayout.removeAllComponents();
		                 communitylayout.addComponent(communityview);
		                 hsplit.setSecondComponent(communitylayout);
			break;
		case"My Schedule":
						System.out.println("My schedule in switch");
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
	
	private ScheduleComponent initializeScheduleComponent(){
		//Courses have to be retrieved from a database class, which is connected to database
		//Course[] courses = new DatabaseProxy().getCourses();
		//ScheduleComponent sc = new ScheduleComponent(courses);
		return new ScheduleComponent();
	}
}
