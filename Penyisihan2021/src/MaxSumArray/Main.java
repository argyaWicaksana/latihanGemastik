package MaxSumArray;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] a = new int[N];
        int[] MS = new int[N];
        int mx = 0;

        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }

        MS[N-1] = a[N-1];

        for (int i = N-2; i >=0; i--) {
            if(i+M >= N) MS[i] = a[i]>MS[i+1] ? a[i]:MS[i+1];
            else{
                mx = mx>MS[i+M] ? mx:MS[i+M];
                MS[i] = (a[i]+mx)>MS[i+1] ? (a[i]+mx):MS[i+1];
            }
        }

        System.out.println(MS[0]);

    }

}
