package se.nackademin;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.*;

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

    public static void CSVWriter(String filePath, List<String[]> values, String[] header){
        try {
            //Source: https://stackoverflow.com/a/52053662
            CSVWriter writer = new CSVWriter(
            new OutputStreamWriter(new FileOutputStream(filePath), StandardCharsets.UTF_8),
            ',',
            CSVWriter.NO_QUOTE_CHARACTER,
            CSVWriter.DEFAULT_ESCAPE_CHARACTER,
            CSVWriter.DEFAULT_LINE_END);

            writer.writeNext(header);
            writer.writeAll(values);

            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
