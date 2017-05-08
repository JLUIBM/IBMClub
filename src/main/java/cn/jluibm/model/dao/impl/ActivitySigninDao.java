package cn.jluibm.model.dao.impl;

import cn.jluibm.model.entity.ActivitySignin;

public class ActivitySigninDao extends BaseDao<ActivitySignin>
{
	public ActivitySigninDao()
	{
		clazz = ActivitySignin.class;
	}

	@Override
	public void addObject(Object obj)
	{
		ActivitySignin activitySignin = (ActivitySignin) obj;
		String sql = "insert into activity_signin values(?,?,?)";
		update(sql, activitySignin.getUserId(), activitySignin.getActivityId(), 
				activitySignin.getSigninTime());
	}

	/**
	 * 通过活动id删除整次活动的签到记录
	 */
	@Override
	public void deleteObjectByKey(Object key)
	{
		int activityId = (int) key;
		String sql = "delete from activity_signin where activity_id=?";
		update(sql, activityId);
	}

}
