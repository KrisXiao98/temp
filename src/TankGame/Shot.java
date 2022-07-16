package TankGame;

public class Shot implements Runnable {
    //实现子弹的射击

    int x;
    int y;
    int direction = 0;
    int speed = 5;
    boolean isLive = true;//字段是否还存在

    public Shot(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public void run() {
        //不断的改变子弹的轨迹
        while (true){
            //线程休眠，让子弹重画出来
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            switch (direction){
                case 0:
                    y -= speed;
                    break;
                case 1:
                    x += speed;
                    break;
                case 2:
                    y += speed;
                    break;
                case 3:
                    x -= speed;
                    break;
            }
            //如果子弹移动到边界，就销毁
            if (!(x>=0 && x<= 1000 && y>=0 && y<= 750)){
                isLive = false;
                break;
            }
        }
    }
}
