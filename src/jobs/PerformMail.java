package jobs;

public abstract class PerformMail extends Thread{

    public abstract void sentEmailThread();

    @Override
    public void run(){
        sentEmailThread();
    }
}
