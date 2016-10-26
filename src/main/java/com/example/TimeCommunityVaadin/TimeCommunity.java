package com.example.TimeCommunityVaadin;

import com.example.TimeCommunityVaadin.scheduleView.*;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

public class TimeCommunity extends CustomComponent implements Property.ValueChangeListener{

	 VerticalLayout vlayout=new VerticalLayout();
	 HorizontalSplitPanel hsplit = new HorizontalSplitPanel();
     ListSelect itemSelect = new ListSelect();
     Label title=new Label();
     
     public TimeCommunity(){
    	 
    	 title.setCaption("Time Community");
		itemSelect.addItem("Community");
		itemSelect.addItem("My Schedule");
		itemSelect.addItem("My Events");

	    itemSelect.setRows(3); // perfect length in out case
	    itemSelect.setNullSelectionAllowed(false); // user can not 'unselect'
	    itemSelect.select("Community"); // select this by default
	    itemSelect.setImmediate(true); // send the change to the server at once
	    itemSelect.addValueChangeListener(this); // react when the user selects something
		
		hsplit.setFirstComponent(itemSelect);
		
		vlayout.addComponents(title,hsplit);
		vlayout.addComponent(new ScheduleEventBox("Test Box"));
		setCompositionRoot(vlayout);
		
		
     }

	@Override
	public void valueChange(ValueChangeEvent event) {
		// TODO Auto-generated method stub'
		Notification.show(event.getProperty().getValue().toString());
		if(event.getProperty().getValue().toString() == "My Schedule"){
			hsplit.setSecondComponent(initializeScheduleComponent());
		}
	}
	
	private ScheduleComponent initializeScheduleComponent(){
		//Courses have to be retrieved from a database class, which is connected to database
		Course[] courses = new DatabaseProxy().getCourses();
		ScheduleComponent sc = new ScheduleComponent(courses);
		return sc;
	}
}
