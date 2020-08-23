package net.manikiam.webpageprocessor;

/**
 * @author smanikiam
 */
public class WebPageProcessorApplication {

    public static void main(String[] args) {

        if (args.length > 0 && args[0] != null && !args[0].isEmpty()) {

            System.out.println(args[0]);
        }
    }
}
