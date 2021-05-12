package cinema.cronc.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;

@Entity
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String name;

    @Column
    private double rate;

    @Column
    private int age;

    @Column
    private String genre;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column
    private Date release;

    @Column
    private String posterUrl;

    @Column
    private String trailerUrl;

    @Column
    private String description;

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    private List<Session> sessions;

//    Constructor

    public Film() {
    }

    public Film(@NotNull String name, int rate, int age, String genre, Date release, String posterUrl, String trailerUrl, String description, List<Session> sessions) {
        this.name = name;
        this.rate = rate;
        this.age = age;
        this.genre = genre;
        this.release = release;
        this.posterUrl = posterUrl;
        this.trailerUrl = trailerUrl;
        this.description = description;
        this.sessions = sessions;
    }

    public Film(@NotNull String name) {
        this.name = name;
    }


    //    Get & Set


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getRelease() {
        return release;
    }

    public void setRelease(Date release) {
        this.release = release;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
