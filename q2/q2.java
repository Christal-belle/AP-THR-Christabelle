package q2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

abstract class Stand {
    abstract boolean exposed(String name);
}

class Josuke extends Stand {
    public boolean exposed(String name) {
        return name.toLowerCase().startsWith("k");
    }
}

class Jotaro extends Stand {
    public boolean exposed(String name) {
    return name.length() <= 3; 
    }
}

class Okuyasu extends Stand {
    public boolean exposed(String name) {
        name = name.toLowerCase();
        for (int i = 0; i < name.length() - 1; i++){
            if (name.charAt(i) == name.charAt(i + 1)){
                return true; } 
        }
        return false;
        }
    }

class Koichi extends Stand {
    public boolean exposed(String name) {
    String vowel = "aiueo";
    int count = 0;
    for (char c : name.toLowerCase().toCharArray()){
        if (vowel.indexOf(c) != -1){
            count++;}
    }
    return count >= 3;
    }
}

class Rohan extends Stand {
    public boolean exposed(String name) {
    name = name.toLowerCase();
    String reverse = new StringBuilder(name).reverse().toString();
    return name.equals(reverse);
    }
}

public class q2 {
    public static Stand getStand(String name) {
        switch (name){
            case "Josuke":
                return new Josuke();
            case "Jotaro":
                return new Jotaro();
            case "Okuyasu":
                return new Okuyasu();
            case "Koichi":
                return new Koichi();
            case "Rohan":
                return new Rohan();
            default: 
                return null;
        }
    }

    public static void check(String standName, String input) {
        Queue<String> queue = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        String[] names = input.trim().split("\\s+"); 
        for(String name : names) {
            queue.add(name);
        }
        Stand stand = getStand(standName);
        while (!queue.isEmpty()) {
            String name = queue.poll();
            if(stand.exposed(name)) {
                stack.push(name.toLowerCase());
            }
        }
        if (!stack.isEmpty()) {
            System.out.println(standName + " exposed someone!");
        }
        else {
            System.out.println(standName + " exposed no one");
        }

        System.out.println("Arrested: " + stack);
    }

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String standName = sc.nextLine();
    String names = sc.nextLine();
    check (standName, names);

    sc.close();
    }
}

