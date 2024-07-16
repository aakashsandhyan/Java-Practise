package concurrency.singleton;

public class BasicSingleton {

    private BasicSingleton(){
    }

    private static BasicSingleton INSTANCE = null;

    public static BasicSingleton getInstance(){
        if(INSTANCE == null){
            INSTANCE = new BasicSingleton();
        }
        return INSTANCE;
    }

}
