import java.util.Scanner;

public class Controller {
    private Movie movie;
    Scanner addMovie = new Scanner(System.in);

    public void startCollection() {
        System.out.println("welcome to my movie collection!");
        int addingmovies = -1;
        while (addingmovies != 3) {
            System.out.println(
                    "\npress:\n" +
                            "1. for entering a film to the collection\n" +
                            "2. for exiting");
            addingmovies = addMovie.nextInt();
            switch (addingmovies) {
                case 1:
                    System.out.println("enter a movie to your collection\n" +
                            "start with a title:");
                    String addTitle = addMovie.next();
                    System.out.println("now the director:");
                    String addDirector = addMovie.next();
                    System.out.println("add the year it was created:");
                    int addYearCreated = addMovie.nextInt();
                    System.out.println("is the movie in color?");
                    String addIsInColor1 = addMovie.next();
                    boolean addIsInColor;
                    if (addIsInColor1.equalsIgnoreCase("yes")) {
                        addIsInColor = true;
                    } else {
                        addIsInColor = false;
                    }

                    System.out.println("how long is the movie in minutes?:");
                    double addLenghtInMinutes = addMovie.nextDouble();
                    System.out.println("now which genre is it?:");
                    String addGenre = addMovie.next();

                    Movie movie1 = new Movie(addTitle, addDirector, addYearCreated, addIsInColor, addLenghtInMinutes, addGenre);
                    System.out.println(movie1);
                    break;
                case 2:
                    System.out.println("you are now exiting the movie collection");
                    break;
                default:
            }
        }
    }

}
