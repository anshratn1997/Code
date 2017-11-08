import java.io.*;
import java.util.*;

//public 
class Solution {

    private static BufferedReader reader;
    private static StringTokenizer st;
    private static int n;

    private static final int INF = (int)(2e5 + 1);

    private static int[][] dividers;
    private static int[] cntDividers, cnt;
    private static List< List<Integer> > graph;
    private static int[] value, ans;

    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        ans = new int[n];
        value = new int[n];
        dividers = new int[INF][];
        cntDividers = new int[INF];
        cnt = new int[INF];
        graph = new ArrayList<>(n);

        for (int i = 0; i < n; ++i) {
            graph.add(new LinkedList<>());
        }

        /* fill dividers */
        for (int i = 1; i < INF; ++i) {
            for (int j = i; j < INF; j += i) {
                cntDividers[j]++;
            }
        }

        for (int i = 1; i < INF; ++i) {
            dividers[i] = new int[cntDividers[i]];
        }

        Arrays.fill(cntDividers, 0);
        for (int i = 1; i < INF; ++i) {
            for (int j = i; j < INF; j += i) {
                dividers[j][cntDividers[j]++] = i;
            }
        }

        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; ++i) {
            value[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n - 1; ++i) {
            st = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        reader.close();

        Arrays.fill(cnt, 0);
        dfs(0, -1, 1, -1);

        for (int i = 0; i < n; ++i)
            System.out.print(ans[i] + " ");
    }

    private static void dfs(int v, int p, int lvl, int g) {
        ans[v] = -1;

        for (int i = 0; i < cntDividers[value[v]]; ++i) {
            cnt[dividers[value[v]][i]]++;

            if (cnt[dividers[value[v]][i]] >= lvl - 1)
                ans[v] = Math.max(ans[v], dividers[value[v]][i]);
        }

        if (p != -1)
            ans[v] = Math.max(ans[v], g);

        for (Integer u: graph.get(v)) {
            if (u == p)
                continue;

            dfs(u, v, lvl + 1, (p == -1) ? value[v] : gcd(g, value[v]));
        }

        for (int i = 0; i < cntDividers[value[v]]; ++i)
            cnt[dividers[value[v]][i]]--;
    }

    private static int gcd(int a, int b) {
        if (b == 0)
            return a;

        return gcd(b, a%b);
    }
}