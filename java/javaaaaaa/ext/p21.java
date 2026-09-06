import java.util.*;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // input words
        String[] words = sc.nextLine().split(" ");

        // k value
        int k = sc.nextInt();

        // count frequency
        HashMap<String, Integer> map = new HashMap<>();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        // convert keys to list
        List<String> list = new ArrayList<>(map.keySet());

        // sort based on frequency and lexicographical order
        Collections.sort(list, new Comparator<String>() {
            public int compare(String a, String b) {
                if (map.get(a) != map.get(b)) {
                    return map.get(b) - map.get(a); // higher frequency first
                }
                return a.compareTo(b); // lexicographical order
            }
        });

        // print top k words
        for (int i = 0; i < k; i++) {
            System.out.println(list.get(i));
        }
    }
}