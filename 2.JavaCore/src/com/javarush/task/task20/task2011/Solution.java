package com.javarush.task.task20.task2011;                                                                                                    
 import java.io.*;

/*                                                                                                     
Externalizable для апартаментов                                                                                                    
*/                                                                                                    
public class Solution {                                                                                                    
                                                                                                    
    public static class Apartment implements Externalizable{                                                                                                    
                                                                                                    
        private String address;                                                                                                    
        private int year;

                                                                                                    
        /**                                                                                                    
         * Mandatory public no-arg constructor.                                                                                                    
         */                                                                                                    
        public Apartment() { super(); }                                                                                                    
                                                                                                    
        public Apartment(String addr, int y) {                                                                                                    
            address = addr;                                                                                                    
            year = y;                                                                                                    
        }                                                                                                    
                                                                                                    
        /**                                                                                                    
         * Prints out the fields used for testing!                                                                                                    
         */                                                                                                    
        public String toString() {                                                                                                    
            return("Address: " + address + "\n" + "Year: " + year);                                                                                                    
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(this);
            //out.writeInt(year);

        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            this.address = (String)  in.readObject();
            //this.year = (int)in.readInt();

        }

        public static Solution.Apartment reInc (ObjectInput in) throws IOException, ClassNotFoundException {
            return (Solution.Apartment)in.readObject();
        }
    }
                                                                                                    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution.Apartment solution = new Solution.Apartment("Кинель", 1996);
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Валентин\\Desktop\\test.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        solution.writeExternal(objectOutputStream);
        //fileOutputStream.close();
        //objectOutputStream.close();
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Валентин\\Desktop\\test.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Solution.Apartment solution1 = Solution.Apartment.reInc(objectInputStream);

        System.out.println(solution1.address);
        System.out.println(solution1.year);
    }                                                                                                    
}