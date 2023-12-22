class Sub implements Runnable{
  private int n;
  private int sum=1;
  public Sub(int a){
    n=a;
  }
  public void run(){
      for (int i =1;i<=n;i++){
          sum*=i;
      }
      System.out.println("1*2*...*"+n+"="+sum);
  }
}
public class class06{
    public static void main(String[] args){
        Sub sub1= new Sub(5);
        Sub sub2= new Sub(10);
        
        Thread thread1 = new Thread(sub1);
        Thread thread2 = new Thread(sub2);
        thread1.start();
        thread2.start();
    }
}
