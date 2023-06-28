import java.io.*;
import java.util.*;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CandidateCode {

public static int getMaxNumber(int[][] array) {
	IntSummaryStatistics stats = Stream.of(array)
			 .flatMapToInt(IntStream::of)
			 .summaryStatistics();
	return stats.getMax();
}

    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n==1)
        {
            int n2 = sc.nextInt();
            System.out.println(n2);
        }
        int[][] a = new int[n][n];
        int[][] temp = new int[n][n];
        String s = sc.nextLine();
        for(int i = 0;i<n;i++)
        {
            s = sc.nextLine();

            String[] s2 = s.split("#");
            for(int j = 0;j<n;j++)
            {
                a[i][j] = Integer.parseInt(s2[j]);
            }
        }
        for(int i = 0;i < n;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(i==0)
                {
                    if(j==0)
                    {
                        List<Integer> l = new ArrayList<Integer>();
                        l.add(a[0][0]);
                        l.add(a[0][1]);
                        l.add(a[1][0]);
                        l.add(a[1][1]);
                        Collections.sort(l);
                        temp[0][0] = l.get(0);
                    }
                    if(j==n-1)
                    {
                        List<Integer> l = new ArrayList<Integer>();
                        l.add(a[0][j]);
                        l.add(a[0][j-1]);
                        l.add(a[1][j]);
                        l.add(a[1][j-1]);
                        Collections.sort(l);
                        temp[0][j] = l.get(0);
                    }
                    if(j>0 && j<n-1)
                    {
                        List<Integer> l = new ArrayList<Integer>();
                        l.add(a[i][j+1]);
                        l.add(a[i][j]);
                        l.add(a[i][j-1]);
                        l.add(a[i+1][j+1]);
                        l.add(a[i+1][j]);
                        l.add(a[i+1][j-1]);
                        Collections.sort(l);
                        temp[0][j] = l.get(0);   
                    }
                }
                if(i==n-1)
                {
                    if(j==0)
                    {
                        List<Integer> l = new ArrayList<Integer>();
                        l.add(a[i][0]);
                        l.add(a[i][1]);
                        l.add(a[i-1][0]);
                        l.add(a[i-1][1]);
                        Collections.sort(l);
                        temp[i][j] = l.get(0);
                    }
                    if(j==n-1)
                    {
                        List<Integer> l = new ArrayList<Integer>();
                        l.add(a[i][j]);
                        l.add(a[i][j-1]);
                        l.add(a[i-1][j]);
                        l.add(a[i-1][j-1]);
                        Collections.sort(l);
                        temp[i][j] = l.get(0);
                    }
                    if(j>0 && j<n-1)
                    {
                        List<Integer> l = new ArrayList<Integer>();
                        l.add(a[i][j+1]);
                        l.add(a[i][j]);
                        l.add(a[i][j-1]);
                        l.add(a[i-1][j+1]);
                        l.add(a[i-1][j]);
                        l.add(a[i-1][j-1]);
                        Collections.sort(l);
                        temp[i][j] = l.get(0);   
                    }
                }
                if(j == 0 && i != 0 && i != n-1)
                {
                    List<Integer> l = new ArrayList<Integer>();
                    l.add(a[i-1][j+1]);
                    l.add(a[i][j+1]);
                    l.add(a[i+1][j+1]);
                    l.add(a[i-1][j]);
                    l.add(a[i][j]);
                    l.add(a[i+1][j]);
                    Collections.sort(l);
                    temp[i][j] = l.get(0); 
                }
                if(j == n-1 && i != 0 && i != n-1)
                {
                    List<Integer> l = new ArrayList<Integer>();
                    l.add(a[i-1][j-1]);
                    l.add(a[i][j-1]);
                    l.add(a[i+1][j-1]);
                    l.add(a[i-1][j]);
                    l.add(a[i][j]);
                    l.add(a[i+1][j]);
                    Collections.sort(l);
                    temp[i][j] = l.get(0); 
                }
                if(i>0 && j>0 && j<n-1 && i<n-1)
                {
                    List<Integer> l = new ArrayList<Integer>();
                    l.add(a[i-1][j-1]);
                    l.add(a[i-1][j]);
                    l.add(a[i-1][j+1]);
                    l.add(a[i][j-1]);
                    l.add(a[i][j]);
                    l.add(a[i][j+1]);
                    l.add(a[i+1][j-1]);
                    l.add(a[i+1][j]);
                    l.add(a[i+1][j+1]);
                    Collections.sort(l);
                    temp[i][j] = l.get(0);
                }
            }
        }


        int max = getMaxNumber(temp);

        for(int i=0;i<n;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(temp[i][j] == max)
                {
                    int t = i+1;
                    int t1 = j+1;
                    System.out.println(t + "#" + t1);
                }
            }
        }
   }
}
