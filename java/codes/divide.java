public class divide implements Runnable{
    public void run(){
        for (int i=1;i<20;i++){
            System.out.println("100 / "+i+" = "+(100/i));
        }
    }
}
