package cn.jluibm.model.entity;

import java.sql.Timestamp;

public class Activity
{
	private int activityId = -1;
	private String title;
	private Timestamp activityTime;
	private Timestamp publishTime;
	private String manager;
	private String location;
	private String content;
	
	public Activity(String title, Timestamp activityTime, Timestamp publishTime, String manager, String location,
			String content)
	{
		super();
		this.title = title;
		this.activityTime = activityTime;
		this.publishTime = publishTime;
		this.manager = manager;
		this.location = location;
		this.content = content;
	}
	public Activity()
	{
		super();
	}
	
	public int getActivityId()
	{
		return activityId;
	}
	public void setActivityId(Integer activityId)
	{
		this.activityId = activityId;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public Timestamp getActivityTime()
	{
		return activityTime;
	}
	public void setActivityTime(Timestamp activityTime)
	{
		this.activityTime = activityTime;
	}
	public Timestamp getPublishTime()
	{
		return publishTime;
	}
	public void setPublishTime(Timestamp publishTime)
	{
		this.publishTime = publishTime;
	}
	public String getManager()
	{
		return manager;
	}
	public void setManager(String manager)
	{
		this.manager = manager;
	}
	public String getLocation()
	{
		return location;
	}
	public void setLocation(String location)
	{
		this.location = location;
	}
	public String getContent()
	{
		return content;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
	

}
