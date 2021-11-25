package utez.edu.mx.cine.model.Categoria;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Categoria")
@XmlAccessorType(XmlAccessType.FIELD)
public class Categoria {
    @XmlElement
    private int id;
    @XmlElement
    private String name;

    public Categoria() {
    }

    public Categoria(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
