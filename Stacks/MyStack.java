package Stacks;

import java.util.Iterator;

public class MyStack implements Iterable{

    int[] stack;
    int size;
    int topIndex;
    int curMinValueIndex;
    int prevMinValueIndex;

    public MyStack(){
        size = 10;
        stack = new int[10];
        int topIndex = 0;
        curMinValueIndex = 0;
        prevMinValueIndex = 0;
    }

    public void push(int x){
        if(topIndex>=size){
            expand();
        }
        stack[topIndex] = x;
        if(x<stack[curMinValueIndex]){
            prevMinValueIndex = curMinValueIndex;
            curMinValueIndex = topIndex;
        }
        topIndex++;
    }
    
    public void expand(){//expands by 10
        int[] larger = new int[size+10];
        //copy orgi to larger
        for(int i=0; i<size; i++){
            larger[i] = stack[i];
        }
        stack = larger;
        size = stack.length;
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("stack is empty");
            throw new IllegalStateException();
        }
        int poped = stack[topIndex-1];
        if(poped==stack[curMinValueIndex]){
            curMinValueIndex = prevMinValueIndex;
        }
        stack[topIndex-1] = 0;
        topIndex--;
        return poped;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("stack is empty");
            throw new IllegalStateException();
        }
        return stack[topIndex-1];
    }

    public boolean isEmpty(){
        if(topIndex==0) return true;
        return false;
    }

    @Override
    public Iterator iterator() {

        return new MyStackIterator();
    }

    class MyStackIterator implements Iterator{
        private int index = 0;
        @Override
        public boolean hasNext() {
            if(index<topIndex) return true;
            return false;
        }

        @Override
        public Object next() {
            int next = stack[index];
            index++;
            return next;
        }

    }
    public String toString(){
        String stackString = "[";

        for(int i=topIndex-1; i>=0; i--){
            if(i!=0){
            stackString += stack[i]+", ";
            }
            else{
                stackString += stack[i];
            }
        }

        stackString+= "]";

        return stackString;
    }
    private int min() {
        if(isEmpty()){
            throw new IllegalStateException();
        }
        return stack[curMinValueIndex];
    }


    public static void main(String[] args) {
        //this is a stack class that stores ints and is also Iterable
        MyStack stackA = new MyStack();
        stackA.push(1);
        stackA.push(2);
        stackA.push(3);
        stackA.push(4);
        for(Object x: stackA){
            System.out.println(x);
        }
        System.out.println(stackA);
        // System.out.println(stackA.peek());
        // System.out.println(stackA.pop());
        // System.out.println(stackA.peek());
        // System.out.println(stackA.peek());
        // System.out.println(stackA.peek());

        //Design a stack that supports push, pop and retrieving the minimum value in constant time. 
        MyStack stackB = new MyStack();
        stackB.push(5);
        stackB.push(2);
        stackB.push(10);
        stackB.push(1);
        stackB.push(1);
        stackB.push(0);
        stackB.pop();
        System.out.println(stackB.min());
        // System.out.println(stackB.pop());
        // System.out.println(stackB.min());
    }
    
    
}
