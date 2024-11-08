package main.java.datasource;

import main.java.domainmodel.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {


    //saves a collection of movies to a text file.
    //each movie object is saved in seperate lines, in a special format by using a custom toString(toStringFile).
    public ArrayList<Movie> saveListOfMovies(ArrayList<Movie> movieCollection) {
        PrintStream output = null;
        try {
            output = new PrintStream(new File("movieCollection.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (Movie movie : movieCollection) {
            output.println(movie.toStringToFile());
        }
        return movieCollection;
    }


    //method to load collection of movies from our textfile.
    //it reads every line in the file and recreate it as a movie object.
    // line.split(;) is used to assume that the semicolon is just used for seperarating attributes.
    public ArrayList<Movie> loadListOfMovies() {
        ArrayList<Movie> movieCollection = new ArrayList<>();
        Scanner scanner = null;
        File file = new File("movieCollection.txt");
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Movie movie = null;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] attributes = line.split(";");
            movie = new Movie(attributes[0],
                    attributes[1],
                    Integer.parseInt(attributes[2]),
                    Boolean.parseBoolean(attributes[3]),
                    Integer.parseInt(attributes[4]),
                    attributes[5]);

            movieCollection.add(movie);
        }

        scanner.close();
        return movieCollection;
    }


}
