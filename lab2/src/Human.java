import java.util.Comparator;

public class Human implements Comparable<Human> {
    private String name;
    private String surname;
    private int age;

    public Human(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public int compareTo(Human o) {
        return Integer.compare(this.age, o.age);
    }

    @Override
    public String toString() {
        return this.name + " " + this.surname + " " + this.age + " лет";
    }
}

class HumanComparatorByLastName implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getSurname().compareTo(o2.getSurname());
    }
}
