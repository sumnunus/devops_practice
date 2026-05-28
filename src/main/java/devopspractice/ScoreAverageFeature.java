package devopspractice;

public class ScoreAverageFeature {
    public static void run() {
        int[] scores = {90, 85, 100};
        int total = 0;

        for (int score : scores) {
            total += score;
        }

        double average = (double) total / scores.length;

        System.out.println("[Score Average]");
        System.out.println("Average score: " + average);
    }
}
