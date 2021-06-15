package com.javarush.task.task19.task1904;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException, ParseException {
       /* Scanner scanner = new Scanner(new FileInputStream("C:\\Users\\Валентин\\Desktop\\test.txt"), "UTF-8");
        PersonScanner personScanner = new PersonScannerAdapter(scanner);
        Person person = personScanner.read();
        personScanner.close();
        System.out.println(person);*/

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;
        public PersonScannerAdapter(Scanner fileScanner){
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws ParseException {
            String line = fileScanner.nextLine();
            String[] strArray = line.split("\\s");
            String firstName = strArray[0];
            String middleName = strArray[1];
            String lastName= strArray[2];
            Person person;

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM y", Locale.getDefault());

            Date date = dateFormat.parse(strArray[3] + " " + strArray[4] + " " +strArray[5]);
            person =  new Person( middleName, lastName, firstName, date);
            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }

    }
}
