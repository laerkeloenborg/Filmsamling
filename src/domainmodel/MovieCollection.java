package domainmodel;

import datasource.FileHandler;

import java.util.ArrayList;


public class MovieCollection {
    private ArrayList<Movie> movieCollection;
    private FileHandler fileHandler;


    public MovieCollection() {
        this.fileHandler = new FileHandler();
        movieCollection = fileHandler.loadListOfMovies();
    }

    public ArrayList<Movie> getMovieCollection() {
        return movieCollection;
    }

    public void addMovie(Movie movie) {
        movieCollection.add(movie);
    }

    //method to search for a specific movie in the movie collection
    public String searchMovies(String title) {
        String result = "";
        boolean foundAny = false;

        for (Movie movie : movieCollection) {
            if (movie.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result += "Title: " + movie.getTitle() + "\n";
                result += "Director: " + movie.getDirector() + "\n";
                result += "Year: " + movie.getYearCreated() + "\n";
                result += "In color: " + (movie.getIsInColor() ? "Yes" : "No") + "\n";
                result += "Length: " + movie.getLengthInMinutes() + " minutes\n";
                result += "Genre: " + movie.getGenre() + "\n\n";
                foundAny = true;
            }
        }

        //if foundAny is true return result if not return string
        return foundAny ? result : "No movies matching your request..";
    }


    //method to find the specific movie you want to edit
    public Movie findMovieToEdit(String title) {
        for (Movie movie : movieCollection) {
            if (movie.getTitle().toLowerCase().contains(title.toLowerCase())) {
                return movie;
            }
        }
        return null;
    }

    public String editMovie(Movie movie, int choice, String newValue) {
        switch (choice) {
            case 1:
                movie.setTitle(newValue);
                break;
            case 2:
                movie.setDirector(newValue);
                break;
            case 3:
                //Integer.parseInt take the String newValue and change to an int
                movie.setYearCreated(Integer.parseInt(newValue));
                break;
            case 4:
                //if new value equals yes, isInColor returns true
                //if not, it will return false
                boolean isInColor = newValue.equalsIgnoreCase("yes");
                movie.setIsInColor(isInColor);
                break;
            case 5:
                movie.setLengthInMinutes(Integer.parseInt(newValue));
                break;
            case 6:
                movie.setGenre(newValue);
                break;
            default:
                return "Invalid choice";
        }
        return " ";
    }

    //Denne metode bruges kun til test
    public int getNumberOfMovies() {
        return movieCollection.size();
    }

    public Movie deleteMovie(String title) {
        Movie movieToDelete = findMovieToEdit(title);
        if (movieToDelete != null) {
            movieCollection.remove(movieToDelete);
            return movieToDelete;
        }
        return null;
    }

    public ArrayList<Movie> save() {
        return fileHandler.saveListOfMovies(movieCollection);
    }

}

