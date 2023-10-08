import java.util.Collections;

public class Main {
    public static void main(String[] args) throws Exception {

        Minion minion1 = new Minion(15, "Mark");
        Minion minion2 = new Minion(21, "Roman");
        Minion minion3 = new Minion(33, "Andrew");
        Minion minion4 = new Minion(45, "Bob");
        Minion minion5 = new Minion(10, "Andy");
        Minion minion6 = new Minion(24, "Kevin");
        Minion minion7 = new Minion(4, "Anna");
        MinionList<Minion> minionList = new MinionList<>();

        minionList.addHead(minion2);
        System.out.println(minionList.size);
        for(Minion m : minionList) {
            System.out.println(m);
        }
        System.out.println();

        minionList.addHead(minion3);
        System.out.println(minionList.size);
        for(Minion m : minionList) {
            System.out.println(m);
        }
        System.out.println();

        minionList.addTail(minion4);
        System.out.println(minionList.size);
        for(Minion m : minionList) {
            System.out.println(m);
        }
        System.out.println();

        minionList.addTail(minion1);
        System.out.println(minionList.size);
        for(Minion m : minionList) {
            System.out.println(m);
        }
        System.out.println();

        int index = 4;
        System.out.printf("Миньон под %d индексом: " + minionList.getItem(index) + "\n", index);
        System.out.println();

        minionList.remove(minion2);
        minionList.remove(minion1);
        minionList.remove(minion4);
        System.out.println(minionList.size);
        for(Minion m : minionList) {
            System.out.println(m);
        }
        System.out.println();

        minionList.set(minion3, minion5);

        System.out.println(minionList.size);
        for(Minion m : minionList) {
            System.out.println(m);
        }

        /////////////////////////////////////////////////////////////////////////////
        /*MinionStack<Minion> minionStack = new MinionStack<>();
        minionStack.push(minion1);
        minionStack.push(minion2);
        minionStack.push(minion3);
        minionStack.display();
        System.out.println();

        minionStack.clear();
        minionStack.display();

        minionStack.pop();
        System.out.println("Новая вершина стека: " + minionStack.peek() + "\n");
        minionStack.display();
        System.out.println();

        minionStack.pop();
        System.out.println("Новая вершина стека: " + minionStack.peek() + "\n");
        minionStack.display();
        System.out.println();

        minionStack.pop();
        System.out.println("Новая вершина стека: " + minionStack.peek() + "\n");
        System.out.println(minionStack.isEmpty());
        minionStack.display();
        System.out.println();*/

        //minionStack.push(minion4);
    }
}
