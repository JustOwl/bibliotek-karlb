package se.nackademin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

public class Menu {
    private List<Game>  gameList  = new ArrayList<>();
    private List<Book>  bookList  = new ArrayList<>();
    private List<Music> musicList = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in).useDelimiter("\r?\n|\r")) {
            menu(sc);
        }
    }

    static void menu(Scanner sc) throws IOException, ClassNotFoundException {
        Menu menu = new Menu();
        System.out.println("Do you wish to load all saved data? [Y/N]");
        if(sc.hasNextLine()){
            String input = String.valueOf(sc.nextLine());
            if(input.equalsIgnoreCase("Y")){
                menu.loadSavedFiles();
            }
        }
        while (true) {
            System.out.println("1.Export data to new file" );
            System.out.println("2.Read data from file");
            System.out.println("3.List all saved data");
            System.out.println("4.Enter new entry manually");
            System.out.println("5.Save all changes to the catalog");
            System.out.println("Enter a int 1-5 or 'exit' to quit: ");

            if (sc.hasNextInt()) {
                int choice = Integer.valueOf(sc.nextLine());
                menu.menu_choices(choice, sc);
            } else {
                if (sc.nextLine().equals("exit")) {
                    break;
                }
            }
        }
    }

    public void loadSavedFiles(){
        ArrayList<String> gameValues  = new ArrayList<>();
        ArrayList<String> bookValues  = new ArrayList<>();
        ArrayList<String> musicValues = new ArrayList<>();

        gameValues = CSVHandler.CSVReader("data/games.csv");
        bookValues = CSVHandler.CSVReader("data/books.csv");
        musicValues = CSVHandler.CSVReader("data/music.csv");
        SaveSwitch("game" , gameValues);
        SaveSwitch("book" , bookValues);
        SaveSwitch("music", musicValues);
    }

    public void writeCurrectItemsToNewFile(String fileName, Scanner sc){
        System.out.println("Input type of object");
        if(sc.hasNextLine()){
            String type = String.valueOf(sc.nextLine());
            writeSwitch(type, fileName);
        }
    }

    public void writeSwitch(String type, String fileName){
        List<String[]> valueToSave = new ArrayList<String[]>();
        switch (type) {
            case "game":
                String[] gameHeader = { "titel", "releaseyear", "howlongtobeat" };
                valueToSave = GetGameValues();
                CSVHandler.CSVWriter(fileName, valueToSave,gameHeader);
                break;
            case "book":
                String[] bookHeader = { "titel", "releaseyear", "pagecount" };
                valueToSave = GetBookValues();
                CSVHandler.CSVWriter(fileName, valueToSave, bookHeader);
                break;
            case "music":
                String[] musicHeader = { "titel", "releaseyear", "minutes" };
                valueToSave = GetMusicValues();
                CSVHandler.CSVWriter(fileName, valueToSave, musicHeader);
                break;
            default:
            System.out.println("Invalid input type");
                break;
        }
    }

    public void menu_choices(int i, Scanner sc) throws IOException, ClassNotFoundException {
        switch (i) {
            case 1:
                System.out.println("Input name of the new file");
                if(sc.hasNextLine()){
                    String input = String.valueOf(sc.nextLine());
                    this.writeCurrectItemsToNewFile(input+".csv", sc);
                }
                break;
            case 2:
                System.out.println("Read data from file");
                this.ReadFromFile(sc);
                break;
            case 3:
                System.out.println("List all items");
                this.PrintAllValues(sc);
                break;
            case 4:
                System.out.println("Manually enter new entry");
                this.ManualEntry(sc);
                break;
            case 5:
                System.out.println("Save all changes to the catalog");
                this.SaveToCatalog();
                break;
            default:
                System.out.println("Unknown selection");
        }
    }

    public void SaveToCatalog(){
        //Game
        writeSwitch("game", "data/games.csv");
        //Book
        writeSwitch("book", "data/books.csv");
        //Music
        writeSwitch("music", "data/music.csv");
    }

    public void PrintAllValues(Scanner sc){
        System.out.println("1.List all Games");
        System.out.println("2.List all Books");
        System.out.println("3.List all Music");
        System.out.println("4.List all items");
        if(sc.hasNextLine()){
            int type = Integer.valueOf(sc.nextLine());
            switch (type) {
                case 1:
                    printGames();
                    break;
                case 2:
                    printBooks();
                    break;
                case 3:
                    printMusic();
                    break;
                case 4:
                    printGames();
                    printBooks();
                    printMusic();
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }

    public void printGames(){
        System.out.println("All Games:");
        for (Game game : this.gameList) {
            System.out.println("Titel: "+game.getTitle()
                            +". Release Year: "+game.getReleaseYear()
                            +". How Long To Beat: "+game.getHowLongToBeat());
        }
    }

    public void printBooks(){
        System.out.println("All Books:");
        for (Book book : bookList) {
            System.out.println("Titel: "+book.getTitle()
                            +". Release Year: "+book.getReleaseYear()
                            +". Page Count: "+book.getPageCount());
        }
    }

    public void printMusic(){
        System.out.println("All Music");
        for (Music music : musicList) {
            System.out.println("Titel: "+music.getTitle()
                            +". Release Year: "+music.getReleaseYear()
                            +". Minutes: "+music.getMinutes());
        }
    }

    public ArrayList<String> ManualEntry(Scanner sc) {
        String titleString  = "";
        int releaseyearInt  = 0;
        int howlongtobeatInt= 0;
        int pagecountInt    = 0;
        float minutesFloat  = 0f;
        ArrayList<String> newValues = new ArrayList<>();
        System.out.println("What type of item do you wish to add?");
        System.out.println("1.Game");
        System.out.println("2.Book");
        System.out.println("3.Music");
        if (sc.hasNextInt()) {
            int choice = Integer.valueOf(sc.nextLine());
            System.out.println("Title:");
            if (sc.hasNextLine()){
                titleString = String.valueOf(sc.nextLine());
            }
            System.out.println("Release Year:");
            if(sc.hasNextLine()){
                releaseyearInt = Integer.valueOf(sc.nextLine());
            }
            switch (choice) {
                case 1: //Game
                    System.out.println("How Long To Beat:");
                    if (sc.hasNextLine()){
                        howlongtobeatInt = Integer.valueOf(sc.nextLine());
                    }
                    newValues.add(titleString+","+releaseyearInt+","+howlongtobeatInt);
                    this.SaveSwitch("game", newValues);
                    return newValues;
                case 2: //Book
                    if (sc.hasNextLine()){
                        System.out.println("Page Count:");
                        pagecountInt = Integer.valueOf(sc.nextLine());
                    }
                    newValues.add(titleString+","+releaseyearInt+","+pagecountInt);
                    this.SaveSwitch("book", newValues);
                    return newValues;
                case 3: //Music
                    if (sc.hasNextLine()){
                        System.out.println("Minutes:");
                        minutesFloat = Float.valueOf(sc.nextLine());
                    }
                    newValues.add(titleString+","+releaseyearInt+","+minutesFloat);
                    this.SaveSwitch("music", newValues);
                    return newValues;
                default:
                    return newValues;
            }
        }
        return newValues;
    }

    public void ReadFromFile(Scanner sc){
        System.out.println("Enter path (including name and file extension) of file: ");
        ArrayList<String> readValues = new ArrayList<>();
        try{
            if(sc.hasNextLine()){
                String filePath = String.valueOf(sc.nextLine()); 
                readValues = CSVHandler.CSVReader(filePath);
                for (String i : readValues) {
                    System.out.println(i);
                }
            }
            System.out.println("Would you like to save this file to the program? [Y/N]: ");
            if(sc.hasNextLine()){
                String input = String.valueOf(sc.nextLine());
                if(input.equalsIgnoreCase("Y")){
                    SaveToProgram(sc,readValues);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void SaveToProgram(Scanner sc, ArrayList<String> values){
        System.out.println("Input item type: ");
        if(sc.hasNextLine()){
            String input = String.valueOf(sc.nextLine());
            this.SaveSwitch(input, values);
        }
    }

    public void SaveSwitch(String input, ArrayList<String> values){
        switch (input) {
            case "game":
                this.SaveGames(values);
                break;
            case "book":
                this.SaveBooks(values);
                break;
            case "music":
                this.SaveMusic(values);
                break;
            default:
                System.out.println("Sorry that is not a valid input");
                break;
        }
    }

    /*
     * These 3 methods are used to format the values read from
     * the files and generate objects of the correct type for later use
     */

    public List<Game> SaveGames(ArrayList<String> values){
        int indexStart;
        if(values.size()>1){
            indexStart = 1;
        }else{
            indexStart = 0;
        }
        for (int index = indexStart; index < values.size(); index++) {
            String value1 = values.get(index);
            String[] value1Split = value1.split(","); 
            Game newGame = new Game();

            newGame.setTitel(value1Split[0]);
            newGame.setReleaseYear(Integer.valueOf(value1Split[1]));
            newGame.setHowLongToBeat(Integer.valueOf(value1Split[2]));
            this.gameList.add(newGame);
        }
        return this.gameList;
    }

    public List<Book> SaveBooks(ArrayList<String> values){
        int indexStart;
        if(values.size()>1){
            indexStart = 1;
        }else{
            indexStart = 0;
        }
        for (int index = indexStart; index < values.size(); index++) {
            String value1 = values.get(index);
            String[] value1Split = value1.split(","); 
            Book newBook = new Book();

            newBook.setTitel(value1Split[0]);
            newBook.setReleaseYear(Integer.valueOf(value1Split[1]));
            newBook.setPageCount(Integer.valueOf(value1Split[2]));
            this.bookList.add(newBook);
        }
        return this.bookList;
    }

    public List<Music> SaveMusic(ArrayList<String> values){
        int indexStart;
        if(values.size()>1){
            indexStart = 1;
        }else{
            indexStart = 0;
        }
        for (int index = indexStart; index < values.size(); index++) {
            String value1 = values.get(index);
            String[] value1Split = value1.split(","); 
            Music newMusic = new Music();

            newMusic.setTitel(value1Split[0]);
            newMusic.setReleaseYear(Integer.valueOf(value1Split[1]));
            newMusic.setMinutes(Float.valueOf(value1Split[2]));
            this.musicList.add(newMusic);
        }
        return this.musicList;
    }

    /*
     * These 3 methods are used for formatting the values
     * so that they are easier to save to .csv
     */
    public List<String[]> GetGameValues(){
        List<String[]> values = new ArrayList<String[]>();
        for (Game game : this.gameList) {
            values.add(new String[]{(game.getTitle())
                      ,String.valueOf(game.getReleaseYear())
                      ,String.valueOf(game.getHowLongToBeat())});
        }
        return values;
    }

    public List<String[]> GetBookValues(){
        List<String[]> values = new ArrayList<String[]>();
        for (Book book : this.bookList) {
            values.add(new String[]{book.getTitle()
                    ,String.valueOf(book.getReleaseYear())
                    ,String.valueOf(book.getPageCount())});
        }
        return values;
    }

    public List<String[]> GetMusicValues(){
        List<String[]> values = new ArrayList<String[]>();
        for (Music music : this.musicList) {
            values.add(new String[]{music.getTitle()
                    ,String.valueOf(music.getReleaseYear())
                    ,String.valueOf(music.getMinutes())});
        }
        return values;
    }
}