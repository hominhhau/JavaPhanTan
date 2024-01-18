package HoMinhHau_Lab1.Exercise3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BankApp {
    private static BankAccount bankAcc = new BankAccount();
    public static void main(String[] args) {
        Runnable task = () ->{
            bankAcc.napTien(100);

        };
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executor.submit(task);
        }
        executor.shutdown();
        while(!executor.isTerminated()) {
//            System.out.println("Waiting for all threads to finish...");
        }
        System.out.println("Số dư sau khi nạp: " + bankAcc.getSoDu());


    }
}
