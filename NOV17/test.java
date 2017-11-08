import java.util.*;
import java.io.*;
class PrintAllKLengthStrings {
 
    // Driver method to test below methods
    static ArrayList<String> al=new ArrayList<>();
    static int min=100;
    static int location=-1;
    public static void main(String[] args) {             
        System.out.println("First Test");
        char set1[] = {'a', 'b'};
        int k = 8;
        printAllKLength(set1, k);
        for (int i=0;i<al.size() ;i++ ) {
         System.out.println(al.get(i));
        }
       
            
    }    
 
    // The method that prints all possible strings of length k.  It is
    //  mainly a wrapper over recursive function printAllKLengthRec()
    static void printAllKLength(char set[], int k) {
        int n = set.length;        
        printAllKLengthRec(set, "", n, k);
    }
 
    // The main recursive method to print all possible strings of length k
    static void printAllKLengthRec(char set[], String prefix, int n, int k) {
         
        // Base case: k is 0, print prefix
        if (k == 0) {
            al.add(prefix);
            return;
        }
 
        // One by one add all characters from set and recursively 
        // call for k equals to k-1
        for (int i = 0; i < n; ++i) {
             
            // Next character of input added
            String newPrefix = prefix + set[i]; 
             
            // k is decreased, because we have added a new character
            printAllKLengthRec(set, newPrefix, n, k - 1); 
        }
    }
    static void fuck(String s,int loc){
       
        for (int i=3;i<s.length()-1;i++ ) {
            int count=0;
             if(s.charAt(i-1)==s.charAt(i+1)){
               count=3;
               int l=i-2,m=i+2;
               for (;l>=0  && m<s.length();l--,m++ ) {
                   if(s.charAt(l)==s.charAt(m))
                    count+=2;
                  else
                    break;
               }
              if(min>count){
                min=count;
                location=loc;
              }
             }
        }

    }
}