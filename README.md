# FileHandlingWithMultiThreading
Simple demo of file handling using multithreading

__Task overview__

You are provided with a CSV (comma-separated value) file that contains flight info. You need to split it into smaller files as per the request using multithreading. The files should be split based on a column value (for example, split the data into files where the value in the "curr_location" column is the same).
Split files should be sorted based on a specific column (for example, sort the rows within each split file based on the "destination_airport_code" column).

__Task Detail__

- Create a class to represent each row of data in the CSV file.
- Implement a CSV reader that reads the file and creates an object of the row class for each row.
- Implement a thread pool with a fixed number of threads.
- Submit each row to the thread pool for processing.
- Split the data into different files by “destination_airport_code” (file name must be the value of “destination_airport_code”)
- The output file must have removed the  rows if they are duplicated by “dept_time”
- Each output file should have the sorted data by column name  "curr_altitude_fit".
- If the “curr_location” is blank  you should set it to “N/A”
- Finally, print the result in the following format.

__Result Format:__

Total no of files generated: 40 <br>
MWV: 15 <br>
CMW: 111 <br>
AKK: 70 <br>

Where MWV,CMW, and AKK are the filenames you created in step 5 and the numeric value is the no of rows it contains

# Note:
- Remaining implementation of thread pool
- You should change the file path to data/MOCK_FLIGHT_DATA.csv
