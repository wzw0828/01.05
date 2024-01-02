class Pig implements Runnable {
    public void run() {
        try {
            synchronized (this) {
                System.out.println("小豬看到大野狼在爬煙囪");
                System.out.println("就在壁爐上煮了一鍋水");

                for (int i = 2; i <= 10; i += 2) {
                    System.out.print(i + "分鐘 ");
                    Thread.sleep(2000); 
                }
                System.out.println();
                System.out.println("一鍋煮沸的熱水煮好了");

                notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Wolf implements Runnable {
    private Pig pigThread;

    public Wolf(Pig pigThread) {
        this.pigThread = pigThread;
    }

    public void run() {
        try {
            synchronized (pigThread) {
                System.out.println("大野狼對著第三隻小豬的房子吹氣");
                System.out.println("牠不停地吹氣又吹氣");
                System.out.println("還是不能把房子吹倒");
                System.out.println("大野狼非常的生氣");
                System.out.println("牠決定要從煙囪爬進小豬的家裡");

                pigThread.wait();

                for (int i = 3; i <= 15; i += 3) {
                    System.out.print(i + "分鐘 ");
                    Thread.sleep(3000); 
                }
                System.out.println();
                System.out.println("大野狼爬上煙囪了");

                System.out.println("大野狼從煙囪滑進房子裡");
                System.out.println("就被小豬煮好的水燙死了");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class class09 {
    public static void main(String[] args) {
        Pig pigThread = new Pig();
        Wolf wolfThread = new Wolf(pigThread);

        Thread t1 = new Thread(wolfThread); 
        Thread t2 = new Thread(pigThread);

        t1.start();
        t2.start();

        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
