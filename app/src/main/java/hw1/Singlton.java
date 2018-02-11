package hw1;

/**
 * Created by Archibal on 09.02.2018.
 */

public class Singlton {
    private static Singlton instanse = new Singlton();
    public String text;
    private Singlton() {

    }
    public  static Singlton getInstance(){
        return instanse;
    }

}
