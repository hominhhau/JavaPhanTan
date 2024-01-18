package HoMinhHau_Lab1.Exercise3;

public class BankAccount {
    public BankAccount(int soDu, int tienGoi, int tienRut) {
        this.soDu = soDu;
        this.tienGoi = tienGoi;
        this.tienRut = tienRut;
    }

    public BankAccount(int tienGoi) {
        this.tienGoi = tienGoi;
    }

    public BankAccount() {
    }

    public int getSoDu() {
        return soDu;
    }

    public void setSoDu(int soDu) {
        this.soDu = soDu;
    }

    public int getTienGoi() {
        return tienGoi;
    }

    public void setTienGoi(int tienGoi) {
        this.tienGoi = tienGoi;
    }

    public int getTienRut() {
        return tienRut;
    }

    public void setTienRut(int tienRut) {
        this.tienRut = tienRut;
    }

    public synchronized void napTien(int tienGoi) {
        // Nếu số dư lớn hơn hoặc bằng 100000, không cho gửi nữa
        if (soDu < 100000) {
            soDu += tienGoi;
            notifyAll();

        } else {
            System.out.println("Số dư không được vượt quá 100000");
        }
    }

    public synchronized int rutTien(int tienRut) {
        // Nếu không đủ tiền để rút
        if (soDu < tienRut) {
            throw new RuntimeException("Số dư không đủ để rút");
        } else {
            while (soDu < tienRut) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            soDu -= tienRut;

            // Thông báo cho các luồng khác về sự thay đổi
            notifyAll();

        }

        return soDu;
    }


    @Override
    public String toString() {
        return "BankAccount{" +
                "soDu=" + soDu +
                ", tienGoi=" + tienGoi +
                ", tienRut=" + tienRut +
                '}';
    }

    private int soDu;
    private int tienGoi;
    private int tienRut;


}
