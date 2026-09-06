/*
Create a Person class with name and age.
Store Person objects inside a HashSet.
Add two Person objects with same data.
Duplicate should be removed only if equals and hashCode are correctly overridden.

*/
import java.util.*;
class Person{
    String name;
    int age;
    String gender;
    Person(String name, int age,String gender){
        this.name=name;
        this.age=age;
        this.gender = gender;
    }
    public boolean equals(Object o){
        Person p = (Person) o;
        if(p.name.equals(this.name) && p.age==this.age){
            return true;
        } else {
            return false;
        }
    }
    public int hashCode(){
        int sum = 0;
        for(char c: this.name.toCharArray()){
            sum+=c;
        }
        return age+sum;
    }
    public String toString(){
        return this.name+" "+this.age;
    }
}
public class p7{
    public static void main (String[] args) {
        HashSet<Person> p = new HashSet<>();
        p.add(new Person("shivani",18,"F"));
        p.add(new Person("shivani",18,"F"));
        p.add(new Person("madhavi",40,"F"));
        p.add(new Person("Heema",48,"F"));
        p.add(new Person("Heema",40,"F"));
        System.out.println(p);
    }
}