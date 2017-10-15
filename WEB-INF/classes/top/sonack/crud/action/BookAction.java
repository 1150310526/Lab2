package top.sonack.crud.action;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import top.sonack.crud.dao.AuthorDAO;
import top.sonack.crud.dao.BookDAO;
import top.sonack.crud.model.Author;
import top.sonack.crud.model.Book;

public class BookAction extends ActionSupport
{
    private static final long serialVersionUID = 1L;
    private ArrayList<Book> books;
    private ArrayList<Author> authors;
    private BookDAO bookDAO = BookDAO.getBookDAO();
    private AuthorDAO authorDAO = AuthorDAO.getAuthorDAO();
    private String isbn;
    private String[] isbns;
    private String searchAuthorName;
   
    private int finalAuthorID;
    private int sameAuthorCnt;
    private int authorID;
   
    private Author author;


    public ArrayList<Book> getBooks()
    {
	return books;
    }

    public void setBooks(ArrayList<Book> books)
    {
	this.books = books;
    }

 
    
    public String deleteBook() throws SQLException
    {
	bookDAO.deleteBook(isbn);
	return SUCCESS;
    }

    public String deleteBooks() throws SQLException
    {
	if (isbns != null)
	    bookDAO.deleteBooks(isbns);
	return SUCCESS;
    }

    public String list() throws SQLException
    {
	System.out.println("list() called!");
	books = bookDAO.getAllBooks();
	return SUCCESS;
    }

    public String listAuthors() throws SQLException
    {
	System.out.println("listAuthors() called!");
	authors = authorDAO.getAllAuthors();
	return SUCCESS;
    }

    public String confirmAuthor() throws SQLException
    {
	books = bookDAO.getBooksByAuthorID(finalAuthorID);
	if (books.size() == 0)
	    return "noBook";
	return SUCCESS;
    }

    public String searchBooks() throws SQLException
    {
	authors = authorDAO.getAuthorsByName(searchAuthorName);
	sameAuthorCnt = authors.size();
	if (sameAuthorCnt == 0)
	{
	    return "noBook";
	}
	else if (sameAuthorCnt > 1)
	{
	    return "morethan1";
	}
	finalAuthorID = authors.get(0).getAuthorID();
	return confirmAuthor();
    }

    public String searchAuthor() throws SQLException
    {
    		author = authorDAO.getAuthorByAuthorID(authorID);
    		return SUCCESS;
    }
    
    public String getIsbn()
    {
	return isbn;
    }

    public void setIsbn(String isbn)
    {
	this.isbn = isbn;
    }

    public String[] getIsbns()
    {
	return isbns;
    }

    public void setIsbns(String[] isbns)
    {
	this.isbns = isbns;
    }

    public String getSearchAuthorName()
    {
	return searchAuthorName;
    }

    public void setSearchAuthorName(String searchAuthorName)
    {
	this.searchAuthorName = searchAuthorName;
    }

    public ArrayList<Author> getAuthors()
    {
	return authors;
    }

    public void setAuthors(ArrayList<Author> authors) 
    {
	this.authors = authors;
    }

    public Author getAuthor()
    {
	return author;
    }

    public void setAuthor(Author author)
    {
	this.author = author;
    }

    public int getFinalAuthorID()
    {
	return finalAuthorID;
    }

    public void setFinalAuthorID(int finalAuthorID)
    {
	this.finalAuthorID = finalAuthorID;
    }
    
    public int getSameAuthorCnt()
    {
	return sameAuthorCnt;
    }

    public void setSameAuthorCnt(int sameAuthorCnt)
    {
	this.sameAuthorCnt = sameAuthorCnt;
    }

   
  
 
 

    public int getAuthorID()
    {
        return authorID;
    }

    public void setAuthorID(int authorID)
    {
        this.authorID = authorID;
    }

    
}
