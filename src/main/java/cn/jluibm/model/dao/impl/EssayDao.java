package cn.jluibm.model.dao.impl;

import cn.jluibm.model.entity.Essay;

public class EssayDao extends BaseDao<Essay>
{
	public EssayDao()
	{
		clazz = Essay.class;
	}

	@Override
	public void addObject(Object obj)
	{
		Essay essay = (Essay) obj;
		String sql = "insert into essays(title,author,time,type,topic,content,state) "
				+ "values(?,?,?,?,?,?,?)";
		int essayId = update(sql, essay.getTitle(), essay.getAuthor(), essay.getTime(), 
				essay.getType(), essay.getTopic(), essay.getContent(), essay.getState());
		essay.setEssayId(essayId);
	}

	@Override
	public void deleteObjectByKey(Object key)
	{
		int essayId = (int) key;
		String sql = "delete from essays where essay_id=?";
		update(sql, essayId);
	}

}
