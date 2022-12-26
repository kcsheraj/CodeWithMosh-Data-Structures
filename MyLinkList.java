import java.util.Iterator;
import java.util.NoSuchElementException;

import javafx.scene.shape.Line;

public class MyLinkList<E extends Comparable<E>> implements Iterable{
    private MyNode first;
    private MyNode last;
    private int size;

    public void addFirst(E object){
        MyNode<E> newNode;
        if(first==null){
            newNode = new MyNode<>(object,null);
            last = first = newNode;
        }
        else{
            newNode = new MyNode<>(object, first);
            first = newNode;
        }
        size++;

    }
    public void addLast(E object){
        MyNode<E> newNode = new MyNode<>(object,null);
        if(first==null){
            first=last= newNode;
        }
        else{
        last.next = newNode;
        last = newNode;
        }
        size++;
    }
    public void addLast(E object, MyNode next){
        MyNode<E> newNode = new MyNode<>(object,next);
        if(first==null){
            first=last= newNode;
        }
        else{
        last.next = newNode;
        last = newNode;
        }
        size++;
    }
    public void deleteFirst(){
        if(first!=null){
            MyNode nextNode = first.next;
            first.next = null;
            first = nextNode;
            size--;
        }
        else if(first==last){
            first = last = null;
            size--;
        }
        else{
            throw new NoSuchElementException();
        }

    }
    public void deleteLast(){
        if(first == null) throw new NoSuchElementException();
        if(first==last){
            first = last = null;
            size--;
            return;
        }
        MyNode temp = first;
        while(temp.next != last){
            temp = temp.next;
        }
        last = temp;
        last.next = null;
        size--;
    }
    public boolean contains(E object){
        if(indexOf(object) != -1) return true;
        return false;
    }
    public int indexOf(E object){
        MyNode traverser = first;
        int index = 0;
        while(traverser != null){
            if(traverser.value.equals(object)){
                return index;
            }
            traverser = traverser.next;
            index++;
        }
        return -1;
    }
    public int size(){

        return size;
    }
    @Override
    public String toString() {
        String ans = "";
        ans+="{";
        MyNode traverser = first;
        while(traverser != null){
            if(traverser.next != null){
            ans+= traverser.value+", ";
            }
            else{
                ans+= traverser.value;
            }
            traverser = traverser.next;
        }
        ans+="}";
        return ans;
    }
    public void reverse(){
        MyNode previousNode = null;
        MyNode currentNode = first;
        MyNode nextNode = first;
        last = first;
        while(currentNode!=null){
            nextNode = nextNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        first = previousNode;
        MyNode temp = first;

        
    }
    public E kthFromEndElementSize(int i) {
        int traverseTimes = size-i;
        MyNode temp = first;
        for(int j=0; j< traverseTimes; j++){
            temp = temp.next;
        }
        return (E)temp.value;
    }
    public E kthFromEndElementPointers(int i) {
        MyNode leftMyNode = first;
        MyNode rightMyNode = first;
        for(int j=0; j<i-1; j++){
            rightMyNode = rightMyNode.next;
        }
        while(rightMyNode.next!=null){
            leftMyNode = leftMyNode.next;
            rightMyNode = rightMyNode.next;
        }
        return (E)leftMyNode.value;
    }
   
    public MyNode getNode(E object){
        MyNode temp = first;
        while(!(temp.value.equals(object))){
            temp = temp.next;
        }
        return temp;
    }

    private void printMiddle() {
        MyNode one = first;
        MyNode two = first;

        while(two.next !=null && two != null){
            two = two.next.next;
            if(two==null) break;
            one = one.next;
        }

        if(two == null){//even
            System.out.println(one.value);
            System.out.println(one.next.value);
        }
        else{//odd
            System.out.println(one.value);
        }
    }

    private boolean hasLoop() {
        MyNode slow = first;
        MyNode fast = first;
        
        while(fast.next!=null&& fast!=null){
            slow = slow.next;
            fast = fast.next;
            if(slow==fast) return true;
        }

        return false;
    }


    @Override
    public Iterator iterator() {
        
        return new MyIterator();
    }

    private class MyIterator implements Iterator{
        MyNode current = first;
        @Override
        public boolean hasNext() {
            if(current!=null) return true;
            return false;
        }

        @Override
        public E next() {
            E temp = (E)current.value;
            current = current.next;
            return temp;
        }
        
    }

    public static void main(String[] args) {
        MyLinkList<String> myList = new MyLinkList<>();
        myList.addFirst("A");
        myList.addLast("B");
        myList.addLast("C");
        myList.contains("X");
        System.out.println(myList.contains("A"));
        System.out.println(myList.size);
        myList.deleteFirst();
        System.out.println(myList.size);
        System.out.println(myList);
        for(Object x: myList){
            System.out.println(x);
        }
       // myList.addFirst("A");
        myList.reverse();
        System.out.println(myList);

        System.out.println(myList.kthFromEndElementSize(2));
        System.out.println(myList.kthFromEndElementPointers(2));


        MyLinkList<String> myList2 = new MyLinkList<>();
        myList2.addLast("a");
        myList2.addLast("b");
        myList2.addLast("middle");
        myList2.addLast("d");
        //myList2.addFirst("e");
        myList2.printMiddle();//print the middle of the list in one pass


        MyLinkList<String> myList3 = new MyLinkList<>();
        myList3.addLast("a");
        myList3.addLast("b");
        myList3.addLast("c");
        myList3.addLast("d",myList3.getNode("a"));
        System.out.println(myList3);
        //System.out.println(myList3.hasLoop());


        
    }
}

