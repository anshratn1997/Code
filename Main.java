import java.io.*;
import java.util.*;
import java.math.*;


public class Main {

    private BufferedReader br;

    Main(){
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {
        try {
            new Main().solve();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void solve() throws IOException {
        int t = Integer.parseInt(br.readLine());
        while(t-->0) {
            int n = Integer.parseInt(br.readLine());
            String[] h_numbers = br.readLine().split(" ");
            String[] p_numbers = br.readLine().split(" ");
            int[] h = new int[n];
            int[] p = new int[n];
            for(int i = 0; i< n; i++) {
                h[i] = Integer.parseInt(h_numbers[i]);
                p[i] = Integer.parseInt(p_numbers[i]);
            }
            Stack<ArrayList> stack = new Stack<ArrayList>();

            ArrayList<Integer> first  = new ArrayList<Integer>();
            first.add(p[0]);
            stack.push(first);
            for (int i = 1; i < n; i++) {
                if(h[i] == h[i-1]) {
                    stack.peek().add(p[i]);
                } else {
                    ArrayList<Integer> temp  = new ArrayList<Integer>();
                    temp.add(p[i]);
                    stack.add(temp);
                }
            }
            long sum = 0;

            while (!stack.isEmpty()) {
                ArrayList<Integer> list = stack.pop();
                if (list.size() > 1) {
                    sum += getAwards(list);
                }else {
                    sum += list.get(0);
                }
            }
            System.out.println(sum);

        }
    }

    private long getAwards(ArrayList<Integer> list) {
        int n = list.size();
        long sum = 0;
        for (int i = n - 1 ; i >=0 ; i--) {
            int first_index = i + 2;
            int second_index = i + 3;
            int temp = list.get(i);
            if (first_index <= n - 1) {
                temp = temp + list.get(first_index);
            }
            if (second_index <= n - 1) {
                temp = Math.max(temp, list.get(i) + list.get(second_index));
            }
            list.set(i, temp);
        }
        sum += Math.max(list.get(0), list.get(1));
        return  sum;
    }
}

/*
1
10
1 1 1 1 1 1 3 1 1 3
24 23 1 2 20 30 15 16 12 1
*/