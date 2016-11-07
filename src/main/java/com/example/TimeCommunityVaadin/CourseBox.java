package com.example.TimeCommunityVaadin;

import java.util.function.Consumer;

import com.example.TimeCommunityVaadin.scheduleView.Course;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class CourseBox extends CustomComponent{

	private final Panel p;
	private final Panel icvPanel;
	private final VerticalLayout outermostLo = new VerticalLayout();
	
	public CourseBox(Course course, Consumer<Course> toCourseView){
		this.p = new Panel();
		outermostLo.addComponent(p);
		outermostLo.setMargin(true);
		this.icvPanel = new Panel();
		//setCompositionRoot(p);
		setCompositionRoot(outermostLo);
		VerticalLayout mainLayout = new VerticalLayout();
		p.setContent(mainLayout);
		InspectCourseView icv = new InspectCourseView(course, toCourseView);
		icvPanel.setContent(icv);
		mainLayout.addComponent(icvPanel);
		icv.setWidth("700px");
		mainLayout.addComponent(new Button("Comment", this::onCommentButton));
	}
	
	public void onCommentButton(ClickEvent e){
		Notification.show("Comment feature is not implemented");
	}
}
