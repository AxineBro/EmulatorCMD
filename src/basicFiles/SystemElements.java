package basicFiles;

import java.util.ArrayList;
import java.util.List;

import utils.TimeUtils;

public class SystemElements {
	private String systemElementsName;
	private String fullSystemElementsName;
	private String systemElementsDate;
	private String systemElementsTime;
	{
		setSystemElementsDate(TimeUtils.getNowDate());
		setSystemElementsTime(TimeUtils.getNowTime());
	}
	public SystemElements(String systemElementsName, String fullParentSystemElementsName) {
		fullSystemElementsName = fullParentSystemElementsName + systemElementsName + "\\";
		this.setSystemElementsName(systemElementsName);
	}

	public SystemElements(String fileName) {
		fullSystemElementsName = fileName+ "\\";
		this.setSystemElementsName(fileName);
	}

	public String getSystemElementsName() {
		return systemElementsName;
	}

	public void setSystemElementsName(String systemElementsName) {
		this.systemElementsName = systemElementsName;
	}

	public String getSystemElementsDate() {
		return systemElementsDate;
	}

	public void setSystemElementsDate(String systemElementsDate) {
		this.systemElementsDate = systemElementsDate;
	}

	public String getSystemElementsTime() {
		return systemElementsTime;
	}

	public void setSystemElementsTime(String systemElementsTime) {
		this.systemElementsTime = systemElementsTime;
	}

	public String getFullSystemElementsName() {
		return fullSystemElementsName;
	}
}
