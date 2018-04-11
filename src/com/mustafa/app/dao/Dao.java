package com.mustafa.app.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public abstract class Dao {

	private final static String MYBATIS_CONFIG_FILE = "resources/mybatis-config.xml";
	protected static SqlSessionFactory sqlSessionFactory;
	
	static
	{
		try {
			InputStream inputStream = Resources.getResourceAsStream(MYBATIS_CONFIG_FILE);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
