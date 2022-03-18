package wust;

import java.util.Scanner;

public class duoduoji_pipixia {
    public static void sort(int[][] b,int k)
    {
        for(int i=0;i<b.length;i++)
        {
            for(int j=i+1;j<b.length;j++)
            {
                if(b[j][k]>b[i][k])
                {
                    int temp=b[i][0];
                    b[i][0]=b[j][0];
                    b[j][0]=temp;
                    temp=b[i][1];
                    b[i][1]=b[j][1];
                    b[j][1]=temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[][] a=new int[m][2];
        int[][] b=new int[n][2];
        for(int i=0;i<m;i++)
        {
            a[i][0]=sc.nextInt();
            a[i][1]=sc.nextInt();
        }
        for(int i=0;i<n;i++)
        {
            b[i][0]=sc.nextInt();
            b[i][1]=sc.nextInt();
        }
        sort(a,0);
        sort(b,1);
        for(int i=0;i<Math.min(m,n);i++)
        {
            if(a[i][0]<b[i][1])
            {
                System.out.println(-1);
                return ;
            }
        }
        int res=0;
        for(int i=0;i<Math.min(m,n);i++)
        {
            if(a[i][1]>b[i][0]) {
                int min = a[i][1];
                int minindex = i;
                for (int j = i + 1; j < Math.min(m, n); j++) {
                    if (a[j][0]>=b[i][1])
                    {
                        if(a[j][1]>b[i][0])
                        {
                            if(min>a[j][1])
                            {
                                min=a[j][1];
                                minindex=j;
                            }
                        }
                    }
                    else
                    {
                        break;
                    }
                }
                int temp=b[i][0];
                b[i][0]=b[minindex][0];
                b[minindex][0]=temp;
                temp=b[i][1];
                b[i][1]=b[minindex][1];
                b[minindex][1]=temp;
                if(a[i][1]>b[i][0])
                {
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
