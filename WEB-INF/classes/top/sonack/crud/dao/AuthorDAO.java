package top.sonack.crud.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import top.sonack.crud.dao.utils.JdbcUtils;
import top.sonack.crud.model.Author;
import top.sonack.crud.model.Book;

public class AuthorDAO
{
    private static AuthorDAO authorDAO = null;
    private static final String AUTHOR_TABLE_NAME = "Author";
    private Statement stmt;
    
    private AuthorDAO()
    {
	
    }
    
    public static AuthorDAO getAuthorDAO()
    {
	if(authorDAO == null)
	{
	    authorDAO = new AuthorDAO();
	}
	return authorDAO;
    }
    
    private static Author ORM(ResultSet res) throws SQLException
    {
	return new Author(res.getInt("AuthorID"),res.getString("Name"),res.getInt("Age"),res.getString("Country"));
    }
    
    
    public ArrayList<Author> getAuthorsByName(String name) throws SQLException
    {
	String sql = "SELECT * FROM " + AUTHOR_TABLE_NAME + " WHERE Name = '" + name +"'";
	System.out.println("SQL语句" + sql);
	stmt = JdbcUtils.getStatement();
	ResultSet res = stmt.executeQuery(sql);
	ArrayList<Author> authors = new ArrayList<Author>();    
	while(res.next())
	{
	    Author author = ORM(res);
	    System.out.println(author);
	    authors.add(author);
	}
	return authors;
    }
    
    public ArrayList<Author> getAllAuthors() throws SQLException
    {
	String sql = "SELECT * FROM " + AUTHOR_TABLE_NAME;
	stmt = JdbcUtils.getStatement();
	ResultSet res = stmt.executeQuery(sql);
	ArrayList<Author> authors = new ArrayList<Author>();    
	while(res.next())
	{
	    Author author = ORM(res);
	    System.out.println(author);
	    authors.add(author);
	}
	return authors;
    }
    
    
    
    public Author getAuthorByAuthorID(int authorID) throws SQLException
    {
	String sql = "SELECT * FROM " + AUTHOR_TABLE_NAME + " WHERE AuthorID = " + authorID + "";
	System.out.println("SQL语句" + sql);
	stmt = JdbcUtils.getStatement();
	ResultSet res = stmt.executeQuery(sql);
	Author author;
	while(res.next())
	{
	    author = ORM(res);
	    System.out.println(author);
	    return author;
	}
	return null;
    }
    

}
