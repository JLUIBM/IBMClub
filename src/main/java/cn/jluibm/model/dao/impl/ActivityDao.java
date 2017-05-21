package cn.jluibm.model.dao.impl;

import cn.jluibm.model.entity.Activity;

public class ActivityDao extends BaseDao<Activity>
{
	public ActivityDao()
	{
		clazz = Activity.class;
	}

	@Override
	public void addObject(Object obj)
	{
		Activity activity = (Activity) obj;
		String sql = "insert into activities(title,activity_time,publish_time,manager,"
				+ "location,content,user_id) values(?,?,?,?,?,?,?)";
		int activityId = update(sql, activity.getTitle(), activity.getActivityTime(), 
				activity.getPublishTime(), activity.getManager(), activity.getLocation(), 
				activity.getContent(),activity.getUserId());
		activity.setActivityId(activityId);
	}

	@Override
	public void deleteObjectByKey(Object key)
	{
		int activityId = (int) key;
		String sql = "delete from activities where activity_id=?";
		update(sql, activityId);
	}

}
