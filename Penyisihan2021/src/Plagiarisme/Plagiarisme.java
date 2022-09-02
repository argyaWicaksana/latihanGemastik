package Plagiarisme;
import java.util.Scanner;

public class Plagiarisme {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        // int n = sc.nextInt();
        // int m = sc.nextInt();
        // int[][] S = nestLoop(n, m);
        // int[][] T = nestLoop(n, m);

        int n =3;
        int m =4;
        if(!validation(n, m)){
            System.out.println("error");
            System.exit(1);
        }
        int[][] S = {{1,2,3,4}, {2,12,6,8}, {3,6,9,12}};
        int[][] T = {{4,3,2,1}, {5,6,3,2}, {6,5,4,3}};

        int max=0 ,p1=0, p2=0;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                // selisih(i, j); //selisih antar peserta
                for (int j2 = 0; j2 < m; j2++) {
                    int plagiarisme = selisih(T[i][j2], T[j][j2]) + selisih(S[i][j2], S[j][j2]);
                    if (max < plagiarisme) {
                        max = plagiarisme;
                        p1 = i;
                        p2 = j;
                    }
                }
            }
        }

        int selisih = selisih(p1, p2);
        System.out.println("max: "+max);
        System.out.println("selisih: "+selisih);
        System.out.println("Keluaran: "+ (max+selisih));
    }

    static int[][] nestLoop(int n, int m){
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        return a;
    }

    static int selisih(int a, int b){
        return a-b<0 ? -(a-b) : a-b;
    }

    static boolean validation(int n, int m){
        if (2<=n && 2<=m && n*m<=Math.pow(10, 5)) return true;
        else return false;
    }
}
