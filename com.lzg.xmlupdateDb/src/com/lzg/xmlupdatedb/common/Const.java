package com.lzg.xmlupdatedb.common;

/**
 * 
 * @author lzg
 *
 */
public class Const {
	/** 数据库更新操作配置文件xml的文件名 */
	public static final String DBCONFIG_NAME = "dbConfig.xml";
	/** 数据库的名称 */
	public final static String DB_NAME = "test_database";
	/** 数据库版本号 */
	public final static int DB_VERSION = 3;
	/** xml文件所在的包路径 */
	public final static String PATH = "com/lzg/xmlupdatedb/updatedbutils/";
	/** 增加字段 */
	public final static byte ADD = 1;
	/** 增加字段时xml里配置的描述 */
	public final static String ADD_DESCRIPTION = "add";
	/** 删除字段 */
	public final static byte DEL = 2;
	/** 删除字段时xml里配置的描述 */
	public final static String DEL_DESCRIPTION = "del";
}
