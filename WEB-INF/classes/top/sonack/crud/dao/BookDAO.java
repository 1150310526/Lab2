package top.sonack.crud.dao;

import top.sonack.crud.model.Book;
import top.sonack.crud.dao.utils.JdbcUtils;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

import com.opensymphony.xwork2.Result;

public class BookDAO
{
    private static BookDAO bookDAO = null;
    private static final String BOOK_TABLE_NAME = "Book";
    private Statement stmt;
    
    private BookDAO()
    {
	
    }
    
    public static BookDAO getBookDAO()
    {
	if(bookDAO == null)
	{
	    bookDAO = new BookDAO();
	}
	return bookDAO;
    }
    
    
    private static Book ORM(ResultSet res) throws SQLException
    {
	return new Book(res.getString("ISBN"),res.getString("Title"),res.getInt("AuthorID"),res.getString("Publisher"),res.getString("PublishDate"),res.getDouble("Price"));
    }
    
    public ArrayList<Book> getBooksByAuthorID(int authorID) throws SQLException
    {
	String sql = "SELECT * FROM " + BOOK_TABLE_NAME + " WHERE AuthorID = " + authorID ;
	System.out.println("查询书籍SQL:" + sql);
	stmt = JdbcUtils.getStatement();
	ResultSet res = stmt.executeQuery(sql);
	ArrayList<Book> books = new ArrayList<Book>();    
	while(res.next())
	{
	    Book book = ORM(res);
	    books.add(book);
	}
	return books;
    }
    
    
    
    
    public ArrayList<Book> getAllBooks() throws SQLException
    {
	String sql = "SELECT * FROM " + BOOK_TABLE_NAME;
	stmt = JdbcUtils.getStatement();
	ResultSet res = stmt.executeQuery(sql);
	ArrayList<Book> books = new ArrayList<Book>();    
	while(res.next())
	{
	    Book book = ORM(res);
	    books.add(book);
	}
	return books;
    }
    
    
    
    public void deleteBook(String isbn) throws SQLException
    {
	String sql = "DELETE FROM " + BOOK_TABLE_NAME + " WHERE isbn = '" + isbn + "'";
	System.out.println("删除" + sql);
	stmt = JdbcUtils.getStatement();
	stmt.executeUpdate(sql);
    }
    
    public void deleteBooks(String[] isbns) throws SQLException
    {
	for(String isbn : isbns)
	{
	    deleteBook(isbn);
	}
    }
    
    
    
}
