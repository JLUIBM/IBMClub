package cn.jluibm.model.entity;

import java.sql.Date;

public class User
{
	private int userId = -1;
	private String username;
	private String password;
	private String realname;
	private boolean sex;
	private String academy;
	private int degree;
	private int grade;
	private String studentNum;
	private String phoneNum;
	private String qq;
	private String email;
	private int permission;
	private Date signupTime;
	private Date birthday;
	
	public User(String username, String password, String realname, boolean sex, String academy, int degree,
			int grade, String studentNum, String phoneNum, String qq, String email, int permission, Date signupTime,
			Date birthday)
	{
		super();
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.sex = sex;
		this.academy = academy;
		this.degree = degree;
		this.grade = grade;
		this.studentNum = studentNum;
		this.phoneNum = phoneNum;
		this.qq = qq;
		this.email = email;
		this.permission = permission;
		this.signupTime = signupTime;
		this.birthday = birthday;
	}
	public User(String username, String password, String realname, boolean sex, String academy, int degree,
			int grade, String studentNum, String phoneNum, String qq, String email, int permission, Date signupTime)
	{
		super();
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.sex = sex;
		this.academy = academy;
		this.degree = degree;
		this.grade = grade;
		this.studentNum = studentNum;
		this.phoneNum = phoneNum;
		this.qq = qq;
		this.email = email;
		this.permission = permission;
		this.signupTime = signupTime;
	}
	public User()
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
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getRealname()
	{
		return realname;
	}
	public void setRealname(String realname)
	{
		this.realname = realname;
	}
	public boolean getSex()
	{
		return sex;
	}
	public void setSex(Boolean sex)
	{
		this.sex = sex;
	}
	public String getAcademy()
	{
		return academy;
	}
	public void setAcademy(String academy)
	{
		this.academy = academy;
	}
	public int getDegree()
	{
		return degree;
	}
	public void setDegree(Integer degree)
	{
		this.degree = degree;
	}
	public int getGrade()
	{
		return grade;
	}
	public void setGrade(Integer grade)
	{
		this.grade = grade;
	}
	public String getStudentNum()
	{
		return studentNum;
	}
	public void setStudentNum(String studentNum)
	{
		this.studentNum = studentNum;
	}
	public String getPhoneNum()
	{
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum)
	{
		this.phoneNum = phoneNum;
	}
	public String getQq()
	{
		return qq;
	}
	public void setQq(String qq)
	{
		this.qq = qq;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public int getPermission()
	{
		return permission;
	}
	public void setPermission(Integer permission)
	{
		this.permission = permission;
	}
	public Date getSignupTime()
	{
		return signupTime;
	}
	public void setSignupTime(Date signupTime)
	{
		this.signupTime = signupTime;
	}
	public Date getBirthday()
	{
		return birthday;
	}
	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}

}
