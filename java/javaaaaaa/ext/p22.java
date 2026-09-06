public class p22 {
    public static void main(String[] args) {
        int n=500;
        int ld=n%10;
        int fd=0;
        int y=n;
        while(n>10){
            fd=n/10;
            n/=10;
        }
        System.out.println(fd);
        int x=fd*10+ld;
        if(y%x == 0){
            System.out.println("gapful");
        }
        else{
            System.out.println("not gapful");
        }

    }
    
}
