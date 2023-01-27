package se.nackademin;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class MenuTest {
    
    @Test //Test SaveGame Method
    public void shouldReturnListWithGameObjectsWithSameValues(){
        ArrayList<String> gameListIn = new ArrayList<String>();
        List<Game> gameListOut = new ArrayList<Game>();
        Menu menu = new Menu();
        Game game = new Game();

        gameListIn.add("testTitel,123,321");
        game.setTitel("testTitel");
        game.setReleaseYear(123);
        game.setHowLongToBeat(321);

        gameListOut = menu.SaveGames(gameListIn);

        assertEquals(gameListOut.get(0).getTitle(), game.getTitle());
        assertEquals(gameListOut.get(0).getReleaseYear(), game.getReleaseYear());
        assertEquals(gameListOut.get(0).getHowLongToBeat(), game.getHowLongToBeat());
    }

    @Test //Test SaveBook Method
    public void shouldReturnListWithBookObjectsWithSameValues(){
        ArrayList<String> bookListIn = new ArrayList<String>();
        List<Book> bookListOut = new ArrayList<Book>();
        Menu menu = new Menu();
        Book book = new Book();

        bookListIn.add("testTitel,123,321");
        book.setTitel("testTitel");
        book.setReleaseYear(123);
        book.setPageCount(321);

        bookListOut = menu.SaveBooks(bookListIn);

        assertEquals(bookListOut.get(0).getTitle(), book.getTitle());
        assertEquals(bookListOut.get(0).getReleaseYear(), book.getReleaseYear());
        assertEquals(bookListOut.get(0).getPageCount(),book.getPageCount());
    }

    @Test //Test SaveMusic Method
    public void shouldReturnListWithMusicObjectsWithSameValues(){
        ArrayList<String> musicListIn = new ArrayList<String>();
        List<Music> musicListOut = new ArrayList<Music>();
        Menu menu = new Menu();
        Music music = new Music();

        musicListIn.add("testTitel,123,3.21");
        music.setTitel("testTitel");
        music.setReleaseYear(123);
        music.setMinutes(3.21f);

        musicListOut = menu.SaveMusic(musicListIn);

        assertEquals(musicListOut.get(0).getTitle(), music.getTitle());
        assertEquals(musicListOut.get(0).getReleaseYear(), music.getReleaseYear());
        assertEquals(musicListOut.get(0).getMinutes(),music.getMinutes(),0.1f);
    }

    

}