package JalanVirtual;
import java.util.Scanner;

public class jalanVirtual {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] M = new int[N];
        for (int i = 0; i < N; i++) {
            M[i] = sc.nextInt();
        }

        for (int var : M) {
            loop(var);
        }
    }

    public static void loop(int M) {
        int max = 1, arah, x=0, y=0, i=0, itr=0;

        outerloop:
        while (true) {
            arah = (i%4)+1;
            for (int j = 0; j < max; j++) {
                if(itr >= M) break outerloop;
                switch (arah) {
                    case 1:
                        x++;
                        break;
                    case 2:
                        y++;
                        break;
                    case 3:
                        x--;
                        break;
                    case 4:
                        y--;
                        break;
                    default:
                        break;
                }
                itr++;
            }
            max++;
            i++;
        }
            
        System.out.println(x+" "+y);
    }
}
