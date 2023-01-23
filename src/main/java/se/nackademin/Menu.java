package se.nackademin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

public class Menu {
    public List<Game>  gameList  = new ArrayList<>();
    public List<Book>  bookList  = new ArrayList<>();
    public List<Music> musicList = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in).useDelimiter("\r?\n|\r")) {
            menu(sc);
        }

    }

    static void menu(Scanner sc) throws IOException, ClassNotFoundException {
        Menu menu = new Menu();
        while (true) {
            System.out.println("1.Write data to file" );
            System.out.println("2.Read data from file");
            System.out.println("3.List all saved data");
            System.out.println("4.Enter new entry manually");
            System.out.println("Enter a int 1-4 or 'exit' to quit: ");

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

    public void menu_choices(int i, Scanner sc) throws IOException, ClassNotFoundException {
        switch (i) {
            case 1:
                System.out.println("Write data to file");
                //TODO Call the CSV Writer
                break;
            case 2:
                System.out.println("Read data from file");
                this.ReadFromFile(sc);
                break;
            case 3:
                System.out.println("List all items");
                for (Game game : this.gameList) {
                    System.out.println("Game: "+game.getTitle());
                }
                //TODO Print all data from files
                break;
            case 4:
                System.out.println("Manually enter new entry");
                this.ManuallyEntry(sc);
                break;
            default:
                System.out.println("Unknown selection");
        }
    }

    public void ManuallyEntry(Scanner sc) {
        ArrayList<String> newValues = new ArrayList<>();
        System.out.println("What type of item do you wish to add?");
        System.out.println("1.Game");
        System.out.println("2.Book");
        System.out.println("3.Music");
        if (sc.hasNextInt()) {
            int choice = Integer.valueOf(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Formatting should be:[String, Int, Int]");
                    System.out.println("Input [title, releaseyear, howlongtobeat]");
                    newValues.add(sc.nextLine());
                    this.SaveSwitch("game", newValues);
                    break;
                case 2:
                    System.out.println("Formatting should be:[String, Int, Int]");
                    System.out.println("Input [title, releaseyear, pagecount]");
                    newValues.add(sc.nextLine());
                    this.SaveSwitch("book", newValues);
                    break;
                case 3:
                    System.out.println("Formatting should be:[String, Int, Float]");
                    System.out.println("Input [title, releaseyear, minutes]");
                    newValues.add(sc.nextLine());
                    this.SaveSwitch("music", newValues);
                    break;
                default:
                    break;
            }
        }
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
            //Input == Y but it still just exits??
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
}