class add10 implements Runnable{
    private String speak;
    private int repeatCount;
    private long time;
    
    public add10(String speak,int count,long time) {
        this.speak = speak;
        this.repeatCount = count;
        this.time = time;
    }
    public void run(){
        for (int i = 1; i <= repeatCount; i++){
            System.out.println(speak+" "+i);
            
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
    }
}

public class class10 {
    public static void main(String[] args) {
        Thread add1 = new Thread(new add10("Hello",5,1000));
        Thread add2 = new Thread(new add10("Good bye",5,2500));

        add1.start();
        add2.start();
    }    
}
