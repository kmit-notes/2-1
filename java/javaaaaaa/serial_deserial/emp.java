/*
Read the data from the file and if the rating is greater than 4 increase the salary by 20% .

1,2000,sachin,water works,4.5
11,3000,sachin,water works,4.2
12,4000,sachin,water works,4.0
14,2100,sachin,water works,3.5
11,2900,sachin,water works,2.5


*/


import java.io.*;
class Employee implements Serializable{
    
    int empId;
    String name;
    float salary;
    float rating;
    transient String dept;
    Employee(int e,String anme,float s,float r)
    {
    empId=e;
    this.name=name;
    salary=s;
    rating=r;
    dept="Water works";

}     public String toString(){
        return empId + " "+name+ " "+salary;
     }
}

