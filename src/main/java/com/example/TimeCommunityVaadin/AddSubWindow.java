package com.example.TimeCommunityVaadin;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class AddSubWindow extends Window implements Button.ClickListener{
	
	Window subwindow;
	Button closebutton;
	VerticalLayout addcourselayout;
	AddCourseDesign addcourseview;
	
	public AddSubWindow(){
		
		subwindow=new Window("Add a Course");
		subwindow.setWidth("450px");
		subwindow.setHeight("550px");
		//subwindow.setModal(true);
		subwindow.center();
		
		closebutton=new Button("Close");
		closebutton.addClickListener(this);
		
	    addcourseview=new AddCourseDesign();
	    addcourselayout=new VerticalLayout();
	    addcourselayout.setSpacing(true);
	    addcourselayout.setMargin(true);
		addcourselayout.addComponents(addcourseview);
		addcourselayout.addComponent(closebutton);
		addcourselayout.setComponentAlignment(addcourseview,Alignment.TOP_CENTER);
		addcourselayout.setComponentAlignment(closebutton,Alignment.BOTTOM_CENTER);
		subwindow.setContent(addcourselayout);
		UI.getCurrent().addWindow(subwindow);
		
		
		
	}

	@Override
	public void buttonClick(ClickEvent event) {
		// TODO Auto-generated method stub
		subwindow.close();		
		//new CommunityViewDesign();

	}

	

}
