package tp04simulaciondecolas;

import tp04simulaciondecolas.GUI.Controller;

public class Main {

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

        //TODO: JAVAFX PART, the code below parses the arguments, no idea how to use them in javafx
        //TODO: probably you need to do the update (iterations) number of times then thread.sleep(ms)
        if (args.length > 2) {
            if (args[2].charAt(0) != '-')
                usage();
            int ms;
            int iterations;
            try {
                iterations = Integer.parseInt(args[2].substring(1)); // cut the - from the argument
                ms = Integer.parseInt(args[3]);
            } catch (NumberFormatException e) {
                System.out.println("-n or ms argument not an integer number");
                usage();
            }
            Controller controller = new Controller();
            controller.start();
        }
        if(args.length == 2) {
            // if the simulation wasn't run just calculate everything 'instantly'
            int currentTime = 0; // current time unit
            while (currentTime < simulationLength) {
                supermarket.update(currentTime++);
            }
        }
        supermarket.finish();
        System.out.println(supermarket);
        //TODO: END, write the results to a file
        //TODO:something like io.write(supermarket); or io.write(supermarket.toString())
    }
}

