import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    private BufferedReader br;
    private PrintWriter out;

    Main(){
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.out = new PrintWriter(System.out);

    }

    public static void main(String[] args) {
        try {
            new Main().solve();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void solve() throws IOException {
        int  t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            String line_numbers[] = br.readLine().split(" ");
            int arr[] = new int[4];
            arr[0] = Integer.parseInt(line_numbers[0]);
            arr[1] = Integer.parseInt(line_numbers[1]);
            arr[2] = Integer.parseInt(line_numbers[2]);
            arr[3] = Integer.parseInt(line_numbers[3]);
            int min = Math.min(arr[0], Math.min(arr[1], arr[2]));
            if(min == 0) {
                int odd = get_number_of_odd(arr);
                if (odd > 1) {
                    out.println("NO");
                } else {
                    out.println("YES");
                }
            } else {
                int odd = get_number_of_odd(arr);
                if (odd > 1) {
                    odd = 4 - odd;
                    if (arr[3] % 2 != 0 ) odd--;
                    if (odd > 1) {
                        out.println("NO");
                    } else {
                        out.println("YES");
                    }
                } else {
                    out.println("YES");
                }

            }
        }
        out.flush();
        out.close();

    }
    private int get_number_of_odd(int arr[]) {
        int odd = 0;
        for ( int i = 0 ; i < 4; i++) {
            if (arr[i] % 2 != 0) odd++;
        }
        return odd;
    }

}
