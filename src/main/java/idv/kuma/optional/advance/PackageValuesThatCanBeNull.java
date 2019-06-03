package idv.kuma.optional.advance;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PackageValuesThatCanBeNull {

    public static void main(String[] args) {
        Map<String, Integer> nameToAge = new HashMap<>();
        nameToAge.put("Kuma", 38);
        nameToAge.put("Dad", 58);


        System.out.println(nameToAge.getOrDefault("Sister", -1));

        Optional<Integer> sisterAge = Optional.ofNullable(nameToAge.get("Sister"));
        System.out.println(sisterAge.orElse(-1));


    }
}
