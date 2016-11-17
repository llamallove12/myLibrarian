package sashahedges.mylibrarianapp;

/**
 * Created by brandonvowell on 11/16/16.
 */

public class Book {
    private int id;
    private String title;
    private String genre;
    private String description;
    private String author;
    private int pageCount;
    private int rating;
    // Picture?

    public Book() {}

    public Book(int id, String title, String genre, String des, String author, int pc, int rating) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.description = des;
        this.author = author;
        this.pageCount = pc;
        this.rating = rating;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void setDescription(String description) { this.description = description; }
    public void setAuthor(String author) { this.author = author; }
    public void setPageCount(int pc) { this.pageCount = pc; }
    public void setRating(int rating) { this.rating = rating; }

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getGenre() {
        return genre;
    }
    public String getDescription() { return description; }
    public String getAuthor() { return author; }
    public int getPageCount() { return pageCount; }
    public int getRating() { return rating; }

}
