package solid.single_responsibility.main.java.hr.logging;

public class ConsoleLogger {

    public void logInfo(String msg){
        System.out.println("INFO: " + msg);
    }

    public void logError(String errorMsg){
        System.out.println("ERROR: " + errorMsg);
    }
}
