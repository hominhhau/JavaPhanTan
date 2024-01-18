package HoMinhHau_Lab1.Exercise3;

public class Test {
    public static void main(String[] args) {

        BankAccount bank = new BankAccount();

        Thread nạpTien = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0 ; i< 10 ; i++) {  // Lặp vô hạn để thực hiện nạp tiền liên tục
                    bank.napTien(100);
                    System.out.println("số dư sau khi nạp: " + bank.getSoDu());

                }
            }
        });
        Thread rutTien = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0 ; i< 10 ; i++){  // Lặp vô hạn để thực hiện rút tiền liên tục
                    bank.rutTien(100);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("số dư sau khi rut: " + bank.getSoDu());

                }
            }
        });

        nạpTien.start();  // Khởi động luồng nạp tiền
        rutTien.start();  // Khởi động luồng rút tiền
    }
}
