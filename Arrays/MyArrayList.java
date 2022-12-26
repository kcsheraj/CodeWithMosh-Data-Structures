package Arrays;

import java.util.Iterator;
//if inner array was a list<E> then you could 
//add <E extends Comparable<E>  and make a sort
public class MyArrayList<E> implements Iterable<E>{
    private E[] innerArray;//
    private int currIndex = 0;
    public MyArrayList(int size){
        innerArray = (E[])(new Object[size]);//could throw a ClassCastException
    }
    public void insert(E object){
        innerArray[currIndex] = object;
        currIndex++;
        if(currIndex>innerArray.length-1){
            expand();
        }
    }
    public E removeAt(int index){//im not reduceing array size tho - (load factor)
        E temp = innerArray[index];
        innerArray[index] = null;
        if(index<innerArray.length){
            for(int i=index; i<innerArray.length-1; i++){
            innerArray[i] = innerArray[i+1];
            }
            innerArray[innerArray.length-1] = null;
        }

        currIndex--;
        return temp;
    }
    public int IndexOf(E object){
        for(int i=0; i<innerArray.length; i++){
            if(innerArray[i].equals(object)) return i;
        }
        return -1;
    }

    private void expand(){//expands by 3
        E[] expanded =(E[])(new Object[innerArray.length + 3]);
        for(int i=0; i<innerArray.length; i++){
            expanded[i] = innerArray[i];
        }

        this.innerArray = expanded;
    }

    public String toString(){
        String ans = "";
        ans+="{";
        for(int i=0; i<innerArray.length; i++){
            ans+= innerArray[i];
            if(i!=innerArray.length-1){
                ans+=", ";
            }
        }
        ans+="}";
        return ans;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<E>{
            int index = 0;
        @Override
        public boolean hasNext() {
            if(index < innerArray.length-1) return true;
            else return false;
        }

        @Override
        public E next() {
            E temp = innerArray[index];
            index++;
            return temp;
        }
        
    }


    public static void main(String[] args) {
         MyArrayList<Integer> theList= new MyArrayList<>(3);
         theList.insert(1);
         theList.insert(2);
         theList.insert(3);
         theList.insert(0);
        System.out.println(theList);

         theList.removeAt(1);
        System.out.println(theList);

         System.out.println(theList.IndexOf(0));
        
        System.out.println(theList);
       //theList.sort();//sort is a array method its not from comparable you would just have to make your own
       System.out.println("");
         for(Integer x: theList){
             System.out.println(x);
         }

         theList.insert(1);
         theList.insert(2);
         theList.insert(3);
         theList.insert(0);

         System.out.println(theList);

    }

}