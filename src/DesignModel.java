public class DesignModel {
    public static void main(String[] args) {
        System.out.println(SingleTon.n);
    }
}

class SingleTon{
    private static SingleTon cat;
    private String name;
    public static int n = 1;

    private SingleTon(String s){
        this.name = s;
    }
    public static SingleTon getInstance(){
        System.out.println("静态方法被调用");
        if (cat == null){
            cat = new SingleTon("TOM猫");
        }
        return cat;
    }

}