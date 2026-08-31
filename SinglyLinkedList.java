public class SinglyLinkedList<E> {
    
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList(){

    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if (isEmpty()){
            return null;
        } 
        return head.getElement();
    }

    public E last(){
        if (isEmpty()){
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e){
        head = new Node<>(e, head);

        if (isEmpty()){
            tail = head;
        }
        size++;
    }

    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()){
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst(){
        if (isEmpty()){
            return null;
        }

        E answer = head.getElement();
        head = head.getNext();
        size--;

        if (isEmpty()){
            tail = null;
        }
        return answer;
    }

    // Write your codes below
    public String toString(){
        Node<E> ptr = head;
        StringBuilder output = new StringBuilder();
        while (ptr != null) {
            output.append(ptr.getElement());
            ptr = ptr.getNext();
        }
        return output.toString();
    }

    public E removeLast(){
        if (size == 0) {
            return null;
        } else if (size == 1) {
            Node<E> output = head;
            head = null;
            tail = null;
            size--; 
            return output.getElement();
        }
        Node<E> ptr = head;
        while (ptr.getNext() != tail) {
            ptr = ptr.getNext();
        }
        Node<E> output = tail; 
        ptr.setNext(null); 
        tail = ptr; 
        size--;
        return output.getElement();
    }

    public void reverse(){       
        if (size == 0) {
            return;
        }          
        Node<E> ptr = head; 
        tail = head;
        Node<E> prev = null;
        Node<E> next = null;
        while (ptr.getNext() != null) {
            next = ptr.getNext();
            ptr.setNext(prev);
            prev = ptr; 
            ptr = next; 
        }  
        ptr.setNext(prev);
        head = ptr; 
        return;
    }
}