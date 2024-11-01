import java.util.ArrayList;

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

   public Movie findMovieToEdit(String title) {
      return movieCollection.findMovieToEdit(title);
   }

   public void editMovie(Movie movie, int choice, String newValue) {
      movieCollection.editMovie(movie, choice, newValue);
   }

   public Movie deleteMovie(String title) {
      return movieCollection.deleteMovie(title);
   }

   public ArrayList<Movie> savingMovies(){
      return movieCollection.saveListOfMovies();
   }

   public ArrayList<Movie> load(){
      return movieCollection.loadListOfMovies();
   }







}