package com.lzg.xmlupdatedb.test;

import android.test.AndroidTestCase;

import com.lzg.xmlupdatedb.entity.Student;
import com.lzg.xmlupdatedb.updatedbutils.DatbaseHelper;

/**
 * junit测试类
 * 
 * @author lzg
 *
 */
public class TestClass extends AndroidTestCase {

	/**
	 * 测试方法
	 */
	public void test() {

		DatbaseHelper datbaseHelper = DatbaseHelper.getHelper(getContext());

		// Student student = new Student("草泥马领导", "nv", "22", "33", "isPeer",
		// "code");
		Student student = new Student();
		try {

			datbaseHelper.createStudent(getContext(), student);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
