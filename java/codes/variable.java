public class variable {
    void values(int...list){
        System.out.println("The length of the list is: "+list.length);
        System.out.println("The elements of list are: ");
        for (int i=0;i<list.length;i++){
            System.out.print(list[i]+" ");
        }
    }
    public static void main(String[] args) {
        variable v=new variable();
        v.values(1,2,3,4,45,65);
    }
}
