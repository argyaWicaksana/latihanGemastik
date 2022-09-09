package PrioritasProyekDawala;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p =sc.nextInt();
        int[] coordinate = new int[2];
        Village[] v1 = new Village[p];
        Village[] v2 = new Village[p];
        RangeVillage[] r = new RangeVillage[p];

        for (int i = 0; i < p; i++) {
            String nm = sc.next();
            coordinate[0] = sc.nextInt();
            coordinate[1] = sc.nextInt();
            int dc = sc.nextInt();
            v1[i] = new Village(nm, coordinate);

            nm = sc.next();
            coordinate[0] = sc.nextInt();
            coordinate[1] = sc.nextInt();
            dc = sc.nextInt();
            v2[i] = new Village(nm, coordinate);
            sc.nextLine();
        }

        for (int i = 0; i < p; i++) {
            int num=0;
            for (int j = 0; j < 2; j++)
                num+=Math.pow(v1[i].coordinate[j]-v2[i].coordinate[j], 2);
            
            r[i] = new RangeVillage((int)Math.sqrt(num), v1[i], v2[i]);
        }
        
        //sorting
        for (int i = 0; i < r.length; i++) {
            int max=i;
            RangeVillage tmp;
            for (int j = i+1; j < r.length; j++)
                if(r[j].range > r[max].range) max = j;
            
            tmp = r[max];
            r[max] = r[i];
            r[i] = tmp;
        }

        for (RangeVillage rVillage : r) {
            System.out.printf("%s %s %d\n",rVillage.a.name, rVillage.b.name, rVillage.range);
        }
    }
}

class Village{
    int[] coordinate;
    String name;

    Village(String name, int[] coordinate){
        this.name = name;
        this.coordinate = coordinate.clone();
    }
}

class RangeVillage{
    int range;
    Village a, b;

    RangeVillage(int range, Village a, Village b){
        this.range = range;
        this.a = a;
        this.b = b;
    }
}