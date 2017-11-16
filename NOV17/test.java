import java.util.*;
import java.io.*;
class PrintAllKLengthStrings {
 
    // Driver method to test below methods
    static ArrayList<String> al=new ArrayList<>();

    static boolean ans=false;
    static int min=100;
    static int location=-1;
    public static void main(String[] args) {             
        System.out.println("First Test");
        char set1[] = {'a', 'b'};
        int k = 21;
        printAllKLength(set1, k);
        for (int i=0;i<al.size() ;i++ ) {
         fuck(al.get(i),0);


        }
            
    }    
 
    static void printAllKLength(char set[], int k) {
        int n = set.length;        
        printAllKLengthRec(set, "", n, k);
    }
 
    // The main recursive method to print all possible strings of length k
    static void printAllKLengthRec(char set[], String prefix, int n, int k) {
         
        // Base case: k is 0, print prefix
        if (k == 0) {
            al.add(prefix);

            // Next character of input added
            String newPrefix = prefix + set[i]; 
             
            // k is decreased, because we have added a new character
            printAllKLengthRec(set, newPrefix, n, k - 1); 
        }
    }
    static void fuck(String s,int loc){
        int max=0;
        for (int i=2;i<s.length()-1;i++ ) {
            int count=0;
             if(s.charAt(i-1)==s.charAt(i)){
               count=2;
               int l=i-2,m=i+1;
               for (;l>=0  && m<s.length();l--,m++ ) {
                   if(s.charAt(l)==s.charAt(m))
                    count+=2;
                  else
                    break;
               }
           }
             max=Math.max(count,max);
                count=0;
             if(s.charAt(i-1)==s.charAt(i+1)){
               count=3;
               int l=i-2,m=i+2;
               for (;l>=0  && m<s.length();l--,m++ ) {
                   if(s.charAt(l)==s.charAt(m))
                    count+=2;
                  else
                    break;
               }
                max=Math.max(count,max);

               
             }
             max=Math.max(count,max);

        }
        if(max==4){
            System.out.println(s);
            ans=true;
        }

    }
}