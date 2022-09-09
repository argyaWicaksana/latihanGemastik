package SoalGemastik;

import java.util.Scanner;

public class Main {
    static int a, b, c, d, way=0;
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int N = sc.nextInt();
        // int[] num = new int[4];
        int[] num ={1,2,4,3, -1};
        a = 1;
        b = 2;
        c = 4;
        d = 3;

        permute(num,0, num.length-1);
        System.out.println("cara: "+way);
        
        // int a = sc.nextInt();
        // int b = sc.nextInt();num.length
        // int c = sc.nextInt();
        // int d = sc.nextInt();
        
    }

    static void permute(int[] num, int l, int r) { 
        if (l == r){ 
            int[] idx = new int[4];
            // for (int i : num) {
            //     System.out.print(i+" ");
            // }
            // System.out.println();
            for (int i = 0; i < num.length; i++) {
                if(num[i]==a) idx[0] = i;
                else if(num[i]==b) idx[1] = i;  
                else if(num[i]==c) idx[2] = i;  
                else if(num[i]==d) idx[3] = i;  
            }
            if(num[0]<num[1] && num[2]<num[3])way++;
        }else { 
            for (int i = l; i <= r; i++){ 
                num = swap(num,l,i); 
                permute(num, l+1, r); 
                num = swap(num,l,i); 
            } 
        } 
    } 
  
    static int[] swap(int[] a, int i, int j) { 
        int temp = a[i] ; 
        a[i] = a[j]; 
        a[j] = temp; 
        return a; 
    }
}
