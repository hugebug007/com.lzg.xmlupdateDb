package com.lzg.xmlupdatedb.updatedbutils;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import com.lzg.xmlupdatedb.common.Const;

/**
 * dbConfig.xml文件解析工具类
 * 
 * @author lzg
 */
public class XMLParserUtils {

	/**
	 * 解析xml配置，将xml中配置解析为对应的DBConfigBean数据集
	 * 
	 * @param fileName
	 * @return
	 */
	public static List<DbConfigBean> parserConfig(String fileName) {
		/**
		 * 
		 */
		StringBuilder sb = new StringBuilder(Const.PATH);
		List<DbConfigBean> list = null;
		if (!"".equals(fileName)) {
			String url = sb.append(fileName).toString();
			BufferedInputStream in = new BufferedInputStream(
					XMLParserUtils.class.getClassLoader().getResourceAsStream(
							url));

			XmlPullParserFactory factory = null;
			XmlPullParser parser = null;
			DbConfigBean dbConfigBean = null;
			/**
			 * 根据xml配置文件解析生成对应的DbConfigBean实例对象。
			 */
			try {
				factory = XmlPullParserFactory.newInstance();
				factory.setNamespaceAware(true);
				parser = factory.newPullParser();
				parser.setInput(in, "UTF-8");

				for (int type = parser.getEventType(); type != XmlPullParser.END_DOCUMENT; type = parser
						.next()) {
					switch (type) {
					case XmlPullParser.START_DOCUMENT:
						list = new ArrayList<DbConfigBean>();
						break;
					case XmlPullParser.START_TAG:
						if ("table".equals(parser.getName())) {

							String table = parser.getAttributeValue(null,
									"tableName");
							if (table != null) {
								dbConfigBean = new DbConfigBean();
								dbConfigBean.setTable(parser.getAttributeValue(
										null, "tableName"));
							}
						}
						if (dbConfigBean != null) {
							if ("column".equals(parser.getName())) {
								/* 解析操作 */
								String operation = parser.getAttributeValue(
										null, "operation");
								if (operation != null && !operation.equals("")) {
									if (operation.equals(Const.ADD_DESCRIPTION)) {
										dbConfigBean.setOperation(Const.ADD);
									}
									/*
									 * else if (条件) { .......
									 * }......大家可以根据需要增加操作
									 */

								}

								String column = parser.getAttributeValue(null,
										"columnName");
								if (column != null && !operation.equals("")) {
									dbConfigBean.setColumn(parser
											.getAttributeValue(null,
													"columnName"));
								}

								String datatype = parser.getAttributeValue(
										null, "type");
								if (datatype != null && !operation.equals("")) {
									dbConfigBean.setType(parser
											.getAttributeValue(null, "type"));
								}

								dbConfigBean.setDefValue(parser
										.getAttributeValue(null, "defValue"));
							}
						}
						break;
					case XmlPullParser.END_TAG:
						if ("column".equals(parser.getName())) {
							list.add(dbConfigBean);
							dbConfigBean = null;
						}
						break;
					default:
						break;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (list != null) {
			return list;
		} else {
			return null;
		}

	}
}
