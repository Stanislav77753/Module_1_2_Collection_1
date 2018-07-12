import java.util.Arrays;
import java.util.Iterator;


public class MyDynamicArrayList implements Iterable {
    private int initCapacity;
    private int[] array;
    private int size;
    private int capacity;

    public MyDynamicArrayList(){
        initCapacity = 10;
        capacity = initCapacity;
        array = new int[capacity];
        size = 0;
    }

    public MyDynamicArrayList(int initCapacity){
        capacity = initCapacity;
        array = new int[capacity];
        size = 0;
    }

    public void add(int element){
        if(size == capacity){
            createNewArray(capacity);
        }
        if(size == 0){
            array[size] = element;
            size++;
        }
        else{
            for(int i = 0; i < size;i++){
                array[i]+=element;
            }
            array[size] = element;
            size++;
        }
    }
    private void createNewArray(int arrayCapacity){
        int[] tempArray = new int[arrayCapacity];
        System.arraycopy(array, 0, tempArray, 0, size);
        /*for(int i = 0; i < size; i++){
            tempArray[i] = array[i];
        }*/
        capacity = arrayCapacity * 3 / 2;
        array = new int[capacity];
        System.arraycopy(tempArray, 0, array, 0, size);
        /*for(int i = 0; i < size; i++){
            array[i] = tempArray[i];
        }*/
    }

    public boolean add(int element, int index){
        if(index >= capacity | size == capacity){
            createNewArray(index > size ? index : capacity);
        }
        int[] tArray = new int[capacity];
        for(int i = 0; i < index;i++){
            tArray[i] = array[i] + element;
        }
        tArray[index] = element;
        for(int i = index; i < size; i++){
            tArray[i + 1] = array[i] + element;
        }
        array = tArray;
        if(index > size - 1){
            size = index + 1;
        }
        else{
            size++;
        }
        return true;
    }
    public int remove(){
        if(size == 0){
            try {
                throw new NoSuchFieldException();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        int temp = array[size - 1];
        int[] tempArray = new int[capacity];
        for(int i = 0; i < size - 1; i++){
            tempArray[i] = array[i] - Math.abs(temp);
        }
        array = tempArray;
        size--;
        return temp;
    }

    public int remove(int index){
        if(size == 0){
            try {
                throw new NoSuchFieldException();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        if(index >= size){
            throw new IndexOutOfBoundsException();
        }
        int temp = array[index];
        int[] tempArray = new int[capacity];
        for(int i = 0; i < index; i++){
            tempArray[i] = array[i] - temp;
        }
        for(int i = index + 1; i < size; i++){
            tempArray[i - 1] = array[i] - Math.abs(temp);
        }
        array = tempArray;
        size--;
        return temp;
    }

    public void trimToSize(){
        int[] tempArray = new int[size];
        for(int i = 0; i < size; i++){
            tempArray[i] = array[i];
        }
        capacity = size;
        array = tempArray;
    }

    public int findIndexElement(int element){
        int index = -1;
        for(int i = 0; i < size; i++){
            if(element == array[i]){
                index = i;
                break;
            }
        }
        return index;
    }
    public int findElementByIndex(int index){
        if(index >= size){
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    public int findMaxElement()  {
        if(size == 0){
            try {
                throw new NoSuchFieldException();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        int max = array[0];
        for(int i = 1; i < size; i++){
            if(max < array[i]){
                max = array[i];
            }
        }
        return max;
    }
    public int findMinElement() {
        if(size == 0){
            try {
                throw new NoSuchFieldException();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        int min = array[0];
        for(int i = 1; i < size; i++){
            if(min > array[i]){
                min = array[i];
            }
        }
        return min;
    }

    public int findAverage(){
        if(size == 0){
            try {
                throw new NoSuchFieldException();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        int sum = 0;
        for(int i = 0; i < size; i++){
            sum+=array[i];
        }
        return sum/size;
    }


    public int size(){
        return size;
    }

    @Override
    public String toString() {
        return "MyCollection_1{" +
                "capacity=" + capacity +
                ", array=" + Arrays.toString(array) +
                ", size=" + size +
                '}';
    }

    @Override
    public Iterator iterator() {
        Iterator iterator = new Iterator() {
            private int currentIndex = 0;
            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public Object next() {
                return array[currentIndex++];
            }

        };
        return iterator;
    }
}
