
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class BasicQueue implements Iterable<Integer>{
    
    private ArrayList<Integer> elementData;
    private int numberOfElements;
    private int capacity;

    public BasicQueue() {
        this.elementData = new ArrayList<Integer>();
        this.numberOfElements = 0;
        this.capacity = 100;
    }
    public void reverse(int k){
        ArrayList<Integer> updated = new ArrayList<Integer>();
        for(int j=k-1;j>=0;j--){
            updated.add(elementData.get(j));
        }
        for(int m=k;m<elementData.size();m++){
            updated.add(elementData.get(m));
        }
        this.elementData = updated;
    }
    public int size() {
        return this.numberOfElements;
    }
    public boolean isEmpty() {
        return (numberOfElements == 0);
    }
    public boolean contains(Integer object) {
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

    public boolean add(Integer element) {                         // The enqueue operation.
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

    public boolean remove(Integer element) {
        if(numberOfElements == 0){
            try {
                throw new Exception();
            }
            catch (Exception ex) {
                System.out.println("Queue is empty!");
            }
        }
        else{
            this.elementData.remove(element);
            this.numberOfElements--;
            return true;
        }
        return false;
    }
    
    public Integer remove() throws Exception{                // This method will return the head(front) of the queue.(dequeue)
        if((numberOfElements == 0)){
            throw new Exception("No such element!");
        }
        Integer head = elementData.get(0);
        remove(head);
        return head;
    }
    
    public Integer element() throws Exception{
        if((numberOfElements == 0)){
            throw new Exception("No such element!");
        }
        
        Integer head = elementData.get(0);
        return head;
    }
    
    public boolean offer(Integer element){
        if(numberOfElements == capacity){
            return false;
        }
        add(element);
        return true;
    }
    public Integer peek(){
        if(numberOfElements == 0){
            return null;
        }
        return elementData.get(0);
    }
    public Integer poll(){
        if(numberOfElements == 0){
            return null;
        }
        Integer head = elementData.get(0);
        remove(head);
        return head;
    }
    public void clear() {
        this.numberOfElements = 0;
        this.elementData.clear();
    }
    public Iterator<Integer> iterator() {
        return new QueueIterator();
    }
    public String display(){
        String info = "";
        for(int j=0;j<size();j++){
            info+= String.valueOf(elementData.get(j))+" ";
        }
        return info;
    }
    
    public void  sort(){
        Integer[] array = toArray();
        Arrays.sort(array);
        clear();
        for(Integer o : array){
            elementData.add(o);
        } 
    }
    public class QueueIterator implements Iterator<Integer>{
        private int index = 0;

        @Override
        public boolean hasNext(){
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
}
    
    
    
    
    
    
