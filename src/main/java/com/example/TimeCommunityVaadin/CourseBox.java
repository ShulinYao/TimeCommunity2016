package com.example.TimeCommunityVaadin;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Consumer;

import com.example.TimeCommunityVaadin.scheduleView.Course;
import com.example.TimeCommunityVaadin.scheduleView.DatabaseProxy;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class CourseBox extends CustomComponent{

	private final Panel p;
	private final Panel icvPanel;
	private final Panel commentSectionPanel;
	private final VerticalLayout commentSection;
	private final VerticalLayout outermostLo = new VerticalLayout();
	private TextField commentInput;
	private Course course;
	
	public CourseBox(Course course, Consumer<Course> toCourseView){
		this.course = course;
		this.p = new Panel();
		outermostLo.addComponent(p);
		outermostLo.setMargin(true);
		this.icvPanel = new Panel();
		this.commentSectionPanel = new Panel();
		this.commentSection = new VerticalLayout();
		commentSectionPanel.setContent(commentSection);
		//setCompositionRoot(p);
		setCompositionRoot(outermostLo);
		VerticalLayout mainLayout = new VerticalLayout();
		p.setContent(mainLayout);
		InspectCourseView icv = new InspectCourseView(course, toCourseView);
		icvPanel.setContent(icv);
		mainLayout.addComponent(icvPanel);
		mainLayout.addComponent(new Label("Comments on this course"));
		mainLayout.addComponent(commentSection);
		icv.setWidth("700px");
		
		addComments();
		commentInput = new TextField();
		commentInput.setWidth("500px");
		commentInput.setInputPrompt("Write you comment here");
		mainLayout.addComponent(commentInput);
		mainLayout.addComponent(new Button("Comment", this::onCommentButton));
	}
	
	public void onCommentButton(ClickEvent e){
		//Notification.show("Comment feature is not implemented");
		if(commentInput.getValue() == "") return;
		Comment newComment = new Comment(commentInput.getValue(), LocalDateTime.now());
		this.course.addComment(newComment);
		DatabaseProxy.getDatabaseProxy().saveCurrentCourses();
		Notification.show("Refresh the page to see the comment you added");
		System.out.println("Comment added");
	}
	
	private void addComments(){
		SingleCommentBox scb;
		if(course.getComments() == null){
			Notification.show("Error");
			return;
		}
		List<Comment> comments = course.getComments();
		if(comments.size() == 0){
			this.commentSection.addComponent(new Label("(No comments"));
			return;
		}
		for(Comment c : comments){
			scb = new SingleCommentBox(c);
			this.commentSection.addComponent(scb);
		}
	}
}
