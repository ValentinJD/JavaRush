package com.javarush.task.task18.task1827;                                                                                                    
                                                                                                    
/*                                                                                                     
Прайсы                                                                                                    
*/                                                                                                    
import java.io.*; 
import java.util.*;
                                                                                                    
public class Solution {                                                                                                    
    public static void main(String[] args) throws Exception {                                                                                                    
        BufferedReader readerSystem = new BufferedReader(new InputStreamReader(System.in));                                                                                                    
        String fileName = readerSystem.readLine(); // читаем имя файла для CrUD                                                                                                    
        readerSystem.close();                                                                                                    
        Integer id=0;
                                                                                                            
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));                                                                                                    
                                                                                                            
        if(args.length != 0){   // Ищем максимальный Id
            if(args[0].equals("-c")){                                                                                                    
                while(reader.ready()){
                    String fileString = reader.readLine();                                                                                                    
                    String sudstrId = fileString.substring(0, 8); 
                    sudstrId = sudstrId.replaceAll(" ", "");
                    int currentId = Integer.parseInt(sudstrId);                                                                                                    
                    if(currentId > id) id = currentId;
                } 
                
                String strId = (++id + "");
                if (strId.length()<8) {
                    StringBuilder builder = new StringBuilder(strId);
                    for (int i=0; i<(8-strId.length()); i++){
                        builder.append(" ");
                    }
                        strId = builder.toString();
                }
                    
                //String id = String.format("%-8d", ++lastId);
                String productName = String.format("%-30.30s", args[1]);
                String price = String.format(Locale.ROOT, "%-8.2f", Double.parseDouble(args[2]));
                String quantity = String.format("%-4d", Integer.parseInt(args[3]));
                    
                String output = ("\n" + strId + productName + price + quantity );
                BufferedWriter writerFile = new BufferedWriter(new OutputStreamWriter (new FileOutputStream(fileName, true)));
                writerFile.write(output);
                writerFile.close();
                    
            } else {}                                                                                        
        }
        reader.close();
    }                                                                                                    
}