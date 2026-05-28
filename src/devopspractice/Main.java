package devopspractice;

public class Main {
    public static void main(String[] args) {
        System.out.println("DevOps Practice Java Project");
        runFeature("devopspractice.MemberSummaryFeature");
        runFeature("devopspractice.ScoreAverageFeature");
    }

    private static void runFeature(String className) {
        try {
            Class<?> featureClass = Class.forName(className);
            featureClass.getMethod("run").invoke(null);
        } catch (ClassNotFoundException e) {
            System.out.println(className + " is not merged yet.");
        } catch (ReflectiveOperationException e) {
            throw new IllegalStateException("Failed to run " + className, e);
        }
    }
}
