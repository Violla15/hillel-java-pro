package ua.ithillel.lectures.lecture_8.hashmap;

public class Employee {
    private int id;


    public int getId() {
        return id;
    }

    public Employee(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        Employee other = (Employee) o;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                '}';
    }
}


