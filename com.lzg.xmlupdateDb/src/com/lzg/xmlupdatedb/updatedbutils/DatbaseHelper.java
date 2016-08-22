package com.lzg.xmlupdatedb.updatedbutils;

import java.sql.SQLException;
import java.util.List;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.lzg.xmlupdatedb.common.Const;
import com.lzg.xmlupdatedb.entity.Student;

/**
 * 
 * @author lzg
 *
 */
public class DatbaseHelper extends OrmLiteSqliteOpenHelper {

	private Dao<Student, Integer> studentDao = null;

	/**
	 * 
	 * @param context
	 * @param databaseName
	 * @param factory
	 * @param databaseVersion
	 */
	private DatbaseHelper(Context context) {
		super(context, Const.DB_NAME, null, Const.DB_VERSION);
	}

	private static DatbaseHelper instance;

	/**
	 * 单例获取该Helper
	 * 
	 * @param context
	 * @return
	 */
	public static synchronized DatbaseHelper getHelper(Context context) {
		if (instance == null) {
			synchronized (DatbaseHelper.class) {
				if (instance == null)
					instance = new DatbaseHelper(context);
			}
		}

		return instance;
	}

	/**
	 * 
	 */
	@Override
	public void onCreate(SQLiteDatabase sqliteDatabase,
			ConnectionSource connectionSource) {
		try {
			TableUtils.createTableIfNotExists(connectionSource, Student.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 更新数据库操作
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource,
			int oldVersion, int newVersion) {
		String sqlStr = null;
		String sqlRename = null;
		String sqlInsert = null;
		String sqlDrop = null;
		List<DbConfigBean> beanList = XMLParserUtils
				.parserConfig(Const.DBCONFIG_NAME);
		if (beanList != null) {
			for (DbConfigBean bean : beanList) {
				if (bean != null) {
					byte operation = bean.getOperation();
					/* 根据要求进行数据库更新操作 */
					switch (operation) {
					case Const.ADD:
						sqlStr = "ALTER TABLE " + bean.getTable()
								+ " ADD COLUMN " + bean.getColumn() + " "
								+ bean.getType();
						break;
					}
					/* ........大家可以根据自己的需要增加操作 */
					try {
						db.execSQL(sqlStr);
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			}
		}
	}

	/**
	 * 获得userDao
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Dao<Student, Integer> getStudentDao() throws SQLException {
		if (studentDao == null) {
			studentDao = getDao(Student.class);
		}
		return studentDao;
	}

	/**
	 * 创建任务
	 * 
	 * @param context
	 * @param task
	 */
	public void createStudent(Context context, Student stu) {
		try {
			getHelper(context).getStudentDao().createOrUpdate(stu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 释放资源
	 */
	@Override
	public void close() {
		super.close();
		studentDao = null;
	}
}
