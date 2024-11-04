
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Userinterface {
    private Controller controller;
    private Scanner input = new Scanner(System.in);

//    Movie spidermanhome = new Movie("spiderman homecoming", "Jon Watts", 2017, true, 133, "Action");
//    Movie spidermannoway = new Movie("spiderman no way home", "Jon Watts", 2021, true, 148, "Action");
//    Movie howtoloose = new Movie("How to Lose a Guy in 10 Days", "Donald Petrie", 2003, true, 148, "RomCom");
//    Movie thedarkknight = new Movie("the dark knight", "Christopher Nolan", 2008, true, 152, "Action");



    public Userinterface() {
        controller = new Controller();
    }

    public void startCollection() {
//        controller.addMovie(spidermanhome);
//        controller.addMovie(spidermannoway);
//        controller.addMovie(howtoloose);
//        controller.addMovie(thedarkknight);





        System.out.println("welcome to your movie collection!");
        int addingMovies = -1;
        while (addingMovies != 6) {
            System.out.println("\npress:\n" +
                    "1. for entering a film to the collection\n" +
                    "2. for viewing of movie collection\n" +
                    "3. for searching movie\n" +
                    "4. for editing a movie\n" +
                    "5. for deleting a movie\n" +
                    "6. for exiting");

            try {
                addingMovies = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("You need to enter a value from 1-5");
                input.next();
            }
            switch (addingMovies) {
                case 1:
                    System.out.println("enter a movie to your collection\n" + "start with a title:");
                    input.nextLine();
                    String addTitle = input.nextLine();

                    System.out.println("now the director:");
                    String addDirector;
                    addDirector = "";
                    boolean validInput = false;
                    while (!validInput) {
                        addDirector = input.nextLine();
                        validInput = true;
                        for (int i = 0; i < addDirector.length(); i++)
                            if (Character.isDigit(addDirector.charAt(i))) {
                                System.out.println("you have to enter a real name, not numbers");
                                validInput = false;
                                break;
                            }
                    }

                    System.out.println("add the year it was created:");
                    int addYearCreated = 0;
                    boolean validInput2 = false;
                    while (!validInput2) {
                        try {
                            addYearCreated = input.nextInt();
                            if (addYearCreated >= 1000 & addYearCreated <= 9999) {
                                validInput2 = true;
                            } else {
                                System.out.println("The year must be exactly 4 digits");
                            }
                        } catch (InputMismatchException exception) {
                            System.out.println("You need to type in numbers: " + exception.getMessage());
                            exception.printStackTrace();
                            input.next();
                        }
                    }

                    System.out.println("is the movie in color?");
                    String addIsInColor1;
                    boolean addIsInColor;
                    while (true) {
                        addIsInColor1 = input.next();
                        if (addIsInColor1.equalsIgnoreCase("yes")) {
                            addIsInColor = true;
                            break;
                        } else if (addIsInColor1.equalsIgnoreCase("no")) {
                            addIsInColor = false;
                            break;
                        } else {
                            System.out.println("invalid input, try again");
                        }
                    }

                    System.out.println("how long is the movie in minutes?:");
                    int addLengthInMinutes = input.nextInt();

                    System.out.println("now which genre is it?:");
                    String addGenre;
                    addGenre = " ";
                    boolean validInput1 = false;
                    while (!validInput1) {
                        addGenre = input.next();
                        validInput1 = true;
                        for (int i = 0; i < addGenre.length(); i++)
                            if (Character.isDigit(addGenre.charAt(i))) {
                                System.out.println("you have to enter a Genre, not numbers!");
                                validInput1 = false;
                                break;
                            }
                    }

                    Movie movie1 = new Movie(addTitle, addDirector, addYearCreated, addIsInColor, addLengthInMinutes, addGenre);
                    controller.addMovie(movie1);
                    System.out.println(movie1);
                    controller.savingMovies();
                    break;
                case 2:
                    System.out.println(controller.load());
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
                    controller.savingMovies();
                    break;
                case 5:
                    System.out.println("Enter the title of the movie you want to delete:");
                    input.nextLine();
                    String titleToDelete = input.nextLine();
                    Movie deletedMovie = controller.deleteMovie(titleToDelete);
                    if (deletedMovie != null) {
                        System.out.println(deletedMovie.getTitle() + " has been deleted");

                    } else {
                        System.out.println("the movie " + titleToDelete + " is not found");
                    }
                    controller.savingMovies();
                    break;
                case 6:
                    System.out.println("you are now exiting your movie collection");
                    break;

                default:
            }
        }
    }

}
