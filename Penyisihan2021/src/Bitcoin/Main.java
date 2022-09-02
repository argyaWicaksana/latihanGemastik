package Bitcoin;

import java.util.Scanner;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] h = new int[N];
        // int[] h ={17,16,15,12,10,4};
        int selisih=0, keuntungan=0, tmp=-1, dayBuy=0, daySell=0;
        // int[] a = new int[2];

        for (int j = 0; j < h.length; j++) {
            h[j] = sc.nextInt();
        }

        int i = 0;
        while(true){
            for (int j = i+1; j < h.length; j++) {
                if(h[j]>h[i] && (h[j]-h[i] > selisih)){
                    selisih = h[j]-h[i];
 
                    dayBuy = i;
                    daySell = j;
                }
            }

            if(daySell==0 && i!=0) break;

            for (int j = daySell; j > 0; j--){
                if(h[j] < h[dayBuy]) dayBuy = j;
                else if(h[j] == h[dayBuy]) break;
            }

            keuntungan += h[daySell] - h[dayBuy];

            i = daySell+1;
            selisih = 0;
            dayBuy=daySell= 0;
        }
        System.out.println(keuntungan);
    }
}