package ch02;

public class PersonJava {
    private final String name;
    private boolean married;

    public PersonJava(final String name, final boolean married) {
        this.name = name;
        this.married = married;
    }

    public static void main(final String[] args) {
        final Person person = new Person("Alice", false);
        System.out.println(person.getName());
        System.out.println(person.isMarried());
    }

    public String getName() {
        return name;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(final boolean married) {
        this.married = married;
    }
}
