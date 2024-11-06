import java.util.Comparator;

public class Comparator1 implements Comparator<Movie> {
    public int compare(Movie a, Movie b){

        String[] arrOfA = a.getTitle().split(" ");
        String [] arrOfB = b.getTitle().split(" ");

        if (arrOfA[0].compareTo(arrOfB[0]) != 0){
            return arrOfA[0].compareTo(arrOfB[0]);
        } else {
            return Integer.compare(a.getYearCreated(),b.getYearCreated());
        }

    }

}

//int result = a.getTitle().compareToIgnoreCase(b.getTitle());
//        return result != 0 ? result : Integer.compare(a.getYearCreated(), b.getYearCreated());
