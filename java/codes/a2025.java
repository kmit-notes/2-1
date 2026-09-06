import java.util.*;

class a2025{
    public static void main(String[] args){
        // Set<Integer> s=new HashSet<Integer>();
        // s.add(2);
        // s.add(3);
        // s.add(1);
        // s.add(2);
        // s.add(3);
        // s.add(3);
        // s.add(1);
        // s.add(2);
        // s.add(11);
        // s.add(16);
        // System.out.println(s);
        // // for (Object i:s){
        // //     System.out.println("Hello "+i);
        // // }
        // Iterator it=s.iterator();
        // while(it.hasNext()){
        //     Object x=it.next();
        //     System.out.println(x);
        //     s.remove(x);
        // }
        // System.out.println(s);
        // LinkedHashSet<Integer> s=new LinkedHashSet<Integer>();
        // s.add(2);
        // s.add(3);
        // s.add(1);
        // s.add(2);
        // s.add(3);
        // s.add(3);
        // s.add(1);
        // s.add(2);
        // s.add(11);
        // s.add(16);
        // System.out.println(s);
        // // for (Object i:s){
        // //     System.out.println("Hello "+i);
        // // }
        // // Iterator it=s.iterator();
        // // while(it.hasNext()){
        // //     Object x=it.next();
        // //     System.out.println(x);
        // //     // s.remove(x);
        // // }
        // // System.out.println(s);
        // // for (int i=0;i<s.length;i++){
        // //     System.out.println(s[i]);
        // // }
        // s.removeAll();
        // System.out.println(s);
        Set<Integer> s=new HashSet<Integer>();
        s.add(10);
        s.add(22);
        s.add(9);
        s.add(3);
        s.add(15);
        s.add(18);
        s.add(26);
        s.add(6);
        s.add(12);
        s.add(20);
        s.add(11);
        s.add(19);
        s.add(13);
        s.add(4);
        s.add(8);
        System.out.println(s);
        
        Set<Integer> d=new HashSet<Integer>();
        d.add(2);
        d.add(32);
        d.add(14);
        d.add(29);
        d.add(16);
        d.add(414);
        d.add(13);
        d.add(19);
        d.add(11);
        d.add(20);
        d.add(8);
        d.add(33);
        System.out.println(d);
        
        Set<Integer> b=new HashSet<Integer>();
        b.add(46);
        b.add(44);
        b.add(42);
        b.add(3);
        b.add(1);
        b.add(4);
        b.add(13);
        b.add(414);
        b.add(41);
        b.add(43);
        b.add(28);
        System.out.println(b);
        
        Set<Integer> all=new HashSet<Integer>();
        
        all.addAll(s);
        all.addAll(d);
        all.addAll(b);
        
        System.out.println("Union of s,b,d: "+all);
        
        Set<Integer> inter1=new HashSet<Integer>(d);
        inter1.retainAll(s);
        System.out.println("Intersection of s,d: "+inter1);
        
        Set<Integer> inter2=new HashSet<Integer>(d);
        inter2.retainAll(b);
        System.out.println("Intersection of d,b: "+inter2);

        inter1.removeAll(inter2);

        System.out.println(inter1);
        
        
    }
}