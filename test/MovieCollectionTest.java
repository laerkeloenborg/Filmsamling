import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MovieCollectionTest {

    @Test
    void getMovieCollection() {
        //Arrange
        Movie movie = new Movie("ja", "nej", 2024, true, 110,"drama");
        Movie movie2 = new Movie("nej", "ja", 2020, false, 1000, "action");
        Movie movie3 = new Movie("måske", "bob", 2930, true, 192, "yesyes");
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

    @Disabled
    void setMovieCollection() {
    }

    @Test
    void addMovie() {
        //Arrange
        Movie movie = new Movie("ja", "nej", 2024, true, 110,"drama");
        MovieCollection movieCollection = new MovieCollection();

        movieCollection.addMovie(movie);

        //Act
        movieCollection.searchMovies("ja");
        String actualResult = movie.getTitle();

        //Assert
        String expectedResult = "ja";
        assertEquals(expectedResult,actualResult);

    }

    @Disabled
    void searchMovies() {
    }

    @Disabled
    void findMovie() {
    }

    @Disabled
    void editMovie() {
    }

    @Disabled
    void testToString() {
    }
}