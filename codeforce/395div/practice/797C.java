import java.util.*;
import java.io.*;
class TrieNode 
{
    char content; 
    boolean isEnd; 
    int count;  
    LinkedList<TrieNode> childList; 
 
    
    public TrieNode(char c)
    {
        childList = new LinkedList<TrieNode>();
        isEnd = false;
        content = c;
       
    }  
    public TrieNode subNode(char c)
    {
        if (childList != null)
            for (TrieNode eachChild : childList)
                if (eachChild.content == c)
                    return eachChild;
        return null;
    }
}
 
class Trie
{
    private TrieNode root;
 
     /* Constructor */
    public Trie()
    {
        root = new TrieNode(' '); 
    }
     /* Function to insert word */
    public void insert(String word)
    {
        if (search(word) == true) 
            return;        
        TrieNode current = root; 
        for (char ch : word.toCharArray() )
        {
            TrieNode child = current.subNode(ch);
            if (child != null)
                current = child;
            else 
            {
                 current.childList.add(new TrieNode(ch));
                 current = current.subNode(ch);
            }
            
        }
        current.isEnd = true;
    }
    /* Function to search for word */
    public boolean search(String word)
    {
        TrieNode current = root;  
        for (char ch : word.toCharArray() )
        {
            if (current.subNode(ch) == null)
                return false;
            else
                current = current.subNode(ch);
        }      
        if (current.isEnd == true) 
            return true;
        return false;
    }
    public int mathfilter(String word)
    {
        TrieNode current=root;
        int count=0;
        for(char ch:word.toCharArray())
        {
            if(current.subNode(ch)==null)
                return count;
            else
            {
                 current=current.subNode(ch);
                 count++;
            }
            
        }
        if(count==word.length())
            return -1;
        return count;
    }
 } 
 class test{
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
         
        public FastReader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
  
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                  e.printStackTrace();
                }
            }
            return st.nextToken();
        }

       
 
        long ilong()
        {
            return Long.parseLong(next());
        }
 
        double idouble()
        {
            return Double.parseDouble(next());
        }
 
        String readline()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }

    
          
        int iint()
        {
            return Integer.parseInt(next());
        }
    }
    public static void main(String arga[])
    {
        FastReader s=new FastReader();
       
        
        int n=s.iint();
        Trie t=new Trie();
        ArrayList<String> blocked=new ArrayList<>();
        boolean ans=true;
        TreeSet<String> filterset=new TreeSet<>();
        
        for (int i=0;i<n;i++ ) {
            String choice=s.next();
            if(choice.charAt(0)=='+')
                t.insert(s.next());
            else
                blocked.add(s.next());

        }

        for (String sp:blocked){

            //System.out.println(sp);
            int temp=t.mathfilter(sp);
            if(temp>=0)
              filterset.add(sp.substring(0,temp+1));
            else
            {
                ans=false;
                break;
            }

        }
        if(ans==false)
        {
            //System.out.println("ok");
            System.out.println("-1");
                
         }
         else
         {
            if(filterset.isEmpty())
                System.out.println("-1");
            else
            {
                System.out.println(filterset.size());
                for ( String sp: filterset ) {
                 System.out.println(sp);   
                }
            }
         }

    }  
  }
