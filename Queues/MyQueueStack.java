package Queues;

import java.util.Stack;

public class MyQueueStack {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueueStack(){
        s1 = new Stack<>();
        s2 = new Stack<>();
    }


    public void enqueue(int x){
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        s1.push(x);
    }

    public int dequeue(){
        if(s1.isEmpty() && s2.isEmpty()) throw new IllegalStateException();
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
       return s2.pop();
    }
    
    public int peek(){
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        int ans = s2.peek();

        return ans;
    }

    public String toString(){
        String ans = "";
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        while(!s2.isEmpty()){
            int next = s2.pop();
            System.out.print(next +" ");
            s1.push(next);
        }

        return ans;
    }


    public static void main(String[] args) {
        MyQueueStack queue1 = new MyQueueStack();
        //queue datastructure using 2 stacks: s1 for enquenue/ s2 for dequeue

        queue1.enqueue(30);
        queue1.enqueue(40);
        queue1.enqueue(50);
        queue1.dequeue();
        queue1.dequeue();
        queue1.dequeue();
        queue1.enqueue(50);
        queue1.enqueue(50);
        queue1.enqueue(50);
        queue1.enqueue(200);
        System.out.println(queue1.peek());

        


        System.out.println(queue1);
    }
}
