package by.mf27.samples;

public final class Player {
    private final String name;
    private int age;
    private boolean isMale;

    Player() {
        this.name = "sosiska";
        this.age = 0;
        this.isMale = true;
    }

    Player(final String name, final int age, final boolean isMale) {
        this.name = name;
        this.age = age;
        this.isMale = isMale;
    }

    public void allah() {
        System.out.println(name + " был выбран чтобы стать аллахом на: " + age + " лет.");
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isMale=" + isMale +
                '}';
    }
}
