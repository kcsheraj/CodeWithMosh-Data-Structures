package Stacks;

import java.util.Stack;

import javafx.scene.media.SubtitleTrack;

public class StackExercise {
    private static String reverseString(String word) {
        Stack<Character> myStack= new Stack<>();
        for(int i=0; i<word.length(); i++){
            myStack.push(word.charAt(i));
        }
        //use string buffer to save memory space
        StringBuffer reversed = new StringBuffer();
        while(!myStack.isEmpty()){
            reversed.append(myStack.pop());
        }
        return reversed.toString();
    }
    private static boolean balanceExpression(String expression) {
        Stack<Character> expCharacters= new Stack<>();
        for(int i=0; i<expression.length(); i++){
            Character theChar = expression.charAt(i);
            if(isOpenChar(theChar)||isCloseingChar(theChar)){//char is an expresion

                if(isOpenChar(theChar)){
                    expCharacters.push(theChar);
                }
                else{//if closing
                    //make shure it is right opening
                    if(!expCharacters.isEmpty()){
                    char correctOpening = getCorrectOpening(theChar);//send in closing
                    if(expCharacters.pop()!=correctOpening) return false;
                    }
                }
           }
        }
        if(!expCharacters.isEmpty()) return false;
        return true;
    }
    private static char getCorrectOpening(Character theChar) {
        if(theChar=='>') return '<';
        if(theChar==')') return '(';
        if(theChar=='}') return '{';
        if(theChar==']') return '[';
        return '0';
    }
    private static boolean isOpenChar(char c) {
        if(c=='<'||c=='('||c=='['||c=='{'){
            return true;
        }
        return false;
    }
    private static boolean isCloseingChar(char c) {
        if(c=='>'||c==')'||c==']'||c=='}'){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        //reverse word
        String word = "ABCDEFG";
        word = reverseString(word);
        System.out.println(word);

        //balanced expressions
        String expression = "()(])";
        System.out.println(balanceExpression(expression));


        
    }
}
