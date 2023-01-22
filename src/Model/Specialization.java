package Model;

import java.io.Serializable;

public class Specialization implements Serializable {

    private static final long serialVersionUID = -455521983826917088L;

    String name;

    public Specialization() {

        this.name = "";
    }

    public Specialization(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{ Specialization - " +
                "name: " + name + " }";
    }

    @Override
    public boolean equals(Object obj) {
        Specialization other = (Specialization) obj;
        if (other == null) {
            return false;
        } else {
            return this.getName().equals(other.getName());
        }
    }
}