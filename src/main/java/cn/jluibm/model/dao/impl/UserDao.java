package cn.jluibm.model.dao.impl;

import cn.jluibm.model.entity.User;

public class UserDao extends BaseDao<User>
{
	public UserDao()
	{
		clazz = User.class;
	}

	@Override
	public void addObject(Object obj)
	{
		User user = (User) obj;
		String sql = "insert into users(username,password,realname,sex,academy,degree,"
				+ "grade,student_num,phone_num,qq,email,permission,signup_time,"
				+ "birthday) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int userId = update(sql, user.getUsername(), user.getPassword(), user.getRealname(), 
				user.getSex(), user.getAcademy(), user.getDegree(), user.getGrade(), 
				user.getStudentNum(), user.getPhoneNum(), user.getQq(), user.getEmail(), 
				user.getPermission(), user.getSignupTime(), user.getBirthday());
		user.setUserId(userId);
	}

	@Override
	public void deleteObjectByKey(Object key)
	{
		int userId = (int) key;
		String sql = "delete from users where user_id=?";
		update(sql, userId);
	}

}
