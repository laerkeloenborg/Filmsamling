import java.util.Scanner;

public class Userinterface {
    private Controller controller;
    private Scanner input = new Scanner(System.in);

    Movie spidermanhome = new Movie("spiderman homecoming", "Jon Watts", 2017, true, 133, "Action");
    Movie spidermannoway = new Movie("spiderman no way home", "Jon Watts", 2021, true, 148, "Action");
    Movie howtoloose = new Movie("How to Lose a Guy in 10 Days", "Donald Petrie", 2003, true, 148, "RomCom");
    Movie thedarkknight = new Movie("the dark knight", "Christopher Nolan", 2008, true, 152, "Action");

    public Userinterface() {
        controller = new Controller();
    }

    public void startCollection() {
        controller.addMovie(spidermanhome);
        controller.addMovie(spidermannoway);
        controller.addMovie(howtoloose);
        controller.addMovie(thedarkknight);

        System.out.println("welcome to your movie collection!");
        int addingMovies = -1;
        while (addingMovies != 5) {
            System.out.println("\npress:\n" +
                    "1. for entering a film to the collection\n" +
                    "2. for viewing of movie collection\n" +
                    "3. for searching movie\n" +
                    "4. for editing a movie\n" +
                    "5. for exiting");
            addingMovies = input.nextInt();
            switch (addingMovies) {
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
                    int addLenghtInMinutes = input.nextInt();

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

                    Movie movieToEdit = controller.findMovieToEdit(searchMovieToEdit);
                    if (movieToEdit == null) {
                        System.out.println("Movie not found.");
                        break;
                    }

                    System.out.println("Current movie information:");
                    System.out.println(movieToEdit);

                    boolean editingMovie = true;
                    while (editingMovie) {
                        System.out.println("\nWhat would you like to edit?");
                        System.out.println("1. Title");
                        System.out.println("2. Director");
                        System.out.println("3. Year");
                        System.out.println("4. Color Status");
                        System.out.println("5. Length");
                        System.out.println("6. Genre");
                        System.out.println("7. Done editing");

                        int editChoice = input.nextInt();
                        input.nextLine();

                        if (editChoice == 7) {
                            editingMovie = false;
                            continue;
                        }

                        if (editChoice >= 1 && editChoice <= 6) {
                            System.out.println("Enter new value:");
                            String newValue = input.nextLine();
                            controller.editMovie(movieToEdit, editChoice, newValue);

                            System.out.println("\nUpdated movie information:");
                            System.out.println(movieToEdit);
                        } else {
                            System.out.println("Invalid option");
                        }
                    }

                    break;
                case 5:
                    System.out.println("you are now exiting your movie collection");
                    break;

                default:
            }
        }
    }

}
