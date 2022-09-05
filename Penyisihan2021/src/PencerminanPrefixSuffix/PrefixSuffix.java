package PencerminanPrefixSuffix;
import java.util.Scanner;

public class PrefixSuffix {
    static String S;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        S = sc.nextLine();
        int Q = sc.nextInt();
        int[] num = new int[Q];
        int numind = 0;

        for (int i = 0; i < Q; i++) {
            num[i] = -1;
        }

        for (int i = 0; i < Q; i++) {
            byte op=sc.nextByte();
            if (op==1) {
                int x = sc.nextInt();
                char c = sc.next().charAt(0);
                changeChar(x, c);
            } else if(op==0) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                num[numind] = panjang(a, b);
                numind++;
            }
        }

        for (int pjg : num) {
            if(pjg == -1)continue;
            System.out.println(pjg);
        }
    }

    public static void changeChar(int x, char c) {
        S = S.substring(0,x)+c+S.substring(x+1);
    }

    public static int panjang(int a, int b) {
        String s = S.substring(a, b+1);
        int i=0, j=s.length()-1, l=0;

        while (j>=0 || i<s.length()) {
            if(s.charAt(i) == s.charAt(j)) l++;
            else break;
            i++;
            j--;
        }
        
        return l;
    }
}
