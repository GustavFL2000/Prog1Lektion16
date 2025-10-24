package opgave02;

public class Person {
    private String name;
    private String title;
    private boolean senior;

    public Person() {
        this.name = "John Doe";
        this.title = "Mr.";
        this.senior = false;
    }

    public Person(String name, String title, boolean senior) {
        this.name = name;
        this.title = title;
        this.senior = senior;
    }

    @Override
    public String toString() {
        String result = title + " " + name;
        if (senior) {
            result += " (senior)";
        }
        return result;
    }
}
