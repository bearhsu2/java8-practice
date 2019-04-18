package idv.kuma;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodInvokeExample {

    public static void main(String[] args) {

        List<String> strings1 = Arrays.asList("12", "123");
        List<Integer> collect = strings1.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        System.out.println(collect);


        List<String> strings2 = Arrays.asList("a", "b", "A", "C");
        strings2.sort(String::compareToIgnoreCase);
        System.out.println(strings2);

        List<String> strings3 = Arrays.asList("aA", "bSF", "AA", "cC");
        List<String> lowerCases = strings3.stream().map(s -> s.toLowerCase()).collect(Collectors.toList());
        System.out.println(lowerCases);


    }
}
