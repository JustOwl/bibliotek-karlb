package se.nackademin;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GameTest {
    /*
     * Testing for input validation for:
     * Title        (input must be more than 0 and not null)
     * HowLongToBeat  (input must be more than 0)
     * Release Year (input must be more than 0)
     */
    @Test
    public void shouldReturnTrue_Title(){
        Game newGame = new Game();
        assertEquals(newGame.setTitel("Lorem Ipsum"), true);
    }

    @Test
    public void shouldReturnFalseIfInputLenghtIsZero_Title(){
        Game newGame = new Game();
        assertEquals(newGame.setTitel(""), false);
    }

    @Test
    public void shouldReturnFalseIfInputIsNull_Title(){
        Game newGame = new Game();
        assertEquals(newGame.setTitel(null), false);
    }

    @Test
    public void shouldReturnTrue_HowLongToBeat(){
        Game newGame = new Game();
        assertEquals(newGame.setHowLongToBeat(10), true);
    }

    @Test
    public void shouldReturnFalse_HowLongToBeat(){
        Game newGame = new Game();
        assertEquals(newGame.setHowLongToBeat(-10), false);
    }

    @Test
    public void shouldReturnTrue_ReleaseYear(){
        Game newGame = new Game();
        assertEquals(newGame.setReleaseYear(2023), true);
    }

    @Test
    public void shouldReturnFalse_ReleaseYear(){
        Game newGame = new Game();
        assertEquals(newGame.setReleaseYear(-10), false);
    }
}
