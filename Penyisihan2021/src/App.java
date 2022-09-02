import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = {1,2,3,4};
        int[] b = a;
        b[0] = a[1];

        for (int i : b) {
            System.out.print(i+" ");
        }
        System.out.println();

        for (int i : a) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
