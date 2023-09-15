public class Queue{
    public static void main(String[] args){
        System.out.print("Hoang");
    }
}

class QueueElement<E>{
    final E element;
    final QueueElement<E> next;
    
    public QueueElement(E element){
        this.element = element;
        this.next = null;
    }

    public QueueElement(E element,QueueElement<E> next){
        this.element = element;
        this.next = next;
    }
}