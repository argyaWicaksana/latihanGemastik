package SihirLoki;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        byte N = sc.nextByte();
        sc.nextLine();
        String[] stuff = new String[N];

        for (int i = 0; i < stuff.length; i++) {
            stuff[i] = sc.next();
        }
        sc.nextLine();

        byte Q = sc.nextByte(); //kasus
        String[][] tmp = new String[Q][N];


        for (int i = 0; i < Q; i++) {
            int K = sc.nextInt(); //pertukaran
            int L = convert(sc.next()); // banyak mantra diterapkan
            sc.nextLine();
            int[][] num = new int[K][2]; //buat nyimpen a b
            String[] ParentTmp = stuff.clone();
            tmp[i] = stuff.clone();

            for (int j = 0; j < K; j++) {
                String pertukaran = sc.nextLine(); // a -> b

                String[] a = pertukaran.split(" -> ", 2);
                num[j][0] = Integer.parseInt(a[0]);
                num[j][1] = Integer.parseInt(a[1]);
            }

            for (int j = 0; j < L; j++) {
                for (int j2 = 0; j2 < K; j2++) {
                    tmp[i][num[j2][1]-1] = ParentTmp[num[j2][0]-1];
                }
                ParentTmp = tmp[i].clone();
            }
        }

        //keluaran
        for (String[] tmp1 : tmp) {
            for (String a : tmp1) {
                System.out.print(a+" ");
            }
            System.out.println();
        }

    }

    static int convert(String a){ //10eP+Q
        String[] b = a.split("e|\\+", 3);
        int[] c = new int[b.length];

        for (int i = 0; i < c.length; i++) {
            c[i] = Integer.parseInt(b[i]);
        }

        if(b.length>1){
            return ((int)Math.pow(c[0], c[1])) + c[2];
        }
        return c[0];
    }

}
