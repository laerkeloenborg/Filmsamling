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

   public void editMovie(Movie movie, String title, String director, int yearCreated, boolean isInColor, double lengthInMinutes, String genre ) {
      movieCollection.editMovie(movie, title, director, yearCreated, isInColor, lengthInMinutes, genre);
   }



}