package idv.kuma.refactor.pattern;

public class HeaderTextProcessing extends ProcessingObject<String> {
    @Override
    protected String handleWork(String input) {
        return "From Jack: " + input;
    }
}
