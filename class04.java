class Add implements Runnable{
  private int n;
  private int sum=0;
  public Add(int a){
    n=a;
  }
  public void run(){
      for (int i =1;i<=n;i++){
          sum+=i;
      }
      System.out.println("1+2+...+"+n+"="+sum);
  }
}
public class class04{
    public static void main(String[] args){
        Add add1= new Add(5);
        Add add2= new Add(10);
        
        Thread thread1 = new Thread(add1);
        Thread thread2 = new Thread(add2);
        thread1.start();
        thread2.start();
    }
}
