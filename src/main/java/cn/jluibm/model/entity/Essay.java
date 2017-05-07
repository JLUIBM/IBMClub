package cn.jluibm.model.entity;

import java.sql.Timestamp;

public class Essay
{
	private int essayId = -1;
	private String title;
	private String author;
	private Timestamp time;
	private int type;
	private String topic;
	private String content;
	private boolean state = true;
	
	public Essay(String title, String author, Timestamp time, int type, String topic, String content,
			boolean state)
	{
		super();
		this.title = title;
		this.author = author;
		this.time = time;
		this.type = type;
		this.topic = topic;
		this.content = content;
		this.state = state;
	}
	public Essay(String title, String author, Timestamp time, int type, String topic, String content)
	{
		super();
		this.title = title;
		this.author = author;
		this.time = time;
		this.type = type;
		this.topic = topic;
		this.content = content;
	}
	public Essay()
	{
		super();
	}
	
	public int getEssayId()
	{
		return essayId;
	}
	public void setEssayId(Integer essayId)
	{
		this.essayId = essayId;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getAuthor()
	{
		return author;
	}
	public void setAuthor(String author)
	{
		this.author = author;
	}
	public Timestamp getTime()
	{
		return time;
	}
	public void setTime(Timestamp time)
	{
		this.time = time;
	}
	public int getType()
	{
		return type;
	}
	public void setType(Integer type)
	{
		this.type = type;
	}
	public String getTopic()
	{
		return topic;
	}
	public void setTopic(String topic)
	{
		this.topic = topic;
	}
	public String getContent()
	{
		return content;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
	public boolean getState()
	{
		return state;
	}
	public void setState(Boolean state)
	{
		this.state = state;
	}

}
