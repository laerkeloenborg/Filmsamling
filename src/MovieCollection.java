import java.util.ArrayList;

public class MovieCollection {
    private ArrayList<Movie> movieCollection = new ArrayList<>();

    public MovieCollection(ArrayList<Movie> movieCollection){
        this.movieCollection = movieCollection;
    }

    public ArrayList<Movie> getMovieCollection(){
        return movieCollection;
    }

    public void setMovieCollection(ArrayList<Movie> movieCollection){
        this.movieCollection = movieCollection;
    }

    public void addMovie(Movie movie){
        movieCollection.add(movie);
    }



}
