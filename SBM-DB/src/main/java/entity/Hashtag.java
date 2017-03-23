package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Hashtag {

    @Id
    @GeneratedValue
    private Long id;
    private String label;
    private Long firstUsed;
    private Long lastUsed;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Long getFirstUsed() {
        return firstUsed;
    }

    public void setFirstUsed(Long firstUsed) {
        this.firstUsed = firstUsed;
    }

    public Long getLastUsed() {
        return lastUsed;
    }

    public void setLastUsed(Long lastUsed) {
        this.lastUsed = lastUsed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
