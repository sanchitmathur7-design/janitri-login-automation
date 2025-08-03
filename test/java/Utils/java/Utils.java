package Utils.java;

public class Utils {

    // Method to pause the execution for given milliseconds
    public static void waitForSeconds(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


