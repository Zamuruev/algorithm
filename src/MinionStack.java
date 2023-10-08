import java.util.Iterator;
import java.util.function.Consumer;

public class MinionStack<T> {
    private T []arr;
    private int size;
    private final int capacity = 3;
    public MinionStack() {
        arr = (T[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(T newItem) throws Exception {
        if(size < capacity){
            arr[size] = newItem;
            size++;
        }
        else {
            throw new Exception("No place in stack!");
        }
    }
    public void pop() throws Exception {
        if(!isEmpty()) {
            arr[size - 1] = null;
            size--;
        } else {
            throw new Exception("Stack is empty!");
        }
    }
    public T peek() throws Exception {
        if(!isEmpty()) {
            return arr[size - 1];
        } else {
            throw new Exception("Stack is empty");
        }
    }
    public void clear() throws Exception {
        if(!isEmpty()) {
            for(int i = 0; i < size; i++) {
                arr[i] = null;
            }
            size = 0;
            System.out.println("Stack cleared!");
        } else {
            throw new Exception("Stack is empty!");
        }
    }
    public void display() {
        if(isEmpty()) {
            System.out.println("Stack is empty!");
        } else {
            int count = size - 1;
            while(count >= 0 ) {
                System.out.println(arr[count]);
                count--;
            }
            System.out.println("The end of the stack!");
        }
    }
}
