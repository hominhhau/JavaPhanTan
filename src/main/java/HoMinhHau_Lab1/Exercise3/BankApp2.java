package HoMinhHau_Lab1.Exercise3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class BankApp2 {
    private static BankAccount bankAcc = new BankAccount();

    public static void main(String[] args) {
        Callable<Integer> task = () -> {
            return bankAcc.rutTien(100);
        };
        List<Future<Integer>> fus = new ArrayList<>();

        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            Future<Integer> fu = executor.submit(task);
            fus.add(fu);
        }
        fus.add(executor.submit(task));
        int money = fus.stream().mapToInt(fu ->{
            try {
                return fu.get(6000, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(0);
            }
            return 0;
        }).sum();
        System.out.println("So dư " + bankAcc.getSoDu());
        System.out.println("Money"+ money);


        executor.shutdown();


    }


}
