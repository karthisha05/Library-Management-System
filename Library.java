
import java.util.ArrayList;

import javax.management.Query;

public class Library
{

    private ArrayList<Book> books;

    public Library() 
    {
        books = new ArrayList<>();
    }

    private boolean book(Book book) 
    {
        for (Book b : books) 
        {
            if (b.getIsbn() == book.getIsbn()) 
            {
                return false;
            }
        }
        return true;
    }

    public void addBook(Book book)
    {
        if (book(book)) 
        {
            books.add(book);
            IO.println("Book added successfully.");
        } 
        else 
        {
            IO.println("Book with the same ISBN "  + book.getIsbn() + " already exists.");
        }
    }
    
    private Book searchBookByISBN(long isbn)
    {

        for (Book b : books) 
        {
            if (b.getIsbn() == isbn)
            {
                return b;
            }
        }
        return null;
    }

    public void displayAllBooks() 
    {
        if (books.isEmpty()) 
        {
            IO.println("No books available in the Library.");
        } 
        else 
        {
            IO.println("Books Available in Library:");
            
            for(Book b: books)
            {
            	IO.println(b.displayBook());
            }
        }
    }
    
    public void updateBookQuantityByISBN(long isbn,int newQuantity)
    { 
      if(newQuantity<=0)
      {
    	  IO.println("Error:quantity must be greater than zero");
    	  return;
      }
      
      Book b=searchBookByISBN(isbn);
      
      if(b!=null)
      {
    	  b.setQuantity(newQuantity);
    	  IO.println("Book quantity is updated successfully");
      }
      else
      {
    	  IO.println("Book with ISBN"+isbn+"not found");
      } 	 
    }
    
    public void deleteBookByTitle(String title)
    {
    	    if (title == null || title.isBlank()) 
    	    {
    	        IO.println("Book Title cannot be blank");
    	        return;
    	    }

    	    boolean found = false;

    	    for (Book b : books)
    	    {
    	    	
    	        if (b.getTitle().equals(title.trim())) 
    	        {
    	            books.remove(b);
    	            IO.println("Book deleted successfully.");
    	            found = true;
    	            break;
    	        }
    	    }
    	    
    	    if (!found) 
    	    {
    	        IO.println("Book with title " + title + " not found.");
    	    }
    	}  
