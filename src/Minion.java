public class Minion implements Comparable<Minion>{
    private int age;
    private String name;
    private static int COUNT_MINIONS = 2;
    private int ID;
    Minion(int age, String name) {
        setAge(age);
        setName(name);
        this.ID = this.COUNT_MINIONS - 1;
        this.COUNT_MINIONS++;

    }
    public int getAge() { return age; }
    private void setAge(int age) { this.age = age; }

    public String getName() { return name; }
    private void setName(String name) { this.name = name; }
    public int getID() { return ID; }
    private void setID(int ID) { this.ID = ID; }

    public static int getCountMinions() { return COUNT_MINIONS; }

    private static void setCountMinions(int countMinions) { COUNT_MINIONS = countMinions; }

    @Override
    public String toString() {
        return "Minion: id = " + ID + ", age = " + age +", name = " + name;
    }

    @Override
    public int compareTo(Minion m) {
        return this.ID - m.getID();
    }
}
