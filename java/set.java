import java.util.*;
class set{
    public static void main(String[] args){
        Set<Integer> s= new HashSet<Integer>();
        s.add(10);
        s.add(20);
        s.add(30);
        s.add(10);
        System.out.println(s);
        
        for(int n:s){
            System.out.println("Hello "+n);
        }
        s.forEach(n -> { System.out.println("Helloooo "+n);});
        
        Set <Integer>s1=new HashSet<Integer>();
        s1.add(10);
        s1.add(10);
        s1.add(30);
        
        //s1.forEach(n -> { System.out.println("Helloooo "+n);});
        //for(Object n:s1){
        //    System.out.println("Hello "+n);
        //}
        
        Iterator <Integer> it=s.iterator();
        System.out.println();
        while(it.hasNext()){
            int x=it.next();
            
            System.out.println(x);
        }
        SortedSet<Integer> ss= new TreeSet<Integer>(s);
        System.out.println(ss);
            // List<Integer> temp=new ArrayList<>(s);
            // s.clear();
            // System.out.println();
            // for(int n:temp){
            //     s.add(n+5);
            // }
            // System.out.println(s);
            
        
        LinkedHashSet<Integer> s2= new LinkedHashSet<Integer>();
        s2.add(10);
        s2.add(70);
        s2.add(30);
        s2.add(70);
        System.out.println(s2);
        
        // for(int i=0; i< args.length; i++){
        //     System.out.println(s2.get(i));
            
        // }
        Set<Integer> sing= new HashSet<Integer>();
        sing.addAll(Arrays.asList(9,20,8,11,19,13,12,4,6,26,18,15,3,10,22));
        Set<Integer> dance= new HashSet<Integer>();
        Collections.addAll(dance, 32,2,8,20,11,19,13,8,41,4);
        Set<Integer> browse= new HashSet<Integer>();
        browse.addAll(Arrays.asList(13,4,414,41,28,1,3,43,42,44,46));
        Set<Integer> intersection= new HashSet<>(sing);
        intersection.retainAll(dance);
        intersection.retainAll(browse);
        System.out.println(intersection);
        
        Set<Integer> sd= new HashSet<>(sing);
        sd.retainAll(dance);
        System.out.println(sd);
        
        Set<Integer> db= new HashSet<>(dance);
        db.retainAll(browse);
        System.out.println(db);
        
        Set<Integer> nb= new HashSet<>(dance);
        nb.retainAll(sing);
        nb.removeAll(browse);
        System.out.println(nb);
        
        Set<Integer> nds= new HashSet<>(browse);
        nb.removeAll(dance);
        nb.removeAll(sing);
        System.out.println(nds);
        
        
        
    }
}
