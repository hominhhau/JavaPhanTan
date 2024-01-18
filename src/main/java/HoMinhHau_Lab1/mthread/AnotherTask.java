package HoMinhHau_Lab1.mthread;

public class AnotherTask extends Thread{

    private String taskName;
    private int count;

    public AnotherTask(String taskName, int count) {
        this.taskName = taskName;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println(taskName + "#" + i);
        }

    }
}
