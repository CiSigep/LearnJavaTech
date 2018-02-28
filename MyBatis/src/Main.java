import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import sample.model.TestObject;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader read = Resources.getResourceAsReader("mybatis.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(read);
		SqlSession ss = ssf.openSession();
		Logger log = LogManager.getLogger(Main.class.getName());
		
		TestObject to = new TestObject();
		to.setId(1);
		to.setTestValue("TESTING");
		
		ss.insert("TestObject.insertObject", to);
		ss.commit();
		
		to = ss.selectOne("TestObject.selectObject", 1);
		log.info(to.getTestValue());
		
		to.setTestValue("TESTUPDATE");
		ss.update("TestObject.updateObject", to);
		ss.commit();
		
		to = ss.selectOne("TestObject.selectObject", 1);
		log.info(to.getTestValue());
		
		ss.delete("TestObject.deleteObject", to);
		ss.commit();
		
		ss.close();

	}

}
