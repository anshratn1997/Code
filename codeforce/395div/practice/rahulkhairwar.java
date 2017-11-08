import java.io.*;
import java.util.*;
 
class ChefAndCut
{
    public static void main(String[] args)
    {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
 
        Solver solver = new Solver(in, out);
        solver.solve();
 
        out.flush();
 
        in.close();
        out.close();
    }
 
    static class Solver
    {
        int n, m, k, s, t;
        List<Edge>[] adj;
        InputReader in;
        OutputWriter out;
 
        void solve()
        {
            n = in.nextInt();
            m = in.nextInt();
            k = in.nextInt();
            s = in.nextInt() - 1;
            t = in.nextInt() - 1;
            adj = new ArrayList[n];
 
            for (int i = 0; i < n; i++)
                adj[i] = new ArrayList<>();
 
            for (int i = 0; i < m; i++)
            {
                int from, to, weight;
 
                from = in.nextInt() - 1;
                to = in.nextInt() - 1;
                weight = in.nextInt();
 
                adj[from].add(new Edge(to, weight));
            }
 
            int limit = (1 << (n - 2));
            String z = "000000000000000";
            List<Long> cuts = new ArrayList<>();
            List<Integer> choose = new ArrayList<>();
 
            for (int i = 0; i < n; i++)
                if (i != s && i != t)
                    choose.add(i);
 
            for (int i = 0; i < limit; i++)
            {
                String binary = Integer.toBinaryString(i);
 
//                System.out.println("n - 2 - bin.len : " + (n - 2 - binary.length()) + ", bin : " + binary);
 
                cuts.add(cut(z.substring(0, n - 2 - binary.length()) + binary, choose));
            }
 
//            System.out.println("cuts : " + cuts);
 
            cuts.sort(new Comparator<Long>() {
                @Override
                public int compare(Long o1, Long o2) {
                    return Long.compare(o1, o2);
                }
            });
 
            out.println(cuts.get(k - 1));
        }
 
        long cut(String binary, List<Integer> choose)
        {
            Set<Integer> one, two;
            int len = binary.length();
 
            one = new HashSet<>();
            two = new HashSet<>();
            one.add(s);
            two.add(t);
 
//            System.out.println("binary : " + binary);
 
            for (int i = 0; i < len; i++)
            {
                if (binary.charAt(i) == '0')
                    one.add(choose.get(i));
                else
                    two.add(choose.get(i));
            }
 
            long total = 0;
 
            Iterator<Integer> iterator = one.iterator();
 
            while (iterator.hasNext())
            {
                int curr = iterator.next();
                Iterator<Edge> it = adj[curr].iterator();
 
                while (it.hasNext())
                {
                    Edge edge = it.next();
 
                    if (two.contains(edge.to))
                        total += edge.weight;
                }
            }
 
            return total;
        }
 
        class Edge
        {
            int to, weight;
 
            public Edge(int to, int weight)
            {
                this.to = to;
                this.weight = weight;
            }
 
        }
 
        public Solver(InputReader in, OutputWriter out)
        {
            this.in = in;
            this.out = out;
        }
 
    }
 
    static class InputReader
    {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
 
        public InputReader(InputStream stream)
        {
            this.stream = stream;
        }
 
