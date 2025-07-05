package by.mf27.samples;

import by.mf27.annotations.DontAnalyze;

public final class Player {
    private final String name;
    @DontAnalyze
    private int age;
    @DontAnalyze
    private boolean isMale;

    public Player() {
        this.name = "sosiska";
        this.age = 0;
        this.isMale = true;
    }

    public Player(final String name, final int age, final boolean isMale) {
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
