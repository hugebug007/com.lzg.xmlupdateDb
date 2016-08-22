package com.lzg.xmlupdatedb.updatedbutils;

/**
 * 数据库升级dbConfig.xml的bean类
 * 
 * @author lzg
 *
 */
public class DbConfigBean {

	private String table;
	private String column;
	/**
	 * 1 add, 2 del, 3 rename需要其他的操作可以自己定义
	 */
	private byte operation;
	private String type;
	private String defValue;

	public DbConfigBean() {
		super();
	}

	public DbConfigBean(String table, String column, byte operation,
			String type, String defValue) {
		super();
		this.table = table;
		this.column = column;
		this.operation = operation;
		this.type = type;
		this.defValue = defValue;
	}

	public String getTable() {
		return table;
	}

	public String getColumn() {
		return column;
	}

	public byte getOperation() {
		return operation;
	}

	public String getType() {
		return type;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public void setOperation(byte operation) {
		this.operation = operation;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDefValue() {
		return defValue;
	}

	public void setDefValue(String defValue) {
		this.defValue = defValue;
	}

}
