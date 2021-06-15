package com.javarush.task.task36.task3601;

import java.util.*;

public class Model {
    public Service service = new Service();
    
    public List<String> getStringDataList() {
        return service.getData();
    }
}