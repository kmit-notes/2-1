public class multiply implements Runnable{
    public void run(){
        for (int i=0;i<20;i++){
            System.out.println("3 * "+i+" = "+(3*i));
        }
    }
}
