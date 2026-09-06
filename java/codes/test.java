//single-level inheritance
// class parentClass{
//     int a=100;
// }
// class childClass extends parentClass{
//     void show(){
//         System.out.println("The value of 'a' is: "+a);
//     }
// }

// public class test {
//     public static void main(String[] args){
//         childClass c=new childClass();
//     // c.show();
//         c.show();
//     }  
// }

//multi-level inheritance 
// class parentClass{
//     int a=100;
// }
// class childClass extends parentClass{
//     int b=200;
// }
// class childChildClass extends childClass{
//     void show(){
//         System.out.println("The value of 'a' is: "+a);
//         System.out.println("The value of 'b' is: "+b);

//     }
// }
// public class test {
//     public static void main(String[] args){
//         childChildClass c=new childChildClass();
//     // c.show();
//         c.show();
//     }  
// }


//hierarchical inheritance
// class parentClass{
//     int a=100;
// }
// class childClass extends parentClass{
//     // int b=200;
//     void show(){
//         System.out.println("Inside the childClass.");
//         System.out.println("The value of 'a' is: "+a);
//     }
// }
// class childChildToo extends childClass{
//     void show(){
//         System.out.println("Inside the childClassToo!");
//         System.out.println("The value of 'a' is: "+a);
//     }
// }
// public class test {
//     public static void main(String[] args){
//         childClass c1=new childClass();
//         childChildToo c2=new childChildToo();
//     // c.show();
//         c1.show();
//         c2.show();
//     }  
// }

//hybrid inheritance

// data members
// class parentClass{
//     int a=100;
// }
// class childClass extends parentClass{
//     int a=200;
//     void show(){
//         System.out.println("The value of 'a' of Parent class is: "+super.a);
//         System.out.println("The value of 'a' of Child class is: "+a);

//     }
// }
// public class test {
//     public static void main(String[] args){
//         childClass c=new childClass();
//     // c.show();
//         c.show();
//     }  
// }

//methods
class parentClass{
    int a=100;
    void show(){
        System.out.println("Inside the Parent class");
        System.out.println("The value of 'a' of Parent class is: "+a);
    }
}
class childClass extends parentClass{
    int a=200;
    void show(){
        System.out.println("Inside the Child class");
        System.out.println("The value of 'a' of Child class is: "+a);
        System.out.println("");
        super.show();
    }
}
public class test {
    public static void main(String[] args){
        childClass c=new childClass();
    // c.show();
        c.show();
    }  
}