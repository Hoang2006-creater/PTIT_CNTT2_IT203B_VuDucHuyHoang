package BaiTap.Lesson5.Entity;

public class Doctor {
    private Integer id;
    private String name;
    private String specialty;

    public Doctor() {
    }

    public Doctor(Integer id, String name, String specialty) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
    }

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

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + specialty;
    }
}
