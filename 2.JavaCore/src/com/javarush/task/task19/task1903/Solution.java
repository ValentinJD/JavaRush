package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
    }

    public static class IncomeDataAdapter implements Customer, Contact{
        private IncomeData data;

        public IncomeDataAdapter(IncomeData data){
            this.data = data;
        }

        @Override
        public String getCompanyName() { //For example: JavaRush Ltd.
            return data.getCompany();
        }

        @Override
        public String getCountryName() { //For example: Ukraine
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() { //For example: Ivanov, Ivan
            return data.getContactLastName() + ", " +  data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {  //For example: +38(050)123-45-67
            String number = String.format("%010d", data.getPhoneNumber());

            return String.format("+%d(%s)%s-%s-%s",
                     data.getCountryPhoneCode(),
                    number.substring(0, 3),
                    number.substring(3, 6),
                    number.substring(6, 8),
                    number.substring(8, 10));
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}