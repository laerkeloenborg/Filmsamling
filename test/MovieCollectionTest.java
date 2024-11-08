import main.java.domainmodel.Movie;
import main.java.domainmodel.MovieCollection;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieCollectionTest {

    @DisplayName("search for 3 movies")
    @Test
    void getMovieCollection3() {
        //Arrange
        Movie movie = new Movie("Spiderman", "Dorte", 2024, true, 110,"action");
        Movie movie2 = new Movie("The holiday", "Tom", 2020, false, 1000, "RomCom");
        Movie movie3 = new Movie("it", "bob", 2019, true, 192, "horror");
        MovieCollection movieCollection = new MovieCollection();

        movieCollection.addMovie(movie);
        movieCollection.addMovie(movie2);
        movieCollection.addMovie(movie3);

        //Act
        int actualSize = movieCollection.getNumberOfMovies();

        //Assert
        int expectedResult = 3;
        assertEquals(expectedResult,actualSize);

    }

    @DisplayName("search for 1 movie")
    @Test
    void getMovieCollection1() {
        //Arrange
        Movie movie = new Movie("Spiderman", "Dorte", 2024, true, 110,"action");
        MovieCollection movieCollection = new MovieCollection();

        movieCollection.addMovie(movie);

        //Act
        int actualSize = movieCollection.getNumberOfMovies();

        //Assert
        int expectedResult = 1;
        assertEquals(expectedResult,actualSize);

    }

    @DisplayName("search for 0 movies")
    @Test
    void getMovieCollection0() {
        //Arrange
        MovieCollection movieCollection = new MovieCollection();


        //Act
        int actualSize = movieCollection.getNumberOfMovies();

        //Assert
        int expectedResult = 0;
        assertEquals(expectedResult,actualSize);
    }


    @Test
    void addMovie() {
        //Arrange
        Movie movie = new Movie("løvernes konge", "disney", 2024, true, 110,"animation");
        MovieCollection movieCollection = new MovieCollection();

        movieCollection.addMovie(movie);

        //Act
        movieCollection.searchMovies("løvernes konge");
        String actualResult = movie.getTitle();

        //Assert
        String expectedResult = "løvernes konge";
        assertEquals(expectedResult,actualResult);

    }

    @DisplayName("Test deleting a movie")
    @Test
    void deleteMovie() {
        //Arrange
        Movie movie1 = new Movie("spiderman", "Jon", 2024, true, 120, "action");
        Movie movie2 = new Movie("jagten", "vinterberg", 2013, true, 120, "drama");
        MovieCollection movieCollection = new MovieCollection();

        movieCollection.addMovie(movie1);
        movieCollection.addMovie(movie2);

        //Act
        movieCollection.deleteMovie("spiderman");
        int actualSize = movieCollection.getNumberOfMovies();

        //Assert
        int expectedSize = 1;
        assertEquals(expectedSize, actualSize);
    }


    @Disabled
    void searchMovies() {
    }

    @Disabled
    void findMovieToEdit(){

    }

    @Disabled
    void editMovie() {
    }

    @Disabled
    void getNumbersOfMovies() {
    }

    @Disabled
    void save() {
    }


}