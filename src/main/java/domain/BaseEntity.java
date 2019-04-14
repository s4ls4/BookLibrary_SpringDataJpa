package domain;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public class BaseEntity<ID> implements Serializable{
    private ID id;

    /**
     * Getter for the id
     * @return
     */
    @Id
    public ID getId() {
        return id;
    }

    /**
     * Setter for the id
     * @param id
     */
    public void setId(ID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                '}';
    }
}
