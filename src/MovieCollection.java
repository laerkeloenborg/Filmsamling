import java.util.ArrayList;

public class MovieCollection {
    private ArrayList<Movie> movieCollection = new ArrayList<>();

    public MovieCollection() {
        this.movieCollection = movieCollection;
    }

    public ArrayList<Movie> getMovieCollection() {
        return movieCollection;
    }

    public void setMovieCollection(ArrayList<Movie> movieCollection) {
        this.movieCollection = movieCollection;
    }

    public void addMovie(Movie movie) {
        movieCollection.add(movie);
    }

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

        return foundAny ? result : "No movies matching your request..";
    }


    public Movie findMovie(String title) {
        for (Movie movie : movieCollection) {
            if (movie.getTitle().toLowerCase().contains(title.toLowerCase())) {
                return movie;
            }
        }
        return null;
    }


    public void editMovie(Movie movie, int choice, String newValue) {
        switch (choice) {
            case 1:
                movie.setTitle(newValue);
                break;
            case 2:
                movie.setDirector(newValue);
                break;
            case 3:
                movie.setYearCreated(Integer.parseInt(newValue));
                break;
            case 4:
                boolean isInColor = newValue.equalsIgnoreCase("yes");
                movie.setIsInColor(isInColor);
                break;
            case 5:
                movie.setLengthInMinutes(Double.parseDouble(newValue));
                break;
            case 6:
                movie.setGenre(newValue);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }







    @Override
    public String toString() {
        int counter = 0;
        String empty = "";
        for (Movie movie : movieCollection) {
            counter++;
            empty += "\n" + counter + ". " + movie.getTitle();
        }
        return empty;
    }
}