package tp04simulaciondecolas;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ViewFXML.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    /**
     * Display command line usage help
     */
    public static void usage() {
        System.out.println("Usage: java -jar filename.jar fileIn fileOut [-n ms]");
        System.exit(0);
    }

    public static void main(String[] args) {
        if (args.length < 2)
            usage();
        String fileIn = args[0];
        String fileOut = args[1];
        //IO io = new IO(fileIn, fileOut);
        //TODO: fill io object (io.read(void))
        //WARNING: HARDCODED TEST
        Supermarket supermarket = new Supermarket(4, 0.5, 6, 14);//TODO: GET THIS FROM IO (supermarket = io.getSupermarket)
        int simulationLength = 40; // TODO: GET THIS FROM THE IO (simlength = io.getsimlength())
        int currentTime = 0; // current time unit
        while (currentTime < simulationLength) {
            supermarket.update(currentTime++);
        }
        supermarket.finish();
        System.out.println(supermarket);
        //TODO: JAVAFX PART, the code below parses the arguments, no idea how to use them in javafx
        //TODO: probably you need to do the update (iterations) number of times then thread.sleep(ms)
        if (args.length > 2) {
            if (args[3].charAt(0) != '-')
                usage();
            int ms;
            int iterations;
            try {
                iterations = Integer.parseInt(args[3].substring(1)); // cut the - from the argument
                ms = Integer.parseInt(args[4]);
            } catch (NumberFormatException e) {
                System.out.println("-n or ms argument not an integer number");
                usage();
            }
            launch(args);
        }
        //TODO: END, write the results to a file
        //TODO:something like io.write(supermarket); or io.write(supermarket.toString())
    }
}

