package InnerClass.MemberInnerClass;

public class Demo {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner01 inner01 = outer.new Inner01();
        inner01.showInfo();
    }
}

class Outer {
    private int n = 99;
    public String name = "Kris";

    public class Inner01 {
        private int n = 10;
        public void showInfo() {
            System.out.println("n=" + Outer.this.n);
            System.out.println("name=" + name);
        }
    }

}