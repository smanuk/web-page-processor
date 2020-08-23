package net.manikiam.webpageprocessor;

import net.manikiam.webpageprocessor.services.WebProcessorService;

/**
 * @author smanikiam
 */
public class WebPageProcessorApplication {

    public static void main(String[] args) throws Exception {

        if (args.length > 0 && args[0] != null && !args[0].isEmpty()) {

            System.out.println(new StringBuilder("Search phrase: ").append(args[0]));

            WebPageProcessorApplication webPageProcessorApplication = new WebPageProcessorApplication();
            webPageProcessorApplication.webProcessorService.countScripts(args[0]);
        }
        else {
            System.out.println("Please supply a search phrase as an argument to this application.");
            throw new IllegalArgumentException("No search argument supplied");
        }
    }


    private WebProcessorService webProcessorService;

    private WebPageProcessorApplication() {

        webProcessorService = WebProcessorService.getNewInstance();
    }
}
