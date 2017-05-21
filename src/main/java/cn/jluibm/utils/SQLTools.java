package cn.jluibm.utils;

public class SQLTools
{
	public static final String QUERY_USER = "select user_id userId,username,password,realname,"
			+ "sex,academy,degree,grade,student_num studentNum,phone_num phoneNum,qq,email,"
			+ "permission,signup_time signupTime,birthday from users ";
	public static final String QUERY_ESSAY = "select essay_id essayId,title,author,time,type,"
			+ "topic,content,state from essays ";
	public static final String QUERY_ACTIVITYSIGNIN ="select user_id userId,"
			+ "activity_id activityId,signin_time signinTime from activity_signin ";
	public static final String QUERY_ACTIVITY = "select activity_id activityId,title,"
			+ "activity_time activityTime,publish_time publishTime,manager,location,"
			+ "content, user_id userId from activities ";
}