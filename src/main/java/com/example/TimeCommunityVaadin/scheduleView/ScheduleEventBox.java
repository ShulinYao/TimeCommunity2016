package com.example.TimeCommunityVaadin.scheduleView;

import com.vaadin.annotations.Theme;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;

@Theme("mytheme")
public class ScheduleEventBox extends CustomComponent{
	public static final String CLASSNAME = "schedule-event-box-panel";
	private static final String panelClassname = "schedule-event-box-panel";
	private static final String labelClassname = "schedule-event-box-label";
	private final Panel outermost;
	private final Label label;
	//private final CourseSession courseSession;
	//private int layoutHeight;
	
	public ScheduleEventBox(String text){
		setPrimaryStyleName(CLASSNAME);
		outermost = new Panel();
		outermost.setPrimaryStyleName(panelClassname);
		label = new Label(text);
		label.setPrimaryStyleName(labelClassname);
		outermost.setContent(label);
		//outermost.setSizeFull();
		//label.setSizeFull();
		setCompositionRoot(outermost);
		//this.courseSession = courseSession;
	}
	
//	private int determineHeight(){
//		return 0;
//	}
//	
//	private int determineVerticalPosition(){
//		return 0;
//	}
}
