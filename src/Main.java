import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        PrintStream output = new PrintStream(new File("movieCollection.txt"));
        Userinterface userinterface = new Userinterface();
        userinterface.startCollection(output);


    }

}
