import java.util.*;;
public class water_trapping {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter n");
        int n=sc.nextInt();
        int heights[]=new int[n];
        System.out.println("enter heights");
        for(int i=0;i<n;i++){
            heights[i]=sc.nextInt();
    }
    int lm[]=new int[n];
    lm[0]=heights[0];
    int rm[]=new int[n];
    rm[n-1]=heights[n-1];
    for(int i=1;i<n;i++){
        lm[i]=Math.max(lm[i-1], heights[i]);

    }
    for(int i=n-2;i>=0;i--){
        rm[i]=Math.max(rm[i+1], heights[i]);

    }
   for(int i=0;i<n;i++){
            System.out.print(rm[i]+"");
    }
    System.out.println();
    for(int i=0;i<n;i++){
        System.out.print(lm[i]+"");

}
int c=0;
for(int i=0;i<n;i++){
    c+=Math.min(rm[i],lm[i])-heights[i];
}
System.out.println("\n"+c);  
}
}
