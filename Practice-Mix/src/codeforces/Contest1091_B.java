package codeforces;

import java.util.*;

public class Contest1091_B {
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();

        int t=sc.nextInt();

        while(t-->0){
            int n = sc.nextInt();
            int k = sc.nextInt(); // always 1
            int[] a = new int[n];

            for(int i=0;i<n;i++) a[i]=sc.nextInt();

            int p = sc.nextInt()-1;
            int x = a[p];
            int cnt=0;

            for(int i=0;i<n;i++) if(a[i]!=x) cnt++;

            if(cnt==0) sb.append(0).append('\n');
            else if(cnt%2==0) sb.append(cnt).append('\n');
            else sb.append(cnt+1).append('\n');
        }
        System.out.print(sb.toString());
    }
}
