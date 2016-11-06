package com.example.TimeCommunityVaadin.scheduleView;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Course {

	private String name;
	private String shortDescription = "";
	private String moreInformation = ""; // Not in use
	private String time = "";
	private String location = ""; // Not in use
	private ArrayList<CourseSession> courseSessions;
	//private Comment[] comments;
	
	public Course(String name){
		this.name = name;
		courseSessions = new ArrayList<CourseSession>();
	}
	
	/*
	 * start parameter is inclusive. end parameter is exclusive.
	 */
	public ArrayList<CourseSession> getCourseSessionsInInterval(LocalDateTime start, LocalDateTime end){
		ArrayList<CourseSession> inInterval = new ArrayList<CourseSession>();
		CourseSession courseSession;
		for(int i = 0; i < courseSessions.size(); i++){
			courseSession = courseSessions.get(i);
			if(courseSession.getTime().compareTo(start) >= 0 &&
					courseSession.getTime().compareTo(end) < 0){
				inInterval.add(courseSessions.get(i));
			}
		}
		return inInterval;
	}
	
	public void addSession(CourseSession cs){
		if(!courseSessions.contains(cs)){
			courseSessions.add(cs);
		}
	}
	
	/*
	 * Creates and adds CourseSessions in proper date times between startDate and endDate.
	 * Both dates are inclusive.
	 */
	public void addSessions(LocalDate startDate, LocalDate endDate, LocalTime startTime,
			int durationHours, String location, DayOfWeek dow){
		CourseSession cs;
		LocalDateTime ldt;
		//int durationMinutes = durationHours * 60;
		for(LocalDate d = startDate; d.isBefore(endDate.plusDays(1)); d = d.plusDays(1)){
			if(d.getDayOfWeek() == dow){
				ldt = LocalDateTime.of(d, startTime);
				cs = new CourseSession(this, ldt, durationHours, location);
				addSession(cs);
			}
		}
	}
	
	/*
	 * Pre-condition: CourseSessions in courseSessions list are ordered chronologically.
	 * DOESN'T WORK PROPERLY
	 */
	public String getCourseTimePlaceText(){
		CourseSession cs1 = courseSessions.get(0);
		CourseSession cs2 = courseSessions.get(1);
		LocalDateTime ldt1 = cs1.getTime();
		LocalDateTime ldt2 = cs2.getTime();
		boolean isOncePerWeek;
		isOncePerWeek = ldt1.equals(ldt2);
		String firstCsString = csTimeToString(ldt1, cs1.getDurationHours()) + 
				" at " + cs1.getLocation();
		if(isOncePerWeek){
			return firstCsString;
		}
		String secondCsString = csTimeToString(ldt2, cs2.getDurationHours()) +
				" at " + cs2.getLocation();
		return firstCsString + ", " + secondCsString;
//		isOncePerWeek = ldt1.equals(ldt2);
//		String firstCsString = timeToString(ldt1) + " at " + courseSessions.get(0).getLocation();
//		if(isOncePerWeek){
//			return firstCsString;
//		}
//		for(int i = 0; i < 7; i++){
//			
//			ld = ld.plusDays(1);
//		}
	}
	
	private String csTimeToString(LocalDateTime ldt, int dur){
		return ldt.getDayOfWeek().toString() + " " + ldt.getHour() + "-" +
				ldt.getHour() + dur;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getMoreInformation() {
		return moreInformation;
	}

	public void setMoreInformation(String moreInformation) {
		this.moreInformation = moreInformation;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public ArrayList<CourseSession> getCourseSessions() {
		return courseSessions;
	}

	public void setCourseSessions(ArrayList<CourseSession> courseSessions) {
		this.courseSessions = courseSessions;
	}
	
}
