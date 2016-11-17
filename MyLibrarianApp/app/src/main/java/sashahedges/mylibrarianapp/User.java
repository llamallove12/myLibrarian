package sashahedges.mylibrarianapp;

import java.util.List;
/**
 * Created by brandonvowell on 11/16/16.
 */

public class User {
    private int id;
    private String name;
    private String password;
    private String email;
    private String bookList;
    private String genreList;

    public User() {}

    public User(int id, String name, String email, String password, String bL, String gL) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.bookList = bL;
        this.genreList = gL;
    }

    public void setUserId(int id) { this.id = id; }
    public void setUserName(String name) { this.name = name; }
    public void setUserEmail(String email) { this.email = email; }
    public void setUserPassword(String password) { this.password = password; }
    public void setUserBookList(String bL) { this.bookList = bL; }
    public void setUserGenreList(String gL) { this.genreList = gL; }

    public int getUserId() { return id; }
    public String getUserName() { return name; }
    public String getUserEmail() { return email; }
    public String getUserPassword() { return password; }
    public String getUserBookList() { return bookList; }
    public String getUserGenreList() { return genreList; }

}
