package main.java.domainmodel;

public class Movie {
    private String title;
    private String director;
    private int yearCreated;
    private boolean isInColor;
    private int lengthInMinutes;
    private String genre;

    //Constructor of movie
    public Movie (String title, String director, int yearCreated, boolean isInColor, int lengthInMinutes, String genre){
        this.title = title;
        this.director = director;
        this.yearCreated = yearCreated;
        this.isInColor = isInColor;
        this.lengthInMinutes = lengthInMinutes;
        this.genre = genre;
    }
//------- GETTER & SETTER -------
    public String getTitle(){
        return title;
    }
    public void setTitle (String title){
        this.title = title;
    }

    public String getDirector(){
        return director;
    }
    public void setDirector(String director){
        this.director = director;
    }

    public int getYearCreated(){
        return yearCreated;
    }
    public void setYearCreated(int yearCreated){
        this.yearCreated = yearCreated;
    }

    public boolean getIsInColor(){
        return isInColor;
    }
    public void setIsInColor(boolean isInColor){
        this.isInColor = isInColor;
    }

    public int getLengthInMinutes(){
        return lengthInMinutes;
    }
    public void setLengthInMinutes(int lengthInMinutes){
        this.lengthInMinutes = lengthInMinutes;
    }

    public String getGenre(){
        return genre;
    }
    public void setGenre(String genre){
        this.genre = genre;
    }

    //------- TO STRING --------
    // A toString to print out to the console in a nice order.
    @Override
    public String toString(){
        return  "\n\nTitle: " + this.title +
                "\nDirector: " + this.director  +
                "\nYear: " + this.yearCreated +
                "\nIn color: " + (this.isInColor ? "Yes" : "No") +
                "\nLength: " + this.lengthInMinutes  +
                "\nGenre: " + this.genre;
    }
    // A toString, so we can write to file in correct format for when we need to read file.
    public String toStringToFile() {
        return  this.title + ";" +
                this.director  + ";" +
                this.yearCreated + ";" +
                (this.isInColor ? "true" : "false") + ";" +
                this.lengthInMinutes  + ";" +
                this.genre;

    }
}
