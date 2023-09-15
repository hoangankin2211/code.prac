public class QueueArray<E extends Object>{
    java.util.List<E> array;
    int size;

    public QueueArray(){
        size = 0;
        array = new java.util.ArrayList<E>();
    }

    public void enqueue(E element){
        size++;
        array.add(element);
    }
    

    public E dequeue(){
        if (size < 1){
            return null;
        }
        size--;
        return array.remove(0);
    }

    public void display(){
        for (E e : array){
            System.out.println(e);
        }
    }

    public static void main(String[] args){
        QueueArray<Integer> queue = new QueueArray<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);

        queue.display();
    }
}

