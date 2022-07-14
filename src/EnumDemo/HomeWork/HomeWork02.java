package EnumDemo.HomeWork;

public class HomeWork02 {
    public static void main(String[] args) {
        Frock frock = new Frock();
        Frock frock1 = new Frock();
        Frock frock2 = new Frock();
        System.out.println(frock.getSerialNumber());
        System.out.println(frock1.getSerialNumber());
        System.out.println(frock2.getSerialNumber());
    }
}


class Frock{
    private static int currentNum = 100000;
    @SuppressWarnings({"all"})
    private int serialNumber;

    public Frock() {
        serialNumber = getNextNum();
    }

    public static int  getNextNum(){
        currentNum += 100;
        return currentNum;
    }

    public int getSerialNumber() {
        return serialNumber;
    }
}