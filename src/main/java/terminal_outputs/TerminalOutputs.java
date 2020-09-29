package terminal_outputs;

import java.io.PrintStream;
import java.util.logging.Logger;

public class TerminalOutputs {
    private static PrintStream os = System.out;
    public static void main(String[] args) {
        // using os print stream
        os.println("test");
        // using os print stream1
        String line = String.format("%s%n","test");
        os.print(line);

        // using logger1
        Logger.getLogger(TerminalOutputs.class.getName()).warning("test");
    }

    public void testMethod1(){
        // in non static method you can use this notation
        Logger.getLogger(String.valueOf( getClass() )).warning("test");
    }
}
