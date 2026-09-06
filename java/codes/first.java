import java.util.Scanner;
class first{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        String text1=sc.nextLine();
        String text2=sc.nextLine();
        System.out.println(text1);
        System.out.println(text2);
        // String t1[text1.length]=new String();
        String[] t1=text1.split("");
        // String x=text1.split("");
        String[] t2=text2.split("");
        // System.out.println(t2);
        int count=0;
        for (String x: t1){
            System.out.println(x);
            for (String y: t2){
                System.out.println(y);
                if (x==y){
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
        
    }
}