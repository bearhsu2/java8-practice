package idv.kuma.lambda.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderSampleMain {

    public static String processFile(BufferedReaderProcessor processor) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return processor.process(br);
        }

    }


    public static void main(String[] args) throws IOException {


        String oneLine = processFile( br -> br.readLine());
        System.out.println(oneLine);
        String twoLines = processFile( br -> br.readLine() + "=HAHA=" + br.readLine());
        System.out.println(twoLines);
    }
}
