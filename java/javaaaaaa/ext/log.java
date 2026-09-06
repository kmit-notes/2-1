// Write a java program for the following scenario you have created a web-based
// b)
// survey of favorite programming languages and are capturing the results into a text file named
// logfile‖. The structure of the text file is:
// Total # Entries Vote for Entry 1
// IP Address for Entry 1 Timestamp in seconds for Entry 1 Vote for Entry 2
// IP Address for Entry 2 Timestamp in seconds for Entry 2
// ….
// For example, here is a sample log file of six entries:6
// PHP 137.229.156.12
// 1000002
// C# 137.229.156.18
// 1000005
// PHP 137.229.156.12
// 1000006
// Prolog 156.213.38.31
// 1000010
// PHP 128.120.56.214
// 1000020
// PHP 137.229.156.12
// 1000022
// The logfile is ordered by increasing timestamp. You are concerned that some people
// are voting multiple times for the same item. To somewhat address this problem, throw
// out any new votes for the same item that come from the same IP address within
// 20seconds.
// In the above example, the second and last votes for PHP would be thrown out because
// they are for the same item from the same IP address and occur within 20 seconds of
// other PHP votes from the same IP address. However, the PHP vote from
// 128.120.56.214 would be retained since there is not another PHP vote from this IP
// address.
// Write a Java program to count the votes from the logfile, throwing out duplicate votes
// using the rules above.
// Display the votes in a table, as shown below for the example:
// PHP
// 2
// C#
// 1
// Prolog 1





import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

public class log {
    public static void main(String[] args) throws Exception {
        System.out.println("This is p2");
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String line;
        HashMap<String, Integer> voteCount = new HashMap<>();
        HashMap<String, Long> lastVoteTime = new HashMap<>();
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            String[] parts = line.split(" ");
            String vote = parts[0];
            String ip = parts[1];
            long timestamp = Long.parseLong(parts[2]);
            String key = vote + "_" + ip;
            if (lastVoteTime.containsKey(key)) {
                long lastTime = lastVoteTime.get(key);
                if (timestamp - lastTime < 20) {
                    // Duplicate vote within 20 seconds, ignore
                    continue;
                }
                lastVoteTime.put(key, timestamp);
                voteCount.put(vote, voteCount.getOrDefault(vote, 0) + 1);
            } else {
                lastVoteTime.put(key, timestamp);   
                voteCount.put(vote, voteCount.getOrDefault(vote, 0) + 1);
            }
            
        }
        br.close();
        System.out.println(voteCount);

    }
    
}