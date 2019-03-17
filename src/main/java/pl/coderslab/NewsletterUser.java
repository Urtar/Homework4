package pl.coderslab;

public class NewsletterUser {
    Integer id; // user Id
    String email; // email
    String name; // name + surname

    public NewsletterUser() {
    }

    public NewsletterUser(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
