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

    public static int mostFrequentInt(int[] arr){
        Map<Integer,Integer> myMap = new HashMap<>();
        for(int x: arr){
           if(myMap.containsKey(x)){
            myMap.put(x, myMap.remove(x)+1);
           }
           else{
            myMap.put(x, 1);
           }
        }
        int higestFrequency = 0;
        int mostFrequentInt = 0;
        for(Map.Entry<Integer,Integer> x: myMap.entrySet()){
            if(x.getValue()>higestFrequency){
                higestFrequency = x.getValue();
                mostFrequentInt = x.getKey();
            }
        }
        return mostFrequentInt;
    }
    
    public static int countPairsWithDiff(int[] arr,int k){
        HashMap<Integer,Integer> myMap = new HashMap<>();
        for(int x: arr){//put all non-duplicates into map
            if(!myMap.containsKey(x)){
             myMap.put(x, x);
            }
        }
        int pairsWithDiff = 0;
        for(Map.Entry<Integer,Integer> x: myMap.entrySet()){
            int valueWant = x.getKey() + k;
            if(myMap.containsKey(valueWant)){
                pairsWithDiff++;
            }
        }
        return pairsWithDiff;
    }

    public static void twoSum(int[] x, int target){
        HashMap<Integer,Integer> myMap = new HashMap<>();
        //put values with index in map
        for(int i=0; i<x.length; i++){
            myMap.put(x[i], i);
        }

        for(int num: x){
            int numWant = target-num;
            if(myMap.containsKey(numWant)){
                if(myMap.get(numWant)!=myMap.get(num)){
                System.out.print(myMap.get(num) + " ");
                System.out.println(myMap.get(numWant));
                break;
                }
            }
        }

    }


    public static void main(String[] args) {
        //find the first non Repeated Character
        System.out.println(firstNonRepeatedCharacterIndexOf("A Green Apple"));
        System.out.println(firstNonRepeatedCharacter("A Green Apple"));

        //find the first repeated Character
        System.out.println(firstRepeatedCharacter("A Green Apple"));

        //Find the most repeated element in an array of integers
        int[] x = {1, 2, 2, 3, 3, 3, 4};
        System.out.println(mostFrequentInt(x));

        // Given an array of integers,
        //count the number of unique pairs of integers that have difference k
        int[] y = {1, 7,9, 5, 9,7, 2, 12, 3};
        System.out.println(countPairsWithDiff(y,2));

        //Given an array of integers, return indices of the two numbers s
        //such that they add up to a specific target.

        int[] z = {2, 7, 11, 15};
        twoSum(z,9);



    }
}
