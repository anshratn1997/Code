import java.util.*;
import java.math.*;
import java.io.*;
//public 
class Main
{
 
    static int max=1000001;
    static int[] lpfr=new int[max];
    static boolean prime[]=new boolean[max];
    static Object[] tree=new Object[max];      
    void PRIME(){
    Arrays.fill(prime,true);
    lpfr[0]=1;
    lpfr[1]=1;
    for (int p=2; p<max; p++)
    {
        if (prime[p] == true)
        {
           lpfr[p]=p;
            for (int i=p*2; i<max; i += p){
                if(prime[i]!=false){
                   lpfr[i]=p;}
                   prime[i] = false;}
 
        }
     }
   }
         
  void buid_tree(int nd,int a,int b,int[] arr){
              if(a>b)
                return;
            if(a==b)
            {
               tree[nd]=generate(arr[a]);
               return;
            }
            buid_tree(nd*2,a,(a+b)/2,arr);
            buid_tree(nd*2+1,1+(a+b)/2,b,arr);
            HashMap<Integer,Integer> map3=(HashMap)tree[nd*2];
            HashMap<Integer,Integer> map4=(HashMap)tree[nd*2+1];
            if(map3.isEmpty())
               tree[nd]=map4;
             else if(map4.isEmpty())
              tree[nd]=map3;
            else
            tree[nd]=addmap(map3,map4);
 
        }
        HashMap<Integer,Integer> get(int nd,int a,int b,int l,int r)
        {
            if(a>b || a>r || b<l)
                return new HashMap<>();
             HashMap<Integer,Integer> map1=(HashMap)tree[nd]; 
            if(map1.isEmpty())
               return map1;
            if(a>=l && b<=r)
            {
                HashMap<Integer,Integer> map=(HashMap)tree[nd];
                    return map;
            } 
            HashMap<Integer,Integer> q1=get(nd*2,a,(a+b)/2,l,r);
            HashMap<Integer,Integer> q2=get(nd*2+1,1+(a+b)/2,b,l,r);
            if(q1.isEmpty())
              return q2;
            else if(q2.isEmpty())
              return q1;
            else
            return addmap(q1,q2);
        }
 
    
    HashMap<Integer,Integer> generate(int n)
        {
            int curr=lpfr[n];
            int cnt=1;
            ArrayList<Pair<Integer,Integer> > map=new ArrayList<>();
          
            while(n>1){
                n=n/lpfr[n];
                if(curr==lpfr[n]){
                    cnt++;
                    continue;
                }
                Pair<Integer,Integer> pq=new Pair(curr,)
                map.put(curr,cnt);
                curr=lpfr[n];
                cnt=1;
                //System.out.println(curr);
            }
            return map;
        }
    HashMap<Integer,Integer> addmap(HashMap<Integer,Integer> map1,HashMap<Integer,Integer> map2){
    HashMap<Integer,Integer> map3=new HashMap<>();
    Set<Integer> keys=new HashSet<>(map1.keySet());
        keys.addAll(map2.keySet());
        for ( Integer a:keys ) {
            if(map1.containsKey(a) && map2.containsKey(a))
                map3.put(a,map1.get(a)+map2.get(a));
            else if(map1.containsKey(a))
                 map3.put(a,map1.get(a));
             else
                map3.put(a,map2.get(a));
        }
        return map3;
 
  }
 void solve()
 {
          PRIME();
          int n=inpi();
          int arr[]=new int[n];
          for (int i=0;i<n ;i++ ) {
              arr[i]=inpi();
          }
          buid_tree(1,0,n-1,arr);
 
          
          int q=inpi();
          for (int i=0;i<q ;i++ ) {
              int l=inpi(),r=inpi(),x=inpi(),y=inpi();
              HashMap<Integer,Integer> temp=get(1,0,n-1,l-1,r-1);
             Integer result=0;
              Set<Integer> keys=temp.keySet();
              for ( Integer a:keys ) {
                      if(x<=a && a<=y)
                          result+=temp.get(a);
              }
              out.println(result);
         }
      
 }
    InputStream obj;
    PrintWriter out;
    String check = "";
 
 public static void main(String[] args) throws IOException
    {   
       new Main().main1();                                
    }
    void main1() throws IOException {
        out = new PrintWriter(System.out);
        obj = check.isEmpty() ? System.in : new ByteArrayInputStream(check.getBytes());
        solve();
        out.flush();
        out.close();
    }
     byte inbuffer[] = new byte[1024];
    int lenbuffer = 0, ptrbuffer = 0;
 
    int readByte() {
        if (lenbuffer == -1) {
            throw new InputMismatchException();
        }
        if (ptrbuffer >= lenbuffer) {
            ptrbuffer = 0;
            try {
                lenbuffer = obj.read(inbuffer);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
        }
        if (lenbuffer <= 0) {
            return -1;
        }
        return inbuffer[ptrbuffer++];
    }
 
    boolean isSpaceChar(int c) {
        return (!(c >= 33 && c <= 126));
    }
 
    int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b));
        return b;
    }
 
    String inps() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!(isSpaceChar(b))) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }
 
    int inpi() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }
 
    long inpl() {
        long num = 0;
        int b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }
 
    float inpf() {
        return Float.parseFloat(inps());
    }
 
    double inpd() {
        return Double.parseDouble(inps());
    }
 
    char inpc() {
        return (char) skip();
    }
 
    int[] inpia(int n) {
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = inpi();
        }
        return a;
    }
 
    long[] inpla(int n) {
        long a[] = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = inpl();
        }
        return a;
    }
 
    String[] inpsa(int n) {
        String a[] = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = inps();
        }
        return a;
    }
 
    double[][] inpdm(int n, int m) {
        double a[][] = new double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = inpd();
            }
        }
        return a;
    }
 
    int[][] inpim(int n, int m) {
        int a[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = inpi();
            }
        }
        return a;
    }
} 


