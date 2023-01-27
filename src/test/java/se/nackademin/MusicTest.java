package se.nackademin;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MusicTest {
    /*
     * Testing for input validation for:
     * Title        (input must be more than 0 and not null)
     * Minutes      (input must be more than 0 and not have a decimal value of more than x.60)
     * Release Year (input must be more than 0)
     */

    @Test
    public void shouldReturnTrue_Title(){
        Music newMusic = new Music();
        assertEquals(newMusic.setTitel("Lorem Ipsum"), true);
    }

    @Test
    public void shouldReturnFalseIfInputLenghtIsZero_Title(){
        Music newMusic = new Music();
        assertEquals(newMusic.setTitel(""), false);
    }

    @Test
    public void shouldReturnFalseIfInputIsNull_Title(){
        Music newMusic = new Music();
        assertEquals(newMusic.setTitel(null), false);
    }

    @Test
    public void shouldReturnTrue_Minutes(){
        Music newMusic = new Music();
        assertEquals(newMusic.setMinutes(3.14f), true);
    }

    @Test
    public void shouldReturnFalse_Minutes(){
        Music newMusic = new Music();
        assertEquals(newMusic.setMinutes(1.69f), false);
    }

    @Test
    public void shouldReturnTrue_ReleaseYear(){
        Music newMusic = new Music();
        assertEquals(newMusic.setReleaseYear(2023), true);
    }

    @Test
    public void shouldReturnFalse_ReleaseYear(){
        Music newMusic = new Music();
        assertEquals(newMusic.setReleaseYear(-10), false);
    }
}
