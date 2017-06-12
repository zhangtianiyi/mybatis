package db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DbSqlSession {
	public static SqlSession getSqlSession() throws IOException
    {
        Reader reader = Resources.getResourceAsReader("MybatisConfiguration.xml");

        SqlSessionFactory sqlSF = new SqlSessionFactoryBuilder().build(reader);
  
        SqlSession sqlSession = sqlSF.openSession();
        
        return sqlSession;
    }
}
