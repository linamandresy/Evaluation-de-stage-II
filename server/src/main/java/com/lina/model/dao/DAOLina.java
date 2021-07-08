package com.lina.model.dao;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.LinkedList;

public class DAOLina {
	public String url;
	public String userName;
	public String password;
	public String driverName;

	public DAOLina(String driverName, String url, String userName, String password) {
		this.driverName = driverName;
		this.url = url;
		this.userName = userName;
		this.password = password;
	}

	public Connection connect() throws Exception {
		Class.forName(this.driverName);
		Connection c = DriverManager.getConnection(this.url, this.userName, this.password);
		c.setAutoCommit(false);
		return c;
	}

	private LinkedList<Method> getMethodStartWith(Class cl, String begin) throws Exception {
		Method[] methods = cl.getMethods();
		LinkedList<Method> result = new LinkedList<Method>();
		for (int i = 0; i < methods.length; i++) {
			if (methods[i].getName().toLowerCase().startsWith(begin.toLowerCase()))
				result.add(methods[i]);
		}
		return result;
	}

	public Method getMethodByName(Method[] methods, String name) throws Exception {
		for (int i = 0; i < methods.length; i++) {
			if (name.toLowerCase().equals(methods[i].getName().toLowerCase()))
				return methods[i];
		}
		throw new Exception("Nonrecognized method name");
	}

	public Method getMethodByName(Class cl, String name) throws Exception {
		return this.getMethodByName(cl.getMethods(), name);
	}

	private String[] getFieldName(Class cl) throws Exception {
		LinkedList<Method> setters = this.getMethodStartWith(cl, "set");
		String[] result = new String[setters.size()];
		for (int i = 0; i < setters.size(); i++)
			result[i] = setters.get(i).getName().substring(3);
		return result;
	}

	private boolean isIdNull(Method getter,Object caller)throws Exception{
		Object response = getter.invoke(caller,null);
		if(response==null){
			return false;
		}
		return response.getClass().getName().endsWith("Integer") && getter.getName().startsWith("getId") && response.equals(0);
	}
	public void insert(Connection c, Object obj) throws Exception {
		Class cl = obj.getClass();
		String tableName = cl.getSimpleName();
		String[] fieldName = getFieldName(cl);
		String sql = "INSERT INTO ".concat(tableName).concat("(");
		for (int i = 0; i < fieldName.length; i++) {
			if (!fieldName[i].toLowerCase().startsWith("id".concat(tableName.toLowerCase()))
					&& cl.getMethod("get".concat(fieldName[i]), null).invoke(obj, null) != null
					&& !isIdNull(cl.getMethod("get".concat(fieldName[i]), null), obj)) {
				if (!sql.endsWith("("))
					sql = sql.concat(",");
				sql = sql.concat(fieldName[i].toUpperCase());
			}
		}
		sql = sql.concat(") VALUES (");
		for (int i = 0; i < fieldName.length; i++) {
			if (!fieldName[i].toLowerCase().startsWith("id".concat(tableName.toLowerCase()))
					&& cl.getMethod("get".concat(fieldName[i]), null).invoke(obj, null) != null
					&& !isIdNull(cl.getMethod("get".concat(fieldName[i]), null), obj)) {
				if (!sql.endsWith("("))
					sql = sql.concat(",");
				sql = sql.concat("?");
			}
		}
		sql = sql.concat(")");
		PreparedStatement pst = c.prepareStatement(sql);
		int n = 1;
		for (int i = 0; i < fieldName.length; i++) {
			if (!fieldName[i].toLowerCase().startsWith("id".concat(tableName.toLowerCase()))
					&& cl.getMethod("get".concat(fieldName[i]), null).invoke(obj, null) != null
					&& !isIdNull(cl.getMethod("get".concat(fieldName[i]), null), obj)) {
				Method get = cl.getMethod("get".concat(fieldName[i]), null);
				Object value = get.invoke(obj, null);
				pst.setObject(n, value);
				n++;
			}
		}
		pst.execute();
	}

	public void insertAll(Connection c, Object obj) throws Exception {
		Class cl = obj.getClass();
		String tableName = cl.getSimpleName();
		String[] fieldName = getFieldName(cl);
		String sql = "INSERT INTO ".concat(tableName).concat("(");
		for (int i = 0; i < fieldName.length; i++) {
			if (cl.getMethod("get".concat(fieldName[i]), null).invoke(obj, null) != null
			&& !isIdNull(cl.getMethod("get".concat(fieldName[i]), null), obj)) {
				if (i != 0)
					sql = sql.concat(",");
				sql = sql.concat(fieldName[i].toUpperCase());
			}
		}
		sql = sql.concat(") VALUES (");
		for (int i = 0; i < fieldName.length; i++) {
			if (cl.getMethod("get".concat(fieldName[i]), null).invoke(obj, null) != null
			&& !isIdNull(cl.getMethod("get".concat(fieldName[i]), null), obj)) {
				if (i != 0)
					sql = sql.concat(",");
				sql = sql.concat("?");
			}
		}
		sql = sql.concat(")");
		PreparedStatement pst = c.prepareStatement(sql);
		for (int i = 0; i < fieldName.length; i++) {
			if (cl.getMethod("get".concat(fieldName[i]), null).invoke(obj, null) != null
			&& !isIdNull(cl.getMethod("get".concat(fieldName[i]), null), obj)) {
				Method get = cl.getMethod("get".concat(fieldName[i]), null);
				Object value = get.invoke(obj, null);
				pst.setObject(i + 1, value);
			}
		}
		pst.execute();
	}

	public void insert(Object obj) throws Exception {
		Connection c = null;
		try {
			c = connect();
			insert(c, obj);
			c.commit();
		} catch (Exception ex) {
			if (c != null)
				c.rollback();
			throw ex;
		} finally {
			if (c != null)
				c.close();
		}
	}

	public void insertAll(Object obj) throws Exception {
		Connection c = null;
		try {
			c = connect();
			insertAll(c, obj);
			c.commit();
		} catch (Exception ex) {
			if (c != null)
				c.rollback();
			throw ex;
		} finally {
			if (c != null)
				c.close();
		}
	}

	public void update(Connection c, Object obj) throws Exception {
		Class cl = obj.getClass();
		String tableName = cl.getSimpleName();
		String[] fieldName = getFieldName(cl);
		String sql = "UPDATE ".concat(tableName).concat(" SET ");
		for (int i = 0; i < fieldName.length; i++) {
			if(!isIdNull(cl.getMethod("get".concat(fieldName[i]), null), obj)){
				if (i != 0)
					sql = sql.concat(",");
				sql = sql.concat(fieldName[i].toUpperCase()).concat("= ? ");
			}
		}
		sql = sql.concat(" WHERE ID").concat(tableName).concat(" = ?");
		PreparedStatement pst = c.prepareStatement(sql);
		int n = 0;
		for (int i = 0; i < fieldName.length; i++) {
			if(!isIdNull(cl.getMethod("get".concat(fieldName[i]), null), obj)){
				Method get = cl.getMethod("get".concat(fieldName[i]), null);
				Object value = get.invoke(obj, null);
				pst.setObject(n + 1, value);
				n++;
			}
		}
		Method getId = this.getMethodStartWith(cl, "getId".concat(tableName)).getFirst();
		Object value = getId.invoke(obj, null);
		pst.setObject(n + 1, value);
		pst.execute();
	}

	public void update(Object obj) throws Exception {
		Connection c = null;
		try {
			c = this.connect();
			update(c, obj);
			c.commit();
		} catch (Exception ex) {
			if (c != null)
				c.rollback();
			throw ex;
		} finally {
			if (c != null)
				c.close();
		}
	}

	public void delete(Connection c, Object obj) throws Exception {
		Class cl = obj.getClass();
		String tableName = cl.getSimpleName();
		String[] fieldName = getFieldName(cl);
		String sql = "DELETE FROM ".concat(tableName).concat(" WHERE ");
		for (int i = 0; i < fieldName.length; i++) {
			if (i != 0)
				sql = sql.concat(",");
			sql = sql.concat(fieldName[i].toUpperCase()).concat("= ? ");
		}
		PreparedStatement pst = c.prepareStatement(sql);
		for (int i = 0; i < fieldName.length; i++) {
			Method get = cl.getMethod("get".concat(fieldName[i]), null);
			Object value = get.invoke(obj, null);
			pst.setObject(i + 1, value);
		}
		pst.execute();
	}

	public void delete(Object obj) throws Exception {
		Connection c = null;
		try {
			c = this.connect();
			delete(c, obj);
			c.commit();
		} catch (Exception ex) {
			if (c != null)
				c.rollback();
			throw ex;
		} finally {
			if (c != null)
				c.close();
		}
	}

	private LinkedList handleResultSet(ResultSet rs, Class cl) throws Exception {
		ResultSetMetaData meta = rs.getMetaData();
		int colCount = meta.getColumnCount();
		String[] colName = new String[colCount];
		for (int i = 0; i < colCount; i++) {
			colName[i] = meta.getColumnLabel(i + 1);
		}
		Method[] methods = cl.getMethods();
		Method setter;
		LinkedList result = new LinkedList();
		while (rs.next()) {
			Object resultElement = cl.newInstance();
			for (int i = 0; i < colCount; i++) {
				String name = "set".concat(colName[i]);
				setter = this.getMethodByName(methods, name);
				Object arg = rs.getObject(i + 1);
				if(arg==null){
					try {
						setter.invoke(resultElement, null);
					} catch (Exception e) {
						setter.invoke(resultElement,0);
					}
				}
				else if (arg.getClass().getName().endsWith("BigDecimal"))
					setter.invoke(resultElement, rs.getDouble(i + 1));
				else
					setter.invoke(resultElement, arg);
			}
			result.add(resultElement);
		}
		return result;
	}

	public LinkedList find(Connection c, Class cl) throws Exception {
		String tableName = cl.getSimpleName();
		String[] fieldName = getFieldName(cl);
		String sql = "SELECT ";
		for (int i = 0; i < fieldName.length; i++) {
			if (i != 0)
				sql = sql.concat(",");
			sql = sql.concat(fieldName[i].toUpperCase());
		}
		sql = sql.concat(" FROM ").concat(tableName);
		PreparedStatement pst = c.prepareStatement(sql);
		ResultSet rs = null;
		try {
			rs = pst.executeQuery();
			LinkedList result = this.handleResultSet(rs, cl);
			return result;
		} catch (Exception ex) {
			throw ex;
		} finally {
			if (rs != null)
				rs.close();
		}
	}

	public LinkedList find(Class cl) throws Exception {
		Connection c = null;
		try {
			c = this.connect();
			return find(c, cl);
		} catch (Exception ex) {
			throw ex;
		} finally {
			if (c != null)
				c.close();
		}
	}

	public Object findById(Connection c, Class cl, int id) throws Exception {
		String tableName = cl.getSimpleName();
		String[] fieldName = getFieldName(cl);
		String sql = "SELECT ";
		for (int i = 0; i < fieldName.length; i++) {
			if (i != 0)
				sql = sql.concat(",");
			sql = sql.concat(fieldName[i].toUpperCase());
		}
		sql = sql.concat(" FROM ").concat(tableName).concat(" WHERE ID").concat(tableName).concat(" = ?");
		PreparedStatement pst = c.prepareStatement(sql);
		pst.setInt(1, id);
		ResultSet rs = null;
		try {
			rs = pst.executeQuery();
			LinkedList result = this.handleResultSet(rs, cl);
			return result.getFirst();
		} catch (Exception ex) {
			throw ex;
		} finally {
			if (rs != null)
				rs.close();
		}
	}

	public Object findById(Class cl, int id) throws Exception {
		Connection c = null;
		try {
			c = this.connect();
			return findById(c, cl, id);
		} catch (Exception ex) {
			throw ex;
		} finally {
			if (c != null)
				c.close();
		}
	}
}
