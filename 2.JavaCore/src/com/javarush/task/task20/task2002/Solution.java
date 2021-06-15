package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //File yourFile = File.createTempFile("C:\\Users\\Валентин\\Desktop\\test.txt", null);
            String yourFile = "C:\\Users\\Валентин\\Desktop\\test.txt";
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            List<User> users = javaRush.users;
            User user = new User();
            user.setFirstName("Иван");
            user.setLastName("Иванов");
            user.setBirthDate(new Date());
            user.setMale(true);
            user.setCountry(User.Country.RUSSIA);
            users.add(user);
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            javaRush.equals(loadedObject);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintStream stream = new PrintStream(outputStream);
            if (users != null){
                for (User user:users){
                    stream.println(user.getFirstName());
                    stream.println(user.getLastName());
                    //SimpleDateFormat date = new SimpleDateFormat();
                    stream.println(user.getBirthDate().getTime());
                    stream.println(user.isMale());
                    User.Country country = user.getCountry();
                    stream.println(country.getDisplayName());
                }
            }
        }
            //implement this method - реализуйте этот метод

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            while (true){
                User user = new User();
               // User.Country country;
                if (reader.ready()){
                    user.setFirstName(reader.readLine());
                } else break;
                if (reader.ready()){
                    user.setLastName(reader.readLine());
                }else break;
                if (reader.ready()){
                    //SimpleDateFormat date = new SimpleDateFormat();
                    user.setBirthDate(new Date(Long.parseLong(reader.readLine())));
                }else break;
                if (reader.ready()){
                   user.setMale(Boolean.parseBoolean(reader.readLine()));
                }else break;
                if (reader.ready()){
                    String countryText = reader.readLine();
                    if(countryText.equals("Ukraine")){
                        user.setCountry(User.Country.UKRAINE);
                    } else if(countryText.equals("Russia")){
                        user.setCountry(User.Country.RUSSIA);
                    } else user.setCountry(User.Country.OTHER);
                }else break;
                users.add(user);
            }
            //implement this method - реализуйте этот метод
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
