public class Philosopher implements Runnable
{
    private Fork rightFork;
    private Fork leftFork;


    Philosopher(Fork rightFork, Fork leftFork)
    {
        this.rightFork = rightFork;
        this.leftFork = leftFork;
    }

    public Fork getRightFork()
    {
        return rightFork;
    }

    public Fork getLeftFork()
    {
        return leftFork;
    }

    public void setRightFork(Fork rightFork)
    {
        this.rightFork = rightFork;
    }

    public void setLeftFork(Fork leftFork)
    {
        this.leftFork = leftFork;
    }

    private void think() throws InterruptedException
    {
        System.out.println(Thread.currentThread().getName() + " is thinking");
        Thread.sleep((int) (Math.random() * 100));
    }

    private void eat() throws InterruptedException
    {
        synchronized (leftFork)
        {
            System.out.println(Thread.currentThread().getName() + " picked up left fork");
            synchronized (rightFork)
            {
                System.out.println(Thread.currentThread().getName() + " picked up right fork and now is eating");
                Thread.sleep((int) (Math.random() * 100));
                System.out.println(Thread.currentThread().getName() + " stopped eating and put down right fork");
            }
            System.out.println(Thread.currentThread().getName() + " put down left fork");
        }
    }

    @Override
    public void run()
    {
        try
        {
            while(true)
            {
                think();
                eat();
            }
        }
        catch (InterruptedException ie)
        {
            Thread.currentThread().interrupt();
        }
    }
}
