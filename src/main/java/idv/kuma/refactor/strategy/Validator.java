package idv.kuma.refactor.strategy;

public class Validator {

    ValidationStrategy strategy;

    public Validator(ValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validate(String s) {
        return strategy.execute(s);
    }

    public static void main(String[] args) {

        // Old Fashioned Way
        Validator v1 = new Validator(new IsAlllowerCase());
        System.out.println(v1.validate("aabbcc"));

        Validator v2 = new Validator(new IsNumeric());
        System.out.println(v2.validate("aabbcc"));


        // Lambda Way
        Validator v3 = new Validator( s -> s.matches("[a-z]+"));
        System.out.println(v3.validate("aabbcc"));
        Validator v4 = new Validator( s -> s.matches("\\d+"));
        System.out.println(v4.validate("aabbcc"));


    }
}

class IsAlllowerCase implements ValidationStrategy {

    @Override
    public boolean execute(String s) {
        return s.matches("[a-z]+");
    }
}

class IsNumeric implements ValidationStrategy {

    @Override
    public boolean execute(String s) {
        return s.matches("\\d+");
    }
}
