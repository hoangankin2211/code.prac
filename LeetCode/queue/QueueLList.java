public class Queue<E>{
    QueueElement<E> head;
    QueueElement<E> tail;
    int size;

    public Queue(){
        head = null;
        tail = null;
        size = 0;
    }

    public void enqueue(E element){
        QueueElement<E> newNode = new QueueElement<>(element);
        
        if (head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    public QueueElement<E> dequeue(){
        if (head == null){
            return null;
        }

        QueueElement<E> deElement = head;
        head = head.next;

        size--;

        return deElement;
    }

    public void display(){
        for (QueueElement e = head; e!=null; e=e.next){
            System.out.println(e.element);
        }
    }

    public static void main(String[] args){
        Queue<Integer> queue = new Queue<>();

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

class QueueElement<E>{
    E element;
    QueueElement<E> next;
    
    public QueueElement(E element){
        this.element = element;
        this.next = null;
    }

    public QueueElement(E element,QueueElement<E> next){
        this.element = element;
        this.next = next;
    }
}