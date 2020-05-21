

import java.io.*;
import java.util.*;

class TestClass {

    static class Point {
        int xy[] = new int[3];
        Point next = null;
        public Point(int x, int y) {
            xy[0] = x;
            xy[1] = y;
        }
        
    }
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static String[] mv = { "D", "L", "R", "U"};
    static int n = 0, m = 0;
    static int arr[][] = null;
    static boolean[][] visit = null;
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out); 
        String nm[] = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        ArrayList<String> as = new ArrayList<>();
        arr = new int[n][m];
        visit = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            as.add(br.readLine());
            for (int j = 0; j < m; j++){
                if(as.get(i).charAt(j) == '.') {
                    arr[i][j] = 1;
                }else{
                    arr[i][j] = -1;
                }
            }
        }
        int q = Integer.parseInt(br.readLine());
        for (int i = 0 ;i < q; i++) {
            String[] xy = br.readLine().split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);
            int fx = Integer.parseInt(xy[2]);
            int fy = Integer.parseInt(xy[3]);
            // StringBuffer ans = dfs(x-1, y-1, fx-1, fy-1,"");
            // if (ans.length() < 1) {
            //     System.out.println("Impossible");
            // }else {
            //     System.out.println(ans.toString());
            // }
            visit = new boolean[n][m];
            out.println(bfs(x-1, y-1, fx-1, fy-1,""));
        }
        out.flush();
        out.close();
    }
    
    public static StringBuffer dfs(int x, int y, int fx, int fy, String ch){
        if (isdestination(x, y, fx, fy)) {
           return new StringBuffer(ch);
        }
        visit[x][y] = true;
        StringBuffer subans = new StringBuffer();
        boolean find  = false;
        for(int i = 0; i < 4; i++) {
            if (isvalid(x+dx[i], y+dy[i]) && arr[x+dx[i]][y+dy[i]] == 1 && !visit[x+dx[i]][y+dy[i]]) {
                StringBuffer temp = dfs(x+dx[i], y+dy[i], fx, fy, mv[i]);
                if (temp.length() > 0  && subans.length() < 1) {
                    subans = temp;
                    find = true;
                }else if (temp.length() > 0 && subans.length() > temp.length()){
                    subans = temp;
                }else if (temp.length() > 0 && subans.length() == temp.length() && temp.toString().compareTo(subans.toString()) < 0) {
                    subans = temp;
                }else {
                    continue;
                }
            }
        }
        visit[x][y] = false;
        if (find) {
            return new StringBuffer(ch).append(subans);    
        }
        return new StringBuffer();
    }
    public static boolean isvalid(int x, int y){
        if (x < n && x > -1 && y  > -1 && y < m) {
            return true;
        }
        return false;
    }
    public static boolean isdestination(int x, int y, int fx, int fy) {
        if (x == fx && y == fy) {
            return true;
        }
        return false;
    }
    public static String bfs(int x, int y, int fx, int fy, String ch) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visit[x][y] = true;
        String ans = null;
        while(!q.isEmpty()) {
            Point src = (Point)q.poll();
            // System.out.println("Printing Move points");
            // System.out.println((src.xy[0])+" "+(src.xy[1]));
            if (isdestination(src.xy[0], src.xy[1], fx, fy)) {
                String path = findPathString(src);
                if (ans == null) {
                    ans = path;
                }else if(ans.length() > path.length()){
                    ans = path;
                }else if(path.compareTo(ans) < 0){
                    ans = path;
                }
                continue;
            }
            for(int i = 0; i < 4; i++) {
                 int xx = src.xy[0];
                 int yy = src.xy[1];
                if (isvalid(xx+dx[i], yy+dy[i]) && arr[xx+dx[i]][yy+dy[i]] == 1 && !visit[xx+dx[i]][yy+dy[i]]) {
                    // System.out.println("Printing Move points");
                    // System.out.println((x+dx[i])+" "+(y+dy[i]));
                    visit[xx+dx[i]][yy+dy[i]] = true;
                    Point child = new Point(xx + dx[i], yy + dy[i]);
                    child.xy[2] =i;
                    child.next = src;
                    q.add(child);
                }
            }
        }
        if (ans == null) {
            return "Impossible";
        }
        return ans;
    }
    public static String findPathString(Point point) {
        StringBuffer sb = new StringBuffer();
        Point curr = point;
        // System.out.println("Destination");
        // System.out.println(point.xy[0]+" "+ point.xy[1] +" "+point.xy[2]);
        while (curr.next != null){
            sb.append(mv[curr.xy[2]]);
            curr = curr.next;
        }
        // System.out.println(sb.reverse().toString());
        // System.out.println();
        return sb.reverse().toString();      
    }

}
/*
Test Cases
5 5
.....
..#..
.....
#.##.
.#...
5
1 3 3 3
1 1 5 5
5 5 4 2
1 1 6 6
5 1 5 3
LDDR
DDRRRRDD
UULLLD
Impossible
Impossible
*/