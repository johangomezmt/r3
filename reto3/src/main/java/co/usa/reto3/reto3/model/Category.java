package co.usa.reto3.reto3.model;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import co.usa.reto3.reto3.model.Cabin;

@Entity
@Table(name="Category")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "category")
    public List<Cabin>cabins;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Cabin> getCabins() {
        return cabins;
    }

    public void setCabins(List<Cabin> cabins) {
        this.cabins = cabins;
    }
}