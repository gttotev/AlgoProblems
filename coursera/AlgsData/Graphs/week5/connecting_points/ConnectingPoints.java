import java.util.Scanner;

public class ConnectingPoints {
    private static double minimumDistance(int[] x, int[] y, double[] cost) {
        double result = 0.0;
        cost[0] = 0.0;
        for (int i = 0; i < x.length; i++) {
            int min = -1;
            for (int j = 0; j < cost.length; j++) {
                if (cost[j] >= 0.0 && (min == -1 || cost[j] < cost[min])) {
                    min = j;
                }
            }
            result += cost[min];
            cost[min] = -1.0;
            for (int e = 0; e < x.length; e++) {
                if (cost[e] < 0.0) continue;
                double newDist = dist(x[min], y[min], x[e], y[e]);
                if (cost[e] > 0.0 && cost[e] > newDist) {
                    cost[e] = newDist;
                }
            }
        }
        return result;
    }
    
    private static double dist(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        double[] cost = new double[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
            cost[i] = 10000.0;
        }
        System.out.println(minimumDistance(x, y, cost));
    }
}
