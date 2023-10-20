import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int range = 1000000000;
        int num;
        int denom = 2;
        long hs = 0;
        float avg = 0;
        Integer[] results = new Integer[range];
        for (int i = 0; i < range; i++) {
            while (true) {
                num = random.nextInt(denom);
                if (num == 0) {
                    results[i] = denom;
                    avg += (float) denom/range;
                    if (denom > hs){
                        System.out.println(denom);
                        hs = denom;
                    }
                    denom = 2;
                    break;
                }
                else {
                    denom += 1;
                }
            }
            if(i%(range/100) ==0){
                System.out.println(i/10000000);
            }
        }
        System.out.println(avg);
    }
}