package com.example.TimeCommunityVaadin.scheduleView;

import java.time.LocalDateTime;

import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;

public class LocalDateTimeConverter extends AbstractSingleValueConverter { 

	public boolean canConvert(Class type) { 
		return (type!=null) && LocalDateTime.class.getPackage().equals(type.getPackage()); 
	} 
	
	public String toString (Object source) { 
		return source.toString(); 
	} 
	
	public Object fromString(String str) { 
		try { 
			return LocalDateTime.parse(str); 
		} catch (Exception e) { 
			// deal with it 
			e.printStackTrace();
		}
		return null;
	} 

} 
