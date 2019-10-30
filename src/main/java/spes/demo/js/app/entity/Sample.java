package spes.demo.js.app.entity;

import org.locationtech.jts.geom.Geometry;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sample")
public class Sample {
    @Id
    @GeneratedValue
    private Long id;
    private Geometry geom;

    public Sample() {
    }

    public Sample(Long id, Geometry geom) {
        this.id = id;
        this.geom = geom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Geometry getGeom() {
        return geom;
    }

    public void setGeom(Geometry geom) {
        this.geom = geom;
    }

    @Override
    public String toString() {
        return "Sample{" +
                "id=" + id +
                ", geom=" + geom +
                '}';
    }
}
