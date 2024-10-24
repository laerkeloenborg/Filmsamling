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

   public Movie findMovie(String title) {
      return movieCollection.findMovie(title);
   }

   public void editMovie(Movie movie, int choice, String newValue) {
      movieCollection.editMovie(movie, choice, newValue);
   }




}