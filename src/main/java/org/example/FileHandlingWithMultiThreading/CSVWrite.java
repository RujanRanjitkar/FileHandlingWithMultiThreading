package org.example.FileHandlingWithMultiThreading;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVWrite {
    public static void main(String[] args) {
        String csvFile = "D:\\Intern Syllabus\\MOCK_FLIGHT_DATA.csv";
        String csvFile1 = "D:\\Intern Syllabus\\MOCK_FLIGHT_DATA1.csv";
        String line = "";
        String csvSeparator = ",";
        ArrayList<List<String>> list = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            BufferedWriter writer=new BufferedWriter(new FileWriter(csvFile1));
            while ((line = reader.readLine()) != null) {
                List<String> row = Arrays.asList(line.split(csvSeparator, -1));
                if(row.size()==5){
                    if((row.get(4).isEmpty())){
                        row.set(4,"N/A");
                    }
                }
                list.add(row);
            }
            reader.close();
            System.out.println(list);
            for(List<String> value: list){
                writer.write(String.join(csvSeparator, value) + "\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
