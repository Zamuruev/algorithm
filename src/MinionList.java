import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

// Список миньонов
public class MinionList<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;

    public int size;

    // Внутренний класс для итератора
    private class MinionListIterator implements Iterator<T> {
        private Node<T> currentNode;

        public MinionListIterator() {
            currentNode = head;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T data = currentNode.node;
            currentNode = currentNode.prev; // Переходим к следующему узлу
            return data;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove() не поддерживается");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new MinionListIterator(); // Возвращаем итератор
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }

    // Класс узла
    private class Node<T> {
        T node;
        Node<T> prev;
        Node<T> next;

        public Node(T node) {
            this.node = node;
            this.prev = null;
            this.next = null;
        }
    }

    public MinionList() {
        this.head = null;
        this.tail = null;
    }

    // Добавление в начало списка (голова)
    public void addHead(T node) {
        Node<T> newNode = new Node<>(node);
        if(head == null) {
            tail = newNode;
        }
        else {
            head.next = newNode;
            newNode.prev = head;
            newNode.next = newNode;
        }
        head = newNode;
        this.size++;
    }

    // Добавление в конец списка (хвост)
    public void addTail(T node) {
        Node<T> newNode = new Node<>(node);
        if (head == null) {
            head = newNode;
        } else {
            if (tail != null) {
                newNode.next = tail;
                tail.prev = newNode;
            }
        }
        tail = newNode;
        this.size++;
    }

    // Удаление по объекту
    public void remove(T node) {
        Node<T> currentNode = head;
        while(currentNode != null) {
            if(currentNode.node.equals(node)) {
                if(currentNode == tail && currentNode != head) {
                    currentNode.node = null;
                    currentNode.next.prev = null;
                    tail = currentNode.next;
                }
                else {
                    if(currentNode == head) {
                        if(currentNode.prev != null) {
                            currentNode.prev.next = currentNode.prev;
                            head = currentNode.prev.next;
                        }
                        else {
                            currentNode.prev = currentNode.next = null;
                            head = tail = null;
                        }

                    }
                    else {
                        currentNode.prev.next = currentNode.next;
                        currentNode.next.prev = currentNode.prev;
                    }
                }
                this.size--;
                return;
            }
            currentNode = currentNode.prev;
        }
    }
    public void removeAll() {
        head = tail = null;
        this.size = 0;
    }

    public void set(T oldNode, T newNode1) {
        Node<T> currentNode = head;
        while(currentNode != null) {
            if(currentNode.node.equals(oldNode)) {
                currentNode.node = newNode1;
                return;
            }
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    // Индексатор
    public T getItem(int index) throws Exception {
        if(index < 0 || index >= size) {
            throw new Exception("invalid index");
        }
        Node<T> currentNode = head;
        if(index > 0) {
            int count = 1;
            while(count <= index) {
                currentNode = currentNode.prev;
                count++;
            }
        }

        return currentNode.node;
    }
}
