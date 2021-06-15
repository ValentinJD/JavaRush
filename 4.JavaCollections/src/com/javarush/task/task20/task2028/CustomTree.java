package com.javarush.task.task20.task2028;                                                  
                                                  
import java.util.AbstractList;                                                  
import java.io.*;                                                  
import java.util.*;                                                  
                                                  
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {                                                  
    Entry<String> root;                                                  
    private  List<Entry<String>> nodesList = new ArrayList<Entry<String>>(); // лист с узлами дерева                                                  
                                                      
    public CustomTree(){                                                  
        root = new Entry<String>("root");                                                  
        nodesList.add(root);                                                  
    }                                                  
                                                      
    static class Entry<T> implements Serializable{                                                  
        String elementName;                                                  
        boolean availableToAddLeftChildren;                                                  
        boolean availableToAddRightChildren;                                                  
        Entry<T> parent, leftChild, rightChild;                                                  
                                                          
        public Entry(String Name){                                                  
            elementName = Name;                                                  
            this.availableToAddLeftChildren = true;                                                  
            this.availableToAddRightChildren = true;                                                  
        }                                                  
                                                          
        public boolean isAvailableToAddChildren(){                                                  
            return availableToAddLeftChildren || availableToAddRightChildren;                                                  
        }                                                  
                                                          
        void checkAdd() {                                                  
            if (leftChild == null) availableToAddLeftChildren = true;                                                  
            if (rightChild == null) availableToAddRightChildren = true;                                                  
        }                                                  
                                                  
    }
    
    
    
    public int in = 0; 
    
    public void p(){
        System.out.println("печатаем каждый элемент");
        for(Entry<String> entry:nodesList){
            System.out.print("Родитель - ");
            try{
                System.out.print(entry.parent.elementName);
            }catch(NullPointerException e ){
                System.out.print(" null ");
            }
            System.out.print(" Имя - ");
            try{
                System.out.print(entry.elementName);
            }catch(NullPointerException e ){
                System.out.print(" null ");
            }
            System.out.print(" Слева - ");
            try{
                System.out.print(entry.leftChild.elementName);
            }catch(NullPointerException e ){
                System.out.print(" null ");
            }
            System.out.print(" справа - ");
            try{
                System.out.print(entry.rightChild.elementName);
            }catch(NullPointerException e ){
                System.out.print(" null ");
            }
            System.out.print(" доступ к левому - ");
            try{
                System.out.print(entry.availableToAddLeftChildren);
            }catch(NullPointerException e ){
                System.out.print(" null ");
            }
            System.out.print(" доступ к правому - ");
            try{
                System.out.print(entry.availableToAddRightChildren);
            }catch(NullPointerException e ){
                System.out.print(" null ");
            }
            System.out.println();
        }
    }
    
    @Override                                                  
    public boolean add(String s){                                                  
                                                         
        boolean added = false;                                                  
        //Алгоритм                                                  
        // Получаем итератор                                                   
        Entry<String> currentNode;                                                  
        Iterator iterator = nodesList.iterator();                                                  
                                                          
        while(iterator.hasNext()){                                                  
            currentNode = (Entry<String>)iterator.next(); // Берем из листа узел присваиваем ссылке currentNode                                                  
            if(currentNode.availableToAddLeftChildren){  // Проверяем свободен ли левый участок узла currentNode                                                  
                Entry<String> newNode = new Entry<>(s);  // Создаем новый Entry                                                  
                currentNode.leftChild = newNode; // если да то присваиваем ссылке на левый участок новый узел,                                                  
                currentNode.availableToAddLeftChildren = false; //переводим переменную лефт в false break;                                                  
                newNode.parent = currentNode; //присваиваем ссылке нового узла текущий узел                                                  
                                                                  
                nodesList.add(newNode); //добавляем его в список узлов                                                  
                //System.out.println("Создан newNode слева с именем " + newNode.elementName);                                                  
                //System.out.println("c родителем " + newNode.parent.elementName); 
                //System.out.println("запись в левую ветку " + currentNode.availableToAddLeftChildren); 
                added =  true;                                                  
                break;                                                  
            }else if(currentNode.availableToAddRightChildren){ // иначе если правая ветка узла свободна                                                  
                Entry<String> newNode = new Entry<>(s); // Создаем новый Entry                                                  
                currentNode.rightChild = newNode; // то присваиваем ссылке на правый участок новый узел,                                                  
                currentNode.availableToAddRightChildren = false; //переводим переменную райт в false                                                  
                newNode.parent = currentNode;  //присваиваем ссылке нового узла текущий узел                                                  
                //System.out.println("Создаем newNode справа с именем " + s);                                                  
                //System.out.println("c родителем " + newNode.parent.elementName); 
                //System.out.println("запись в правую ветку " + currentNode.availableToAddRightChildren); 
                nodesList.add(newNode);  // добавляем его в список узлов                                                  
                                                                  
                added = true;                                                  
                break;                                                  
            }                                                  
            // далее если есть узлы в списке то начинаем цикл снова берем следующий эелемент                                                  
        }                                                  
        if(!added){ // если не нашлось доступных узлов нужно восстановить эту возможность у узлов                                                  
        // с запретом добавления                                                  
            if(in==0){                                            
                recoverAdd(); // восстанавливаем доступ  
               //System.out.println("восстанавливаем ");
               added = true;
                add(s); // добавляем узел 
                in++;
            }                                                  
        }                                                  
                                                          
        return added;                                                  
    }                                                  
                                                      
    private boolean recoverAdd(){ // восстановитель добавления новых узлов при недоступности                                                  
    boolean recover = false;                                                  
        Entry<String> currentNode;                                                  
        Iterator iterator = nodesList.iterator();                                                  
        while(iterator.hasNext()){                                                  
            currentNode = (Entry<String>)iterator.next(); // Берем из листа узел присваиваем ссылке currentNode                                                  
            if((!currentNode.isAvailableToAddChildren()) && (currentNode.parent != null) && (!currentNode.elementName.equals("root"))){                                                  
                //System.out.println("Восстановлено удаление узла с именем " + currentNode.elementName);                                                  
                currentNode.checkAdd();                                                  
                recover = true;                                                  
            }                                                  
        }                                                  
        return recover;                                                  
    }                                                  
                                                      
    public String getParent(String s){ 
        
        try{                                                  
            for(Entry<String> entry: nodesList){                                                  
                                                                  
                if(entry.elementName.equals(s)){                                                  
                    return entry.parent.elementName;                                                  
                }                                                  
            }                                                  
        }catch(NullPointerException e){                                                  
            return null;                                                  
        }                                                  
                                                              
                                                  
        return null;                                                  
    }   
    
                                                      
    public boolean remove(Object o){                                                  
        boolean removed = false;                                                  
                                                          
        if(o instanceof String){                               
            Entry<String> currentNode = null;                                                  
            Iterator iterator = nodesList.iterator();
            Integer check = 0;
            
            while(iterator.hasNext()){   
                
                currentNode = (Entry<String>)iterator.next(); // Берем из листа узел присваиваем ссылке currentNode                                                  
                //System.out.println("currentNode  " + currentNode.elementName); 
                    if(currentNode.elementName.equals(o)){
                        
                      if(currentNode == currentNode.parent.leftChild){
                          currentNode.parent.leftChild = null;
                          currentNode.parent = null;
                          if(currentNode.leftChild != null){
                              currentNode.leftChild.parent = null;
                          }
                          if(currentNode.rightChild != null){
                             currentNode.rightChild.parent = null;
                          }
                          currentNode.leftChild = null;
                          currentNode.rightChild = null;
                          currentNode.availableToAddRightChildren = false;
                          currentNode.availableToAddLeftChildren = false;
                          //System.out.println("удаление А" + check+ currentNode.elementName);
                          iterator.remove(); 
                          removed = true;  
                           
                      } else if(currentNode == currentNode.parent.rightChild)  {
                          currentNode.parent.rightChild = null;// удаляем у наследника справа
                          currentNode.parent = null; // удаляем ссылку у узла
                          if(currentNode.leftChild != null){
                              currentNode.leftChild.parent = null;
                          }
                          if(currentNode.rightChild != null){
                             currentNode.rightChild.parent = null;
                          }
                          currentNode.leftChild = null; // удаляем у узла
                          currentNode.rightChild = null;// удаляем у узла
                          currentNode.availableToAddRightChildren = false;
                          currentNode.availableToAddLeftChildren = false;
                          //System.out.println("удаление Б" + check + currentNode.elementName);
                          iterator.remove(); 
                          removed = true;
                           
                      } 
                    }
            }
            // удаляем узлы с родителем Null обнуляем детей 
            
            removerNullParent();
            
            
        } else throw new UnsupportedOperationException();                                                  
                                                          
        return removed;                                                  
    }
    
    private void removerNullParent(){
       
        for(int i =0; i < nodesList.size(); i++ ){
            Entry<String> node = nodesList.get(i);
            
            if(node.parent == null && (!node.elementName.equals("root"))){
                  nodesList.remove(node);
                  //System.out.println("удаление Нулей" + node.elementName);
                  if(node.leftChild != null)
                  node.leftChild.parent = null;
                  if(node.rightChild != null)
                  node.rightChild.parent = null;
                  i--;
                  removerNullParent();
            }
            
        }
        
    }
                                                      
    @Override                                                  
    public int size(){                                                  
        //System.out.println("Размер дерева вначале метода " + nodesList.size());                                                  
        Entry<String> currentNode;                                                  
        Iterator iterator = nodesList.iterator();                                                  
        while(iterator.hasNext()){                                                  
            currentNode = (Entry<String>)iterator.next(); // Берем из листа узел присваиваем ссылке currentNode                                                  
            if(currentNode == null){                                                  
                iterator.remove();                                                  
            }                                                  
        }                                                  
        //System.out.println("Размер дерева кол элементов списка " + (super.size()));                                                  
                                                          
        return nodesList.size()-1;                                                  
    }                                                  
                                                      
    @Override                                                  
    public String get(int index){                                                  
        throw new UnsupportedOperationException();                                                  
    }                                                  
                                                      
    @Override                                                  
    public String set(int index, String element){                                                  
        throw new UnsupportedOperationException();                                                  
    }                                                  
                                                      
    @Override                                                  
    public void add(int index, String element){                                                  
        throw new UnsupportedOperationException();                                                  
    }                                                  
                                                      
    @Override                                                  
    public String remove(int index){                                                  
        throw new UnsupportedOperationException();                                                  
    }                                                  
                                                      
    @Override                                                  
    public List<String> subList(int fromIndex, int toIndex){                                                  
        throw new UnsupportedOperationException();                                                  
    }                                                  
                                                      
    @Override                                                  
    protected void removeRange(int fromIndex, int toIndex){                                                  
        throw new UnsupportedOperationException();                                                  
    }                                                  
    @Override                                                  
    public boolean addAll(int index, Collection<? extends String> c){                                                  
        throw new UnsupportedOperationException();                                                  
    }                                                  
}