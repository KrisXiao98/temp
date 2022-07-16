package IODemo.ChuliLiuDemo;


/*
这里就是自己做的一个处理流，使用修饰器设计模式来实现
 */
public class BufferedReader_ extends Reader_{
    private Reader_ reader_;

    public void fileReader(){
        //二次封装
        this.reader_.fileReader();
    }

    public BufferedReader_(Reader_ reader_) {
        this.reader_ = reader_;
    }

    public void fileReadExpand(int num){
        System.out.println("自主实现fileRead的功能拓展....");
    }
}

class Test{
    public static void main(String[] args) {
        BufferedReader_ bufferedReader_ = new BufferedReader_(new FileReader_());
        bufferedReader_.fileReader();
    }
}
