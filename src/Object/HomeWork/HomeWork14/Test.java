package Object.HomeWork.HomeWork14;

public class Test {
    public static void main(String[] args) {
        System.out.println(Color.RED);
        Color[] colors = Color.values();
        for (Color color : colors) {
            switch (color) {
                case RED:
                    System.out.println("RED");
                    break;
                case BLACK:
                    System.out.println("BLACK");
                    break;
                case BLUE:
                    System.out.println("BLUE");
                    break;
                case GREEN:
                    System.out.println("GREEN");
                    break;
                case YELLOW:
                    System.out.println("YELLOW");
                    break;
                default:
                    System.out.println("OTHER");
                    break;
            }
        }
        TestA.bubble(new int[]{1, 2, 3, 4, 4444, 555, 1, 2, 3, 4});
    }
}

enum Color implements IA {
    RED(255, 0, 0), BLUE(0, 0, 255),
    BLACK(0, 0, 0), YELLOW(255, 255, 0),
    GREEN(0, 255, 0);
    private int redValue;
    private int greenValue;
    private int blueValue;

    Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    @Override
    public void show() {
        System.out.println("当前三属性的值为" + getRedValue() + getGreenValue() + getBlueValue() + "");
    }

    public int getRedValue() {
        return redValue;
    }

    public int getGreenValue() {
        return greenValue;
    }

    public int getBlueValue() {
        return blueValue;
    }

    @Override
    public String toString() {
        return this.name() +
                " redValue=" + redValue +
                ", greenValue=" + greenValue +
                ", blueValue=" + blueValue;
    }
}

interface IA {
    void show();
}

class TestA {
    public static void bubble(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                int temp = array[j];
                if (array[j] > array[j + 1]) {
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}