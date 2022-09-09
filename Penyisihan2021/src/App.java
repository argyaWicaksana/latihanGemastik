import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int[] a = {1,2,3,4};
        // int[] b = a;
        // b[0] = a[1];

        // for (int i : b) {
        //     System.out.print(i+" ");
        // }
        // System.out.println();

        // for (int i : a) {
        //     System.out.print(i+" ");
        // }
        // System.out.println();

        int[] p = {1000, 210};
        int[] q = {1230, 2045};
        int num=0;

        for (int i = 0; i < 2; i++) {
            num+=Math.pow(p[i]-q[i], 2);
        }

        System.out.println(num);
        System.out.println("Result: "+(int)Math.sqrt(num));
    }
}
