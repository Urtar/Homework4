package pl.coderslab;

public class GuestBook {
    private Integer id;
    private String description;

    @Override
    public String toString() {
        return "Wpis numer: " + id + " Treść: " + description + "<br>";
    }

    public GuestBook() {
    }

    public GuestBook(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
