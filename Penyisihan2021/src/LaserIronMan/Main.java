package LaserIronMan;

import java.util.Scanner;

/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        //mencari kedudukan antar garis dan bangun datarnya
        // mencari titik potong, lalu bandingkan jarak antar ironman dengan titik potong serta jarak antar ironman dengan robot
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        Coordinate ironMan = new Coordinate(x, y);
        int N = sc.nextInt();

        Coordinate[] robot = new Coordinate[N];
        for (int i = 0; i < robot.length; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            robot[i] = new Coordinate(x, y);
        }

        int K = sc.nextInt();
        Coordinate[] sisiBangunan = new Coordinate[K];
        Coordinate[] ujungSisi = new Coordinate[K];
        for (int i = 0; i < sisiBangunan.length; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            sisiBangunan[i] = new Coordinate(x, y); // titik pertama(awal sisi)

            x = sc.nextInt();
            y = sc.nextInt();
            ujungSisi[i] = new Coordinate(x, y); // titik ujung (akhir sisi)
        }

        //eksekusi
        int defeated = 0;
        double m1, m2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                m1 = gradient(ironMan, robot[i]);
                m2 = gradient(sisiBangunan[j], ujungSisi[j]);

                if (!((m1 != m2) && 
                (range(ironMan, robot[i]) >= range(ironMan, intersection(m1, m2, ironMan.y, ujungSisi[j].y))))) { // tidak berpotongan
                    defeated++;
                }
            }
        }

        //keluaran
        System.out.println(defeated);
    }

    static double gradient(Coordinate a, Coordinate b){
        return (a.y-b.y)/(a.x-b.x);
    }

    static int range(Coordinate a, Coordinate b){ //menentukan jarak antar dua titik
        return (int)(Math.sqrt(Math.pow(a.x-b.x, 2) + Math.pow(a.y-b.y, 2)));
    }

    static Coordinate intersection(double m1, double m2, double c1, double c2){
        Coordinate intersection = new Coordinate();
        intersection.x = (int)((c2-c1) / (m1-m2));
        intersection.y = (int)(m1 * intersection.x +c1);

        return intersection;
    }
}

// gk berhasil