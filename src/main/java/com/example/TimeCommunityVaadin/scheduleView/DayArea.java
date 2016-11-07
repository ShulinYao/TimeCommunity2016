package com.example.TimeCommunityVaadin.scheduleView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.vaadin.annotations.Theme;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Panel;

@Theme("mytheme")
public class DayArea extends TimelineLayout{
	
	//private final AbsoluteLayout absLo;
	
	public DayArea(LocalTime ft, LocalTime exclLt){
		super(ft, exclLt);
	}
	
	/*
	 * Pre-condition: all courseSessions are in the time of day which is displayed.
	 */
	public void addCourseSessions(CourseSession[] courseSessions){
		this.removeAllComponents();
		this.fillWithEmptyPanels();
		ScheduleEventBox seb;
		DayArea da;
		
		int sebBeginningPos;
		int sebHeight;
		for(CourseSession cs : courseSessions){
			da = this;
			sebBeginningPos = getVerticalPositionByTime(cs.getTime().toLocalTime());
			sebHeight = minutesToHeight(cs.getDurationMinutes());
			seb = new ScheduleEventBox(cs.getCourse().getName() + " at " + cs.getLocation(),
					cs);
			seb.setHeight(sebHeight + "px");
			//p("duration is " + cs.getDurationMinutes() + ", height is " + sebHeight + " ");
			seb.setWidth(da.getWidth() + "px");
			da.addComponent(seb, "top: " + sebBeginningPos + " left: 0px; z-index: 10");
			//da.addComponent(seb, "top: 90px; left: 0px; z-index: 10;");
			//p("adding ScheduleEventComponent to top position " + sebBeginningPos + "to da");
		}
	}
	
	private void p(String s){
		System.out.print(s);
	}
	
}
