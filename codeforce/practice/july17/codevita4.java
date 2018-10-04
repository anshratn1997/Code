import java.io.*;
import java.util.*;
import java.math.*;
//public 
class Main{
    static char move=' ';
    static boolean[][] cheers=new boolean[8][8];
    BufferedReader br;
    public static void main(String[] args) {
    new Main().main1();

 
  }
  void main1 ()
  {
    try{
     br=new BufferedReader(new InputStreamReader(System.in));
     String chess=si();
     Solve(chess);
     
  }
    catch(Exception e){
        e.printStackTrace();}
    
  }
  void Solve(String chess)
  {
    String[] ranks=chess.split(" ");
    move=ranks[1].charAt(0);
    String[] cordinate=ranks[0].split("/");
   //ok;
    StringBuffer ans=new StringBuffer("[");
    fillchess(cordinate);
     for (int i=1;i<=8;i++ ) {
            int pos=0;
            for (int k=0;k<cordinate[i-1].length() ;k++ ){
                 char ch=cordinate[i-1].charAt(k);
                 if(isdigit(ch)>0){
                  pos+=isdigit(ch);      
                 } 
                 else if(iscapital(ch)){
                     if(move=='w' && ch=='B')
                     {
                        int y=8-i+1,x=pos+1;
                        StringBuffer from=from_to(x,y);
                        //System.out.println(x+" "+y);
                        //
                        int m=0;
                        for (int l=1;l<=8 ;l++ ) {
                             if(l!=y && !cheers[8-l][m]){
                              ans.append(from.toString());
                              ans.append(from_to(m+1,8-l).toString());
                              ans.append(", ");
                              }
                              m++;
                        }
                        m=7;
                        for (int l=1;l<=8 ;l++ ) {
                             if(l!=y && !cheers[l-1][m]){
                              ans.append(from_to(m+1,l).toString());
                              ans.append(", ");
                              }
                              m--;
                        }
                     }

                 }       
          } 
       }
       System.out.println(ans);
  }
  int isdigit(char ch){
    int num=(int)ch;
    if(num>=48 && num<=57)
        return num-48;
    return -1;

  }
  boolean iscapital(char ch){
    int num=(int)ch;
    if(num>=65 && num<=90)
        return true;
    return false;

  }
  boolean islower(char ch){
    int num=(int)ch;
    if(num>=97 && num<=122)
        return true;
    return false;
  }
  void fillchess(String[] cordinate){
    //System.out.println(cordinate.length);
     for(int i=1;i<=8;i++)
      {
        int pos=0;
          //System.out.println(cordinate[i-1].length());
        for (int k=0;k<cordinate[i-1].length() ;k++ ) {
            char ch=cordinate[i-1].charAt(k);
            if(isdigit(ch)>0){
              for(int l=0;l<isdigit(ch);l++){
                   cheers[i-1][pos]=false;pos++;}
            
            }
            else
              {cheers[i-1][pos]=true;pos++;}
        }
      }
  }
  StringBuffer from_to(int x,int y){
    char ch=(char)(96+(int)x);
    StringBuffer res=new StringBuffer("");
    res.append(ch);
     
    res.append((char)(y+48));
    return res;

  }
  
   //input method
    int[] iint() throws IOException{
      String line[]=br.readLine().split(" ");
      int[] a=new int[line.length];
      for (int i=0;i<line.length ;i++ ) {
        a[i]=Integer.parseInt(line[i]);
      }
      return a;
    }
    long[] ilong() throws IOException{
      String line[]=br.readLine().split(" ");
      long[] a=new long[line.length];
      for (int i=0;i<line.length ;i++ ) {
        a[i]=Long.parseLong(line[i]);
      }
      return a;
    }
    double[] idouble() throws IOException{
      String line[]=br.readLine().split(" ");
      double[] a=new double[line.length];
      for (int i=0;i<line.length ;i++ ) {
        a[i]=Long.parseLong(line[i]);
      }
      return a;
    }
    long li() throws IOException{
      
      return Long.parseLong(br.readLine());
    }
    int ii() throws IOException{
      
      return Integer.parseInt(br.readLine());
    }
    double di() throws IOException{
      return Double.parseDouble(br.readLine());
    }
    char ci() throws IOException{
      return (char)br.read();
    }
    String si() throws IOException{
       return br.readLine();
    }
  
} 