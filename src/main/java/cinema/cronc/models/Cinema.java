package cinema.cronc.models;

import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String address;


    @OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL)
    private List<Session> sessions;
// Constructor

    public Cinema() {
    }

    public Cinema(@NotNull String address) {
        this.address = address;
    }

    // Get & Set



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
