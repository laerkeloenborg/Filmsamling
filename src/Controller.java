import java.util.Scanner;

public class Controller {
    private Movie movie;
    private MovieCollection movieCollection1 = new MovieCollection();
    Scanner input = new Scanner(System.in);
    Movie spiderman = new Movie("Spiderman", "P", 1234, true, 120, "action");



    public void startCollection() {
        movieCollection1.addMovie(spiderman);
        System.out.println("welcome to my movie collection!");
        int addingmovies = -1;
        while (addingmovies != 4) {
            System.out.println(
                    "\npress:\n" +
                            "1. for entering a film to the collection\n" +
                            "2. for viewing of movie collection\n" +
                            "3. for searching movie\n" +
                            "4. for exiting");
            addingmovies = input.nextInt();
            switch (addingmovies) {
                case 1:
                    System.out.println("enter a movie to your collection\n" +
                            "start with a title:");
                    String addTitle = input.next();
                    System.out.println("now the director:");
                    String addDirector = input.next();
                    System.out.println("add the year it was created:");
                    int addYearCreated = input.nextInt();
                    System.out.println("is the movie in color?");
                    String addIsInColor1 = input.next();
                    boolean addIsInColor;
                    if (addIsInColor1.equalsIgnoreCase("yes")) {
                        addIsInColor = true;
                    } else {
                        addIsInColor = false;
                    }

                    System.out.println("how long is the movie in minutes?:");
                    double addLenghtInMinutes = input.nextDouble();
                    System.out.println("now which genre is it?:");
                    String addGenre = input.next();

                    Movie movie1 = new Movie(addTitle, addDirector, addYearCreated, addIsInColor, addLenghtInMinutes, addGenre);
                    movieCollection1.addMovie(movie1);
                    System.out.println(movie1);
                    break;
                case 2:
                    System.out.println(movieCollection1.toString());
                    break;
                case 3:
                    System.out.println("Enter the title of your movie");
                    String searchTitle = input.next();
                    String searchResult = movieCollection1.searchMovie(searchTitle);
                    System.out.println(searchResult);
                case 4:
                    System.out.println("you are now exiting the movie collection");
                    break;
                default:
            }
        }
    }
}
