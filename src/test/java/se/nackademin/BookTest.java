package se.nackademin;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BookTest {
    
    /*
     * Testing for input validation for:
     * Title        (input must be more than 0 and not null)
     * Page Count   (input must be more than 0)
     * Release Year (input must be more than 0)
     */

    @Test
    public void shouldReturnTrue_Title(){
        Book newBook = new Book();
        assertEquals(newBook.setTitel("Lorem Ipsum"), true);
    }

    @Test
    public void shouldReturnFalseIfInputLenghtIsZero_Title(){
        Book newBook = new Book();
        assertEquals(newBook.setTitel(""), false);
    }

    @Test
    public void shouldReturnFalseIfInputIsNull_Title(){
        Book newBook = new Book();
        assertEquals(newBook.setTitel(null), false);
    }

    @Test
    public void shouldReturnTrue_PageCount(){
        Book newBook = new Book();
        assertEquals(newBook.setPageCount(10), true);
    }

    @Test
    public void shouldReturnFalse_PageCount(){
        Book newBook = new Book();
        assertEquals(newBook.setPageCount(-10), false);
    }

    @Test
    public void shouldReturnTrue_ReleaseYear(){
        Book newBook = new Book();
        assertEquals(newBook.setReleaseYear(2023), true);
    }

    @Test
    public void shouldReturnFalse_ReleaseYear(){
        Book newBook = new Book();
        assertEquals(newBook.setReleaseYear(-10), false);
    }

}
