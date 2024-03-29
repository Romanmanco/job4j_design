package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Identificator {
    @XmlAttribute
    private String id;

    public Identificator() {
    }

    public Identificator(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Identification{"
                + "id='" + id + '\''
                + '}';
    }
}
