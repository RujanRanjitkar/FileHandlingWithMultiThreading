package org.example.FileHandlingWithMultiThreading;

import java.io.*;
import java.util.*;

public class CSVRead {
    // method for reading a csv file
    static void readingFile(BufferedReader reader, ArrayList<Flight> arrayList, String csvSeparator) throws IOException{
        String line = " ";
        int value = 0;
        while ((line = reader.readLine()) != null) {
            // to read a file from row 2
            if (value >= 1) {
                String[] row = line.split(csvSeparator);
                String flight_id = row[0];
                int curr_altitude_fit =Integer.parseInt(row[1].isEmpty() ? String.valueOf(0) : row[1]);
                String destination_airport_code = row[2];
                String dept_time = row[3];
                String curr_location = row[4];
                Flight flight = new Flight(flight_id, curr_altitude_fit, destination_airport_code, dept_time, curr_location);
                arrayList.add(flight);
            }
            value++;
        }
    }

    // to insert data into hashmap
    static int insertIntoHashmap(HashMap<String, HashMap<String, Flight>> hashMap, ArrayList<Flight> arrayList){
        for (Flight flight : arrayList) {
            //This hashmap contains key as dept_time
            // if hashmap contains the airport code then return its value otherwise creates new hashmap
            HashMap<String, Flight> deptTimeMap = hashMap.getOrDefault(flight.getDestination_airport_code(), new HashMap<>());
            deptTimeMap.put(flight.getDept_time(), flight);
            hashMap.put(flight.getDestination_airport_code(), deptTimeMap);
        }
        return hashMap.size();
    }

    // to sort the value according to curr_altitude_fit
    static HashMap<String,ArrayList<Flight>> printingHashmap(HashMap<String, HashMap<String, Flight>> hashMap){
        HashMap<String, ArrayList<Flight>> sortedHashmap=new HashMap<>();
        for (Map.Entry<String, HashMap<String, Flight>> map : hashMap.entrySet()) {
            // contains values of main hashmap as key value pair
            HashMap<String,Flight> deptTimeHashmap=map.getValue();
            //store value of deptTimeHashmap as list
            ArrayList<Flight> sortedData=new ArrayList<>(deptTimeHashmap.values());
            //sorting the arraylist according to curr_altitude_fit
            Collections.sort(sortedData, new Curr_Altitude_Fit());
            // print the key of main hashmap and no. of values in that key
            System.out.println(map.getKey() + "->" + deptTimeHashmap.size());
            sortedHashmap.put(map.getKey(),sortedData);
        }
        return sortedHashmap;
    }

    //creating csv files according to key and writing their values
    static void writingIntoCSVFiles(HashMap<String, HashMap<String, Flight>> hashMap) throws IOException{
        // calling the method printingHashmap in printFile
        HashMap<String,ArrayList<Flight>> printFile = printingHashmap(hashMap);
        for(Map.Entry<String,ArrayList<Flight>> map: printFile.entrySet()){
            String key= map.getKey();
            String csvFile2="D:\\Intern Syllabus\\All Files\\" + key + ".csv";
            BufferedWriter writer=new BufferedWriter(new FileWriter(csvFile2));
            writer.write("flight_id" + "," + "curr_altitude_fit" + "," + "destination_airport_code" + "," + "dept_time" + "," + "curr_location");
            for(Flight flight: map.getValue()){
                writer.write(
                        "\n" + flight.getFlight_id()+ ","
                                + flight.getCurr_altitude_fit() + ","
                                + flight.getDestination_airport_code() + ","
                                + flight.getDept_time() + ","
                                + flight.getCurr_location()
                );
            }

            writer.flush();
        }
    }
    public static void main(String[] args) throws IOException{
        //location of file
        String csvFile = "D:\\Intern Syllabus\\MOCK_FLIGHT_DATA1.csv";
        String csvSeparator = ",";
        ArrayList<Flight> arrayList = new ArrayList<>();
        HashMap<String, HashMap<String, Flight>> hashMap = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        readingFile(reader,arrayList,csvSeparator);

        System.out.println("Total Files : " + insertIntoHashmap(hashMap,arrayList));

        writingIntoCSVFiles(hashMap);
    }
}
