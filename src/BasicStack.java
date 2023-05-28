
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;


public class BasicStack implements Iterable<Integer>{
    
    private ArrayList<Integer> elementData;
    private int numberOfElements;
    private int capacity;

    public BasicStack() {
        this.elementData = new ArrayList<Integer>();
        this.capacity = 100;  
        this.numberOfElements =0;
    }

    public int size() {
        return this.numberOfElements;    
    }

    public boolean isEmpty() {
        return (numberOfElements == 0);  
    }

    public boolean contains(Object object) {    
        for(Integer element : elementData){
            if(element.equals(object)){
                return true;
            }
        }
        return false;
    }
    public Integer[] toArray() {
        Integer[] array = new Integer[size()];
        int index = 0;
        for(Integer element : elementData){
            array[index] = element;
            index++;
        }
        return array;
    }
    public boolean add(Integer element) {                                 // We are creating new array which has increased length and adding new element to the last index of it.
        if(size() == capacity){
            try{
                throw new Exception();
            }
            catch (Exception ex){
                System.out.println("Illegal state !");
                return false;
            }
        }
        this.elementData.add(size(),element);
        numberOfElements++;
        return true;
    }

    public boolean remove (Integer integer) {
        if(numberOfElements == 0){
            try {
                throw new Exception();
            }
            catch (Exception ex) {
                System.out.println("Stack is empty!");
            }
        }
        else{
            this.elementData.remove(integer);
            this.numberOfElements--;
            return true;
        }
        return false;
            
    }
    public void clear() {
        this.numberOfElements = 0;
        this.elementData.clear();
    }

    public Iterator<Integer> iterator() {
        return new StackIterator();
    }    
    public Integer push(Integer integer){
        if(numberOfElements != capacity){
            add(integer);
            return integer;
        }
        return null;
    }
    public Integer pop(){
        if(numberOfElements == 0){
            try {
                throw new Exception();
            }
            catch (Exception ex) {
                System.out.println("Stack is empty!");
            }
        }
        Integer element = this.elementData.get(size()-1);
        remove(element);
        return element;    
    }
    public boolean empty(){
        return isEmpty();
    }
    public Integer peek(){
        if(numberOfElements == 0){
            try{
                throw new Exception();
            }
            catch(Exception ex){
                System.out.println("Stack is empty!");
            }
        }
        return elementData.get(size()-1);
    }

    public void reverse(int k) {
        ArrayList<Integer> reversed = new ArrayList<Integer>();
        
        for(int i=size()-1;i>=0;i--){
            reversed.add(elementData.get(i));
        }
        ArrayList<Integer> updated = new ArrayList<Integer>();
        for(int j=k-1;j>=0;j--){
            updated.add(reversed.get(j));
        }
        for(int m=k;m<reversed.size();m++){
            updated.add(reversed.get(m));
        }
        ArrayList<Integer> finalForm = new ArrayList<Integer>();
        for(int i=size()-1;i>=0;i--){
            finalForm.add(updated.get(i));
        }
        this.elementData = finalForm;
    }
        
    public String display(){
        String info = "";
        for(int i=numberOfElements-1;i>=0;i--){
            info+= String.valueOf(elementData.get(i))+" ";
        }
        return info;
    }
    public void  sort(){
        Collections.sort(elementData);
    }
    public class StackIterator implements Iterator<Integer>{
        private int index = 0;

        @Override
        public boolean hasNext() {
            if(index < numberOfElements){
                return true;
            }
            return false;
        }

        @Override
        public Integer next() {
            Integer value = elementData.get(index);
            index++;
            return value;
        }
    }
    public ArrayList<Integer> getElementData() {
        return elementData;
    }

    public void setElementData(ArrayList<Integer> elementData) {
        this.elementData = elementData;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    
    
    
    
    
    
    }
    
    
    
    
    
    
    
