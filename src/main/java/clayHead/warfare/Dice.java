package clayHead.warfare;

import java.util.Random;

public class Dice {
    private static Random rand = new Random();

    private static int d20() {
        // Run random number generator 100 times to ensure randomness
        for (int i = 0; i < 100; i++) {
            rand.nextInt(2);
        }
        return 1 + rand.nextInt(20);
    }

    public static int roll(int bonus) {
        return d20() + bonus;
    }

    public static int rollAdvantage(int bonus, boolean advantage) {
        int r1 = roll(bonus);
        int r2 = roll(bonus);
        if (advantage) {
            if (r2 > r1) { r1 = r2;}
        }
        else if (!advantage) {
            if (r2 < r1) { r1 = r2; }
        }
        return r1;
    }

    public static int rollSize(int size) {
        // Run random number generator 100 times to ensure randomness
        for (int i = 0; i < 100; i++) {
            rand.nextInt(2);
        }
        return 1 + rand.nextInt(size);
    }

    public static boolean check(int bonus, int DC) {
        return roll(bonus) >= DC;
    }

    public static boolean checkAdvantage(int bonus, int DC, boolean advantage) {
        int r1 = roll(bonus);
        int r2 = roll(bonus);
        if (advantage) {
            if (r2 > r1) { r1 = r2;}
        }
        else if (!advantage) {
            if (r2 < r1) { r1 = r2; }
        }
        return r1 >= DC;
    }
}