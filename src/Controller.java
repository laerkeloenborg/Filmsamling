import java.util.Scanner;

public class Controller {
   private Movie movie;
   private MovieCollection movieCollection;

   public Controller(){
      movieCollection = new MovieCollection();
   }

   public void addMovie(Movie movie) {
    movieCollection.addMovie(movie);
   }

   public String searchMovies (String title){
      return movieCollection.searchMovies(title);
   }

   public MovieCollection getMovieCollection(){
      return movieCollection;
   }

}