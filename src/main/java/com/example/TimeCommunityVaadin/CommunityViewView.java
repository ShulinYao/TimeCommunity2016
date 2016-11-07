package com.example.TimeCommunityVaadin;

import com.example.TimeCommunityVaadin.scheduleView.Course;
import com.example.TimeCommunityVaadin.scheduleView.DatabaseProxy;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

//This class is named according to a naming convention.
public class CommunityViewView extends CommunityViewDesign implements Button.ClickListener{

	VerticalLayout courseBoxesLayout;
	Panel courseBoxesPanel;
	TimeCommunityView tcv;
	
	public CommunityViewView(TimeCommunityView tcv){
		super();
		this.tcv = tcv;
		addbutton.addClickListener(this);
		courseBoxesLayout =  new VerticalLayout();
		courseBoxesPanel = new Panel();
		courseBoxesPanel.setContent(courseBoxesLayout);
		DatabaseProxy dbp = DatabaseProxy.getDatabaseProxy();
		Course[] courses = dbp.getCourses();
		for(int i = 0; i < courses.length; i++){
			CourseBox cb = new CourseBox(courses[i], tcv::toCourseView);
			courseBoxesLayout.addComponent(cb);
		}
		addComponent(courseBoxesPanel);
		courseBoxesPanel.setHeight("480px");
		//courseBoxesPanel.setWidth("700px");
	}
	
	public void buttonClick(Button.ClickEvent event) {
		// TODO Auto-generated method stub
		//Notification.show("This is Test");
		Window subwindow =new Window("Add a Course");
		subwindow.setWidth("400px");
		subwindow.setHeight("450px");
		
		subwindow.setModal(true);
		subwindow.center();
		/*VerticalLayout layout = (VerticalLayout) subwindow.getContent();
        layout.setMargin(true);
        layout.setSpacing(true);
        // make it fill the whole window
        layout.setSizeFull();*/
		//UI.addWindow(subwindow);
		//AddCourseDesign addcourseview=new AddCourseDesign();
		AddCourseView addcourseview = new AddCourseView(
				() -> UI.getCurrent().removeWindow(subwindow));
		subwindow.setContent(addcourseview);
		UI.getCurrent().addWindow(subwindow);
	
		
	}
}
