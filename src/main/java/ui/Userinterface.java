package main.java.ui;

import main.java.datasource.domainmodel.*;
import main.java.domainmodel.*;

import java.domainmodel.*;
import java.util.*;

public class Userinterface {
    private Controller controller;
    private Scanner input = new Scanner(System.in);

    public Userinterface() {
        controller = new Controller();
    }


    public void startCollection() {
        // main menu loop - continues until user selects exit (6)
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

                    // add the director name with validation (no numbers allowed)
                    System.out.println("now the director:");
                    String addDirector;
                    addDirector = "";
                    boolean validInput = false;
                    while (!validInput) {
                        addDirector = input.nextLine();
                        validInput = true;
                        // check each character in director name and make sure its characters, not numbers
                        for (int i = 0; i < addDirector.length(); i++)
                            if (Character.isDigit(addDirector.charAt(i))) {
                                System.out.println("you have to enter a real name, not numbers");
                                validInput = false;
                                break;
                            }
                    }

                    // Add movie year with validation (must be 4 digits)
                    System.out.println("add the year it was created:");
                    int addYearCreated = 0;
                    boolean validInput2 = false;
                    while (!validInput2) {
                        try {
                            addYearCreated = input.nextInt();
                            // the check to make sure year is 4 digits
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

                    // Add movie color information (yes/no question)
                    System.out.println("is the movie in color?");
                    String addIsInColor1;
                    boolean addIsInColor;
                    while (true) {
                        addIsInColor1 = input.next();
                        // Convert yes/no to boolean
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

                    // Add genre with validation (no numbers allowed)
                    System.out.println("now which genre is it?:");
                    String addGenre;
                    addGenre = " ";
                    boolean validInput1 = false;
                    while (!validInput1) {
                        addGenre = input.next();
                        validInput1 = true;
                        // Check to make sure input is characters, not numbers
                        for (int i = 0; i < addGenre.length(); i++)
                            if (Character.isDigit(addGenre.charAt(i))) {
                                System.out.println("you have to enter a Genre, not numbers!");
                                validInput1 = false;
                                break;
                            }
                    }

                    // Create a new Movie object with the added movie information
                    Movie movie1 = new Movie(addTitle, addDirector, addYearCreated, addIsInColor, addLengthInMinutes, addGenre);

                    // Add movie information and save
                    controller.addMovie(movie1);
                    System.out.println(movie1);
                    controller.savingMovies();
                    break;
                case 2:
                    boolean sortMovieList = true;
                    while (sortMovieList) {
                        System.out.println("\nWhat is your primary attribute: ");
                        System.out.println("1. Title");
                        System.out.println("2. Director");
                        System.out.println("3. Year");
                        System.out.println("4. Color Status");
                        System.out.println("5. Length");
                        System.out.println("6. Genre");


                        int primaryChoice = input.nextInt();

                        Comparator<Movie> comparator = null;
                        switch (primaryChoice) {
                            case 1:
                                comparator = new ComparatorTitle();
                                break;
                            case 2:
                                comparator = new ComparatorDirector();
                                break;
                            case 3:
                                comparator = new ComparatorYear();
                                break;
                            case 4:
                                comparator = new ComparatorColor();
                                break;
                            case 5:
                                comparator = new ComparatorLength();
                                break;
                            case 6:
                                comparator = new ComparatorGenre();
                                break;
                            default:
                                System.out.println("unvalid number");
                        }

                        System.out.println("\nWhat is your secondary attribute: ");
                        System.out.println("1. Title");
                        System.out.println("2. Director");
                        System.out.println("3. Year");
                        System.out.println("4. Color Status");
                        System.out.println("5. Length");
                        System.out.println("6. Genre");

                        int secondaryChoice = input.nextInt();

                        switch (secondaryChoice) {
                            case 1:
                                comparator = comparator.thenComparing(new ComparatorTitle());
                                break;
                            case 2:
                                comparator = comparator.thenComparing(new ComparatorDirector());
                                break;
                            case 3:
                                comparator = comparator.thenComparing(new ComparatorYear());
                                break;
                            case 4:
                                comparator = comparator.thenComparing(new ComparatorColor());
                                break;
                            case 5:
                                comparator = comparator.thenComparing(new ComparatorLength());
                                break;
                            case 6:
                                comparator = comparator.thenComparing(new ComparatorGenre());
                                break;
                            default:
                                System.out.println("Unvalid number");
                        }

                        // Sort the movie collection using primary and secondary
                        Collections.sort(controller.getMovieCollection(), comparator);

                        // Display the sorted movie list
                        System.out.println("The movielist is now sorted as you wanted.\n");
                        for (Movie movie : controller.getMovieCollection()){
                            System.out.println(movie);
                        }
                        break;
                    }
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

                    // Search for the movie in the collection you want to edit
                    Movie movieToEdit = controller.findMovieToEdit(searchMovieToEdit);
                    if (movieToEdit == null) {
                        System.out.println("domainmodel.Movie not found.");
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

                        // Check if user is done editing and want to exit the loop
                        if (editChoice == 7) {
                            editingMovie = false;
                            continue;
                        }

                        if (editChoice >= 1 && editChoice <= 6) {
                            System.out.println("Enter new value:");
                            String newValue = input.nextLine();

                            // Update the movie information
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

                    // Try to delete the movie using deleteMovie method
                    Movie deletedMovie = controller.deleteMovie(titleToDelete);

                    // Check if deletion was successful
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
