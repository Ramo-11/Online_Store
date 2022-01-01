import GUI.Frames.Frame;
import Program.*;

public class Main {

    DataController dataController;

    public static void main(String[] args) {
        Main controller = new Main();
        controller.dataController = new DataController();

        new Frame("Online Store");
    }
    
}