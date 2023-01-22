package se.nackademin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

public class Menu {
    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in).useDelimiter("\r?\n|\r")) {
            menu(sc);
        }

    }

    static void menu(Scanner sc) throws IOException, ClassNotFoundException {
        while (true) {
            System.out.println("1.Write data to file" );
            System.out.println("2.Read data from file");
            System.out.println("3.List all saved data");
            System.out.print("Enter a int 1-3 or 'exit' to quit: ");

            if (sc.hasNextInt()) {
                int choice = Integer.valueOf(sc.nextLine());
                Menu.menu_choices(choice, sc);
            } else {
                if (sc.nextLine().equals("exit")) {
                    break;
                }
            }
        }
    }

    static void menu_choices(int i, Scanner sc) throws IOException, ClassNotFoundException {
        switch (i) {
            case 1:
                System.out.println("Write data to file");
                //TODO Call the CSV Writer
                break;
            case 2:
                System.out.println("Read data from file");
                ReadFromFile(sc);
                //TODO Call the CSV Reader
                break;
            case 3:
                System.out.println("List all items");
                //TODO Print all data from files
                break;
            default:
                System.out.println("Unknown selection");
        }
    }

    public static void ReadFromFile(Scanner sc){
        System.out.println("Enter path (including name and file extension) of file: ");
        try{
            if(sc.hasNextLine()){
                String filePath = String.valueOf(sc.nextLine()); 
                ArrayList<String> readValues = CSVHandler.CSVReader(filePath);
                System.out.println(readValues);

                System.out.println("Would you like to save this file to the program? [Y/N]: ");
                if(sc.hasNextLine()){
                    String input = String.valueOf(sc.nextLine());
                    if(input == "Y"){
                        SaveToProgram(sc,readValues);
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void SaveToProgram(Scanner sc, ArrayList<String> values){
        System.out.println("Input item type: ");
        if(sc.hasNextLine()){
            String input = String.valueOf(sc.nextLine());
            SaveSwitch(input, values);
        }
    }

    public static void SaveSwitch(String input, ArrayList<String> values){
        switch (input) {
            case "game":
                SaveGame(values);
                break;
            case "book":
                
                break;
            case "music":

                break;

            default:
                System.out.println("Sorry that is not a valid input");
                break;
        }
    }
    //TODO Make copy of this but for Books and Music (if it works)
    public static void SaveGame(ArrayList<String> values){
        if(values != null){
            List<Game> gameList = new ArrayList<>();
            for (int index = 1; index < values.size(); index++) {
                String value1 = values.get(index);
                String[] value1Split = value1.split(","); 
                Game newGame = new Game();

                newGame.setTitel(value1Split[0]);
                newGame.setReleaseYear(Integer.valueOf(value1Split[1]));
                newGame.setHowLongToBeat(Integer.valueOf(value1Split[2]));
                gameList.add(newGame);
            }
        }else{
            //TODO make the user input desired values
        }
    }
}