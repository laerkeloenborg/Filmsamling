import java.util.Scanner;

public class Controller {
    private Movie movie;
    private MovieCollection movieCollection1 = new MovieCollection();
    Scanner input = new Scanner(System.in);



    public void startCollection() {
        System.out.println("welcome to my movie collection!");
        int addingmovies = -1;
        while (addingmovies != 4) {
            System.out.println(
                    "\npress:\n" +
                            "1. for entering a film to the collection\n" +
                            "2. for viewing of movie collection\n" +
                            "3. for exiting");
            addingmovies = input.nextInt();
            switch (addingmovies) {
                case 1:
                    System.out.println("enter a movie to your collection\n" +
                            "start with a title:");
                    input.nextLine();
                    String addTitle = input.nextLine();
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
                    System.out.println("you are now exiting the movie collection");
                    break;
                default:
            }
        }
    }

}
