class human{
    private int age;
    private String name;
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    

}
public class demo {
    public static void main(String[] args){
        human h=new human();
        h.setAge(19);
        h.setName("Manasa");
        System.out.println("Name: "+h.getName()+" Age: "+h.getAge());
    }
}
