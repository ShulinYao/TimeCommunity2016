package com.example.TimeCommunityVaadin;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.example.TimeCommunityVaadin.TimeCommunityDesign;
public class MainView extends TimeCommunityDesign implements View {

    public static final String NAME = "";

   // Label text = new Label();

  

    public MainView() {
        
    	//main view of time community     
    	     	     
    	     final AbsoluteLayout layout = new AbsoluteLayout();
    	     TimeCommunityDesign community=new TimeCommunityDesign();
    	    
    	     
    	     layout.addComponent(community);
    	     layout.setSizeFull();
    	     
             setParent(layout);
        
    }

    @Override
    public void enter(ViewChangeEvent event) {
        // Get the user name from the session
        String username = String.valueOf(getSession().getAttribute("user"));

        // And show the username
       // text.setValue("Hello " + username);
    }
}
