package se.nackademin;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVHandler {
    private static String path = "D:\\2.Programming\\YH\\Java\\bibliotek 2\\bibliotek-karlb\\test.csv";
    public static void main(String[] args) throws Exception {
        //This main method is only used for testing, dont run from here
        ArrayList<String> readValues = CSVHandler.CSVReader(path);
        System.out.println(readValues.get(1));
        String value1 = readValues.get(1);
        String[] value1Split = value1.split(","); 
        System.out.println(value1Split[0]);
    }

    public static ArrayList<String> CSVReader(String filePath){
        String line = "";
        ArrayList<String> valueList = new ArrayList<String>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while((line = br.readLine()) != null){
                valueList.add(line);
            }
            br.close();
            return valueList;
        }catch(FileNotFoundException e){
            e.printStackTrace();
            return null;
        }catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }

}
