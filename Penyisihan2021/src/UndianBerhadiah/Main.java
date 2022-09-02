package UndianBerhadiah;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        int[] peserta = new int[N];
        peserta[0] = sc.nextInt();
        int min[] = new int[2];
        int pemenang[] = new int[2];
        min[0] = selisih(peserta[0], X);
        pemenang[0] = peserta[0];

        for (int i = 1; i < peserta.length; i++) {
            peserta[i] = sc.nextInt();
            int tmp = selisih(peserta[i], X);
            if(min[0] > tmp) {
                min[0] = tmp;
                pemenang[0] = peserta[i];
            } else if(min[0] == tmp) {
                min[1] = tmp;
                pemenang[1] = peserta[i];
            }
        }

        System.out.println();

        if (selisih(min[0], X) == selisih(min[1], X)) {
            if (pemenang[0] < pemenang[1]) {
                System.out.println(pemenang[0]);
                System.out.println(pemenang[1]);
            } else{
                System.out.println(pemenang[1]);
                System.out.println(pemenang[0]);
            }
        } else System.out.println(pemenang[0]);
    }

    static int selisih(int a, int b){
        return a-b<0 ? -(a-b) : a-b;
    }
}
