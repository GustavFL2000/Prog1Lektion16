package opgave01;

public class Person {
    private String name;
    private String title;
    private boolean senior;

    public Person(){
        this.name = "John Doe";
        this.title = "Mr.";
        this.senior = false;
    }

    public Person(String name, String title, boolean senior) {
        this.name = name;
        this.title = title;
        this.senior = senior;

    }

    public String toString() {
        String string = title + " " + name;
        if (senior) {
            string += " (senior)";
        }
        return string;
    }

}
