package test;

import java.util.List;

import com.syf.dao.NewsTypeDao;
import com.syf.entity.NewsType;

public class SQLTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println();
		newsTypeList();
		list();
	}

	private static void newsTypeList() {
		System.out.println(new NewsTypeDao().findAll());

	}

	private static void list() {
		NewsTypeDao newsTypeDao = new NewsTypeDao();
		List<NewsType> newsTypeList = newsTypeDao.findAll();
		for (NewsType newsType : newsTypeList) {
			System.out.println(newsType.getId() + newsType.getTypeName());
		}
	}
}
