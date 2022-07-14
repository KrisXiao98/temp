package Object.HomeWork.HomeWork09;

public class Test {
}

class Point{
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class LabelPoint extends Point{
    public LabelPoint(double x, double y){
        super(x, y);
    }
}