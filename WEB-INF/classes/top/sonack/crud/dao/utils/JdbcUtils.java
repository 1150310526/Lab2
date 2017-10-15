package top.sonack.crud.dao.utils;

import java.sql.*;

public class JdbcUtils
{
    private static Connection connection;
    private static Statement statement;
 
    //System.getenv("MYSQL_HOST_S"); 为从库，只读
   /* private static final String DATABASE_NAME = "test";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1511NvWa";
    
    static
    {
	String d = "com.mysql.jdbc.Driver";
	try
	{
	    Class.forName(d);
	}
	catch(Exception e)
	{
	    e.printStackTrace();
	}
    }
    */
    public static Connection getConnection() throws SQLException
    {
	if(connection == null || connection.isClosed())
	{
//	    String url = "jdbc:mysql://pogvyhwsgvsf.rds.sae.sina.com.cn:10572/" + DATABASE_NAME;
	    
//	    本地服务器
//	    String url = "jdbc:mysql://localhost:3306/test";   
	    
//	    腾讯云服务器
	    /*String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8";
	    try
	    {
		connection = DriverManager.getConnection(url,USERNAME,PASSWORD);
	    }
	    catch(Exception e)
	    {
		System.out.println("数据库连接异常!");
		e.printStackTrace();
	    }
	}
	
	*/
		
		String driver = "com.mysql.jdbc.Driver";
		String username = System.getenv("ACCESSKEY");
		String password = System.getenv("SECRETKEY");
		//System.getenv("MYSQL_HOST_S"); 为从库，只读
		String dbUrl = String.format("jdbc:mysql://%s:%s/%s", System.getenv("MYSQL_HOST"), System.getenv("MYSQL_PORT"), System.getenv("MYSQL_DB"));
		try {
		    Class.forName(driver).newInstance();
		    connection = DriverManager.getConnection(dbUrl, username, password);
		    // ...
		} catch (Exception e) {
		    // ...
		}
    }
	return connection;
    }
    
    
    public static Statement getStatement() throws SQLException
    {
	if(statement == null || statement.isClosed())
	    statement = JdbcUtils.getConnection().createStatement();
	return statement;
    }
    
    
    public static void release(ResultSet res,Statement stmt,Connection conn)
    {
	if(res != null)
	{
	    try
	    {
		res.close();
	    } 
	    catch (SQLException e)
	    {
		e.printStackTrace();
	    }
	}
	
	if(stmt != null)
	{
	    try
	    {
		stmt.close();
	    } 
	    catch (SQLException e)
	    {
		e.printStackTrace();
	    }
	}
	
	if(conn != null)
	{
	    try
	    {
		conn.close();
	    } 
	    catch (SQLException e)
	    {
		e.printStackTrace();
	    }
	}
	
    }
    
    public static void release(Object o)
    {
	try
	{
	    if(o instanceof ResultSet)
	    {
		((ResultSet)o).close();
	    }else if (o instanceof Statement)
	    {
		((Statement) o).close();
	    } else if (o instanceof Connection)
	    {
		((Connection) o).close();
	    }
	    
	}
	catch(Exception e)
	{
	    e.printStackTrace();
	}
    }
    
    
}
