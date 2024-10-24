import java.util.Scanner;

public class Userinterface {
    Controller controller;
    Scanner input = new Scanner(System.in);

    Movie spidermanhome = new Movie("spiderman homecoming", "Jon Watts", 2017, true, 133, "Action");
    Movie spidermannoway = new Movie("spiderman no way home", "Jon Watts", 2021, true, 148, "Action");
    Movie howtoloose = new Movie("How to Lose a Guy in 10 Days", "Donald Petrie", 2003, true, 148, "RomCom");
    Movie thedarkknight = new Movie("the dark knight", "Christopher Nolan", 2008, true, 152, "Action");

    public Userinterface(){
        controller = new Controller();
    }

    public void startCollection() {
        controller.addMovie(spidermanhome);
        controller.addMovie(spidermannoway);
        controller.addMovie(howtoloose);
        controller.addMovie(thedarkknight);

        System.out.println("welcome to my movie collection!");
        int addingmovies = -1;
        while (addingmovies != 5) {
            System.out.println("\npress:\n" +
                    "1. for entering a film to the collection\n" +
                    "2. for viewing of movie collection\n" +
                    "3. for searching movie\n" +
                    "4. for exiting");
            addingmovies = input.nextInt();
            switch (addingmovies) {
                case 1:
                    System.out.println("enter a movie to your collection\n" + "start with a title:");
                    input.nextLine();
                    String addTitle = input.nextLine();
                    System.out.println("now the director:");
                    String addDirector = input.nextLine();
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
                    controller.addMovie(movie1);
                    System.out.println(movie1);
                    break;
                case 2:
                    System.out.println(controller.getMovieCollection());
                    break;
                case 3:
                    System.out.println("Enter the title of your movie");
                    String searchTitle = input.next();
                    String searchResult = controller.searchMovies(searchTitle);
                    System.out.println(searchResult);
                    break;
                case 4:
                    System.out.println("Enter the title of the movie you want to edit:");
                    input.nextLine();
                    String searchMovieToEdit = input.nextLine();

                    Movie movieToEdit = controller.findMovie(searchMovieToEdit);
                    if (movieToEdit == null) {
                        System.out.println("Movie not found.");
                        break;
                    }

                    System.out.println("movie information:");
                    System.out.println(movieToEdit);

                    System.out.println("new info:");

                    System.out.println("Title:");
                    String newTitle = input.nextLine();
                    System.out.println("Director:");
                    String newDirector = input.nextLine();
                    System.out.println("Year Created:");
                    int newYear = input.nextInt();
                    System.out.println("Is in color:");
                    boolean newColor = input.nextBoolean();
                    System.out.println("Length:");
                    double newLength = input.nextDouble();
                    System.out.println("Genre:");
                    String newGenre = input.nextLine();


                    controller.editMovie(movieToEdit, newTitle, newDirector, newYear, newColor, newLength, newGenre);

                    System.out.println("updated movie info:");
                    System.out.println(movieToEdit);
                    break;
                default:
            }
        }
    }

}
