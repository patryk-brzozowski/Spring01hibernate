package pl.coderslab.model;

import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @PESEL
    private String pesel;
    @Email
    private String email;

    @ManyToMany(mappedBy = "authors", fetch = FetchType.EAGER )
    private List<Book> books = new ArrayList<>();

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pesel='" + pesel + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
