package com.example.TimeCommunityVaadin;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;

//This class is named according to a naming convention.
public class CommunityViewView extends CommunityViewDesign implements Button.ClickListener{

	public CommunityViewView(){
		super();
		addbutton.addClickListener(this);
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
