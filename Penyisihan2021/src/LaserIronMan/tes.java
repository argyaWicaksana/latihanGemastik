package LaserIronMan;

/**
 * tes
 */
public class tes {

    public static void main(String[] args) {
        int[][] a = {{-6, 5}, {-3, 5}};
        int[][] b = {{4, -3}, {4, -5}};
        System.out.println(intersect(a, b));
        
    }

    static boolean intersect(int[][] a, int[][] b){
        int o1 = orientation(a[0], a[1], b[0]);
        int o2 = orientation(a[0], a[1], b[1]);
        int o3 = orientation(b[0], b[1], a[0]);
        int o4 = orientation(b[0], b[1], a[1]);

        if (o1 != o2 && o3 != o4) return true;
        if (o1 == 0 && onSegment(a[0], b[0], a[1])) return true;
        if (o2 == 0 && onSegment(a[0], b[1], a[1])) return true;
        if (o3 == 0 && onSegment(b[0], a[0], b[1])) return true;
        if (o4 == 0 && onSegment(b[0], a[1], b[1])) return true;

        return false;
    }

    static int orientation(int[] a, int[] b, int[] c){
        int val = (b[1] - a[1]) * (c[0] - b[0]) - (b[0] - a[0]) * (c[1] - b[1]);
        if (val == 0) return 0;
        return (val > 0) ? 1 : 2;
    }
    
    static int min(int a, int b){
        return a > b ? b : a;
    }

    static int max(int a, int b){
        return a < b ? b : a;
    }

    static boolean onSegment(int[] a,int[] b,  int[] c){
        return (b[0] <= max(a[0], c[0]) && b[0] >= min(a[0], c[0]) &&
        b[1] <= max(a[1], c[1]) && b[1] >= min(a[1], c[1]));
    }
}