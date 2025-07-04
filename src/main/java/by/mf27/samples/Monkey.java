package by.mf27.samples;

public class Monkey {
    private String name;
    private static int age;

    public Monkey(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void sendMessage(String message, int asasas, boolean dsadas) {
        System.out.println(message);
    }

    private static int getAge() {
        return Monkey.age;
    }
}
