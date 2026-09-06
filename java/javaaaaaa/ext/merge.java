public class merge {
    public static void main(String[] args) {
        String a="hellohi";
        String b="world";
        int n=Math.min(a.length(), b.length());
        String res="";
        for(int i=0;i<n;i++){
            res+=a.charAt(i);
            res+=b.charAt(i);
        }
        if(a.length()>b.length()){
            res=res.concat(a.substring(n));
        }
        else{
            res=res.concat(b.substring(n));
        }
        System.out.println(res);

    }
    
}
