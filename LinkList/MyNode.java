public class MyNode<E extends Comparable<E>>{
    public E value;
    public MyNode next;
    public MyNode(E value, MyNode next){
        this.value = value;
        this.next = next;
    }

}
