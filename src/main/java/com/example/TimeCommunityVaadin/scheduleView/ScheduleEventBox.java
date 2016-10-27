package com.example.TimeCommunityVaadin.scheduleView;

import com.vaadin.annotations.Theme;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;

@Theme("mytheme")
public class ScheduleEventBox extends CustomComponent{
	public static final String CLASSNAME = "schedule-event-box-panel";
	private static final String panelClassname = "schedule-event-box-panel";
	private static final String labelClassname = "schedule-event-box-label";
	private final Panel outermost;
	private final Button label;//Label label;
	private final CourseSession courseSession;
	//private int layoutHeight;
	
	public ScheduleEventBox(String text, CourseSession courseSession){
		setPrimaryStyleName(CLASSNAME);
		outermost = new Panel();
		//outermost.setPrimaryStyleName(panelClassname);
		outermost.addStyleName(panelClassname);
		label = new Button(text, this::onCourseSessionButtonClick);//new Label(text);
		label.setPrimaryStyleName(labelClassname);
		outermost.setContent(label);
		outermost.setSizeFull();
		label.setSizeFull();
		setCompositionRoot(outermost);
		this.courseSession = courseSession;
	}
	
	private void onCourseSessionButtonClick(Button.ClickEvent e){
		Notification.show("To course view of " + courseSession.getCourse().getName());
	}
	
}
