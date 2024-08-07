import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] wine = new int[n+1];
        int[] drinkWine = new int[n+1];

        for(int i = 1; i <= n; i++) {
            wine[i] = scan.nextInt();
        }


        drinkWine[1] = wine[1];
        if(n > 1) drinkWine[2] = wine[2] + wine[1];
        if(n > 2) drinkWine[3] = Math.max(drinkWine[2], Math.max(wine[2] + wine[3], drinkWine[1] + wine[3]));

        for(int i=4; i<=n; i++) {
            drinkWine[i] = Math.max(drinkWine[i-1], Math.max(drinkWine[i-2]+wine[i], drinkWine[i-3]+wine[i]+wine[i-1]));
        }

        System.out.println(drinkWine[n]);

    }
}
