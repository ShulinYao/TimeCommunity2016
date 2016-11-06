package com.example.TimeCommunityVaadin.scheduleView;

import com.example.TimeCommunityVaadin.TimeCommunityView;
import com.vaadin.annotations.Theme;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
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
	//private Runnable toCourseView;
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
		//this.toCourseView = toCourseView;
	}
	
	private void onCourseSessionButtonClick(Button.ClickEvent e){
		Notification.show("To course view of " + courseSession.getCourse().getName());
		TimeCommunityView tcv = getTCV();
		tcv.toCourseView(courseSession.getCourse());
	}
	
	private TimeCommunityView getTCV(){
		Component c = this;
		while(true){
			c = c.getParent();
			if(c instanceof TimeCommunityView){
				return (TimeCommunityView) c;
			}
		}
	}
	
}
