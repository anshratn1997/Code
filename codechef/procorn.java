import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main
{

    static char[] op = null;
    static int[] ap = null;
    static long MatrixChainOrder( int n)
    {
        
        long m[][] = new long[n+1][n+1];
 
        int i, j, k, L;
        long q;
 
        
        for (i = 1; i <= n; i++)
            m[i][i] = ap[i-1];
 
        
        for (L=2; L<=n ; L++)
        {
            for (i=1; i<=n-L+1; i++)
            {
                j = i+L-1;
                if(j == n+1) continue;
                m[i][j] = Long.MIN_VALUE;
                for (k=i; k<=j-1; k++)
                {
                  
                    if(op[k-1] == '-')
                    q = m[i][k] - m[k+1][j];
                    else
                    q = m[i][k] + m[k+1][j];
                    if (q > m[i][j])
                        m[i][j] = q;
                }
            }
        }

        for(i=1;i<=n;i++){
          for( j=1;j<=n;j++)
            System.out.print(m[i][j]+" ");
          System.out.println();
        }
 
        return m[1][n];
    }
 
    // Driver program to test above function
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
          int n = Integer.parseInt(br.readLine());
          String[] ao = br.readLine().split(" ");
          ap = new int[n];
          op = new char[n];
          for(int i = 0; i < ao.length ; i++){

             if( i % 2 == 0){
               ap[i/2] = Integer.parseInt(ao[i]);
             }
             else{
               op[i/2] = ao[i].charAt(0);
             }
          
          }
          // for(int i=0;i<n;i++){
          //   System.out.println(ap[i]+" "+op[i]);
          // }
          System.out.println(MatrixChainOrder(n));
          t--;
        }
    }
}
/* This code is contributed by Rajat Mishra*/