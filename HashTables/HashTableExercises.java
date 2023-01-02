package HashTables;

import java.util.HashMap;
import java.util.Map;

public class HashTableExercises {

    //uses indexOf: time complexity of indexOf is o(n)
    private static char firstNonRepeatedCharacterIndexOf(String str) {
        char ans = ' ';
        for(int i=0; i<str.length()-1; i++){
            if(str.indexOf(str.charAt(i), i+1) == -1){
                ans = str.charAt(i);
                break;
            }
        }

        return ans;
    }
    //uses HashMap
    private static char firstNonRepeatedCharacter(String str) {
        char ans = Character.MIN_VALUE;
        Map<Character,Integer> myMap = new HashMap<>();
        for(int i=0; i<str.length(); i++){
            char currChar = str.charAt(i);
            if(myMap.containsKey(currChar)){//increment occurances
                myMap.put(currChar, myMap.get(currChar)+1);
            }
            else{//if not put into map
                myMap.put(currChar, 1);
            }
        }
        for(int i=0; i<str.length(); i++){
            char currChar = str.charAt(i);
            if(myMap.get(currChar) == 1){
                ans = currChar;
                break;
            }
        }

        return ans;
    }

    private static char firstRepeatedCharacter(String str) {
        Map<Character,Character> myMap= new HashMap<>();
        for(int i=0; i<str.length(); i++){
            char theChar = str.charAt(i);
            if(myMap.containsKey(theChar)){
                return theChar;
            }
            else{
                myMap.put(theChar, theChar);
            }
        }

        return Character.MIN_VALUE;
    }


    public static void main(String[] args) {
        //find the first non Repeated Character
        System.out.println(firstNonRepeatedCharacterIndexOf("A Green Apple"));
        System.out.println(firstNonRepeatedCharacter("A Green Apple"));

        //find the first repeated Character
        System.out.println(firstRepeatedCharacter("A Green Apple"));


    }
}
