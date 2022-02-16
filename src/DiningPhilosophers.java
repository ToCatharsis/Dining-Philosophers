import java.util.ArrayList;

public class DiningPhilosophers
{
    public static void main(String[] args)
    {
        Fork fork1 = new Fork(1);
        Fork fork2 = new Fork(2);
        Fork fork3 = new Fork(3);
        Fork fork4 = new Fork(4);
        Fork fork5 = new Fork(5);

        Philosopher philosopher1 = new Philosopher(fork1, fork2);
        Philosopher philosopher2 = new Philosopher(fork2, fork3);
        Philosopher philosopher3 = new Philosopher(fork3, fork4);
        Philosopher philosopher4 = new Philosopher(fork4, fork5);
        Philosopher philosopher5 = new Philosopher(fork1, fork5); // this isn't natural, but allows avoiding deadlocks

        String name1 = "Socrates";
        String name2 = "Plato";
        String name3 = "Aristotle";
        String name4 = "Epicurus";
        String name5 = "Zeno";

        ArrayList<Philosopher> philosophers = new ArrayList<>();
        philosophers.add(philosopher1);
        philosophers.add(philosopher2);
        philosophers.add(philosopher3);
        philosophers.add(philosopher4);
        philosophers.add(philosopher5);

        ArrayList<String> names = new ArrayList<>();
        names.add(name1);
        names.add(name2);
        names.add(name3);
        names.add(name4);
        names.add(name5);

        for (int i=0; i<philosophers.size(); i++)
        {
            Thread thread = new Thread(philosophers.get(i), names.get(i));
            thread.start();
        }
    }
}