        public int read()
        {
            if (numChars == -1)
                throw new InputMismatchException();
 
            if (curChar >= numChars)
            {
                curChar = 0;
                try
                {
                    numChars = stream.read(buf);
                } catch (IOException e)
                {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
 
            return buf[curChar++];
        }
 
        public int nextInt()
        {
            int c = read();
 
            while (isSpaceChar(c))
                c = read();
 
            int sgn = 1;
 
            if (c == '-')
            {
                sgn = -1;
                c = read();
            }
 
            int res = 0;
 
            do
            {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
 
                res *= 10;
                res += c & 15;
 
                c = read();
            } while (!isSpaceChar(c));
 
            return res * sgn;
        }
 
        public int[] nextIntArray(int arraySize)
        {
            int array[] = new int[arraySize];
 
            for (int i = 0; i < arraySize; i++)
                array[i] = nextInt();
 
            return array;
        }
 
        public long nextLong()
        {
            int c = read();
 
            while (isSpaceChar(c))
                c = read();
 
            int sign = 1;
 
            if (c == '-')
            {
                sign = -1;
 
                c = read();
            }
 
            long result = 0;
 
            do
            {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
 
                result *= 10;
                result += c & 15;
 
                c = read();
            } while (!isSpaceChar(c));
 
            return result * sign;
        }
 
        public long[] nextLongArray(int arraySize)
        {
            long array[] = new long[arraySize];
 
            for (int i = 0; i < arraySize; i++)
                array[i] = nextLong();
 
            return array;
        }
 
        public float nextFloat() // problematic
        {
            float result, div;
            byte c;
 
            result = 0;
            div = 1;
            c = (byte) read();
 
            while (c <= ' ')
                c = (byte) read();
 
            boolean isNegative = (c == '-');
 
            if (isNegative)
                c = (byte) read();
 
            do
            {
                result = result * 10 + c - '0';
            } while ((c = (byte) read()) >= '0' && c <= '9');
 
            if (c == '.')
                while ((c = (byte) read()) >= '0' && c <= '9')
                    result += (c - '0') / (div *= 10);
 
            if (isNegative)
                return -result;
 
            return result;
        }
 
        public double nextDouble() // not completely accurate
        {
            double ret = 0, div = 1;
            byte c = (byte) read();
 
            while (c <= ' ')
                c = (byte) read();
 
            boolean neg = (c == '-');
 
            if (neg)
                c = (byte) read();
 
            do
            {
                ret = ret * 10 + c - '0';
            } while ((c = (byte) read()) >= '0' && c <= '9');
 
            if (c == '.')
                while ((c = (byte) read()) >= '0' && c <= '9')
                    ret += (c - '0') / (div *= 10);
 
            if (neg)
                return -ret;
 
            return ret;
        }
 
        public String next()
        {
            int c = read();
 
            while (isSpaceChar(c))
                c = read();
 
            StringBuilder res = new StringBuilder();
 
            do
            {
                res.appendCodePoint(c);
 
                c = read();
            } while (!isSpaceChar(c));
 
            return res.toString();
        }
 
        public boolean isSpaceChar(int c)
        {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
 
        public String nextLine()
        {
            int c = read();
 
            StringBuilder result = new StringBuilder();
 
            do
            {
                result.appendCodePoint(c);
 
                c = read();
            } while (!isNewLine(c));
 
            return result.toString();
        }
 
        public boolean isNewLine(int c)
        {
            return c == '\n';
        }
 
        public void close()
        {
            try
            {
                stream.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
 
    }
 
    static class OutputWriter
    {
        private PrintWriter writer;
 
        public OutputWriter(OutputStream stream)
        {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
                    stream)));
        }
 
        public OutputWriter(Writer writer)
        {
            this.writer = new PrintWriter(writer);
        }
 
        public void println(int x)
        {
            writer.println(x);
        }
 
        public void print(int x)
        {
            writer.print(x);
        }
 
        public void println(char x)
        {
            writer.println(x);
        }
 
        public void print(char x)
        {
            writer.print(x);
        }
 
        public void println(int array[], int size)
        {
            for (int i = 0; i < size; i++)
                println(array[i]);
        }
 
        public void print(int array[], int size)
        {
            for (int i = 0; i < size; i++)
                print(array[i] + " ");
        }
 
        public void println(long x)
        {
            writer.println(x);
        }
 
        public void print(long x)
        {
            writer.print(x);
        }
 
        public void println(long array[], int size)
        {
            for (int i = 0; i < size; i++)
                println(array[i]);
        }
 
        public void print(long array[], int size)
        {
            for (int i = 0; i < size; i++)
                print(array[i]);
        }
 
        public void println(float num)
        {
            writer.println(num);
        }
 
        public void print(float num)
        {
            writer.print(num);
        }
 
        public void println(double num)
        {
            writer.println(num);
        }
 
        public void print(double num)
        {
            writer.print(num);
        }
 
        public void println(String s)
        {
            writer.println(s);
        }
 
        public void print(String s)
        {
            writer.print(s);
        }
 
        public void println()
        {
            writer.println();
        }
 
        public void printSpace()
        {
            writer.print(" ");
        }
 
        public void printf(String format, Object args)
        {
            writer.printf(format, args);
        }
 
        public void flush()
        {
            writer.flush();
        }
 
        public void close()
        {
            writer.close();
        }
 
    }
 
    static class CMath
    {
        static long gcd(long a, long b)
        {
            if (b == 0)
                return a;
 
            return gcd(b, a % b);
        }
 
        static long lcm(long... arr)
        {
            int len = arr.length;
            long lcm = arr[0];
 
            for (int i = 1; i < len; i++)
                lcm = (lcm * arr[i]) / gcd(lcm, arr[i]);
 
            return lcm;
        }
 
    }
 
}