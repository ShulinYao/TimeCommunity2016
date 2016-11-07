package com.example.TimeCommunityVaadin;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class SingleCommentBox extends CustomComponent{

	private Comment comment;
	
	public SingleCommentBox(Comment comment){
		this.comment = comment;
		Panel p = new Panel();
		setCompositionRoot(p);
		VerticalLayout vl = new VerticalLayout();
		p.setContent(vl);
		Label commentInfo = new Label("Written by " + comment.getWriter() + " at " +
				comment.getTime().toString());
		Label commentText = new Label(comment.getText());
		vl.addComponent(commentInfo);
		vl.addComponent(commentText);
	}
	
}
