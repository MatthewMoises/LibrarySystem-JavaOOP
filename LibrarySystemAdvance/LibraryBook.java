package OPP_BIG_PROJECTS.LibrarySystemAdvance;

public class LibraryBook {

    String title;
    String author;
    int year;

    public LibraryBook(String title, String author, int year){
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String toString(){
        return "" + title + " by " + author + "(" + year + ")";
    }
}
