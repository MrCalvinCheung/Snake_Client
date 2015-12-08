package SDK;

import java.sql.Date;


/**
 * Template from GH
 * variables that is needed to get users
 */
//
public class User {

    //creating variables
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Date created;
    private String status;
    private String email;
    private String type;

    public User (int id, String firstName, String lastName, String email, String username, String password, Date created, String status, String type ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.created = created;
        this.status = status;
        this.type = type;
    }

    /**
     * User class to all variables most of isn't used in my program
     */
    public User () {}

    //creating get and set method for all the variables, so they can be used by other classes

    /**
     * This is a method getid
     * @return id of a user
     */
    public int getId() {
        return id;
    }

    /**
     *  sets an id to a user
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *   this is a to getusername
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * set method for username
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    /**
     * this method is called to setpassword
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}