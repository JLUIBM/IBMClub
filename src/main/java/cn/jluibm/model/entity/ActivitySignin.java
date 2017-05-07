package cn.jluibm.model.entity;

import java.sql.Timestamp;

public class ActivitySignin
{
	private int userId;
	private int activityId;
	private Timestamp signinTime;
	
	public ActivitySignin(int userId, int activityId, Timestamp signinTime)
	{
		super();
		this.userId = userId;
		this.activityId = activityId;
		this.signinTime = signinTime;
	}
	public ActivitySignin()
	{
		super();
	}
	
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}
	public int getActivityId()
	{
		return activityId;
	}
	public void setActivityId(Integer activityId)
	{
		this.activityId = activityId;
	}
	public Timestamp getSigninTime()
	{
		return signinTime;
	}
	public void setSigninTime(Timestamp signinTime)
	{
		this.signinTime = signinTime;
	}

}
