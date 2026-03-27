import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;


class Pair {
    String name;
    String month;
    Pair(String name, String month) {
        this.name = name;
        this.month = month;
    }
    int getbulan(HashMap<String, Integer> monthMap) {
        return 0;
    }
}

class Pair2 extends Pair {
    Pair2(String name, String month){
    super (name, month);}

    @Override 
    int getbulan(HashMap<String, Integer> monthMap) {
        return monthMap.get(month.toLowerCase());
    }
}

    public class q1 {
    public static List<String> solve(String input) {
       HashMap<String, Integer> monthMap = new HashMap<>();
        monthMap.put("january", 1);
        monthMap.put("february", 2);
        monthMap.put("march", 3);
        monthMap.put("april", 4);
        monthMap.put("may", 5);
        monthMap.put("june", 6);
        monthMap.put("july", 7);
        monthMap.put("august", 8);
        monthMap.put("september", 9);
        monthMap.put("october", 10);
        monthMap.put("november", 11);
        monthMap.put("december", 12);
      
        Stack<String> stack = new Stack<>();
        String [] kata = input.split(" ");
        for (String word : kata) {
            stack.push(word);
        }

        List<Pair> pair = new ArrayList<>();
        while (!stack.isEmpty()) {
            String dua = stack.pop();
            String satu = stack.pop();
            pair.add(new Pair2 (satu, dua)); 
        }

        Collections.sort(pair, (a, b) -> {
            int indexA = a.getbulan(monthMap);
            int indexB = b.getbulan(monthMap);
        return Integer.compare(indexA, indexB);
        } );
        
        Stack<String> output = new Stack<>();
        for (Pair perbandingan : pair) {
            output.push(perbandingan.name);
            output.push(perbandingan.month);
        }
        return new ArrayList<>(output);
    }

    public static void main(String[] args) {
        String input = "holly may interesting MARCH corey November junior january paul december";
        System.out.println(solve(input));
    }

}
