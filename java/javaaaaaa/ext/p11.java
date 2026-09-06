import java.util.HashMap;

class p11{
    public static void main(String[] args) {
        HashMap<String,String> h1=new HashMap<>();
        HashMap<String,String> h2=new HashMap<>();
        HashMap<String,String> h3=new HashMap<>();
        int c=0;
        for(String key: h1.keySet()){
            if (h2.containsKey(key)){
                if(h1.get(key) .equals(h2.get(key))){
                    c++;
                    h3.put(key, h2.get(key));
                }

            }
        }
    }
}