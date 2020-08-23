package net.manikiam.webpageprocessor.services;

import org.jsoup.nodes.Document;

/**
 * @author smanikiam
 */
public class WebProcessorService {

    private static String BING_SEARCH_URL = "https://www.bing.com/search?q=";

    public static WebProcessorService getNewInstance() {
        return new WebProcessorService();
    }


    private WebpageService webPageService;


    private WebProcessorService() {
        webPageService = WebpageService.getNewInstance();
    }


    public void countScripts(String searchPhrase) throws Exception {

        Document webDocument = searchBing(searchPhrase);

        System.out.println(webDocument);
    }


    private Document searchBing(String searchPhrase) throws Exception {

        return webPageService.openWebPage(new StringBuilder(BING_SEARCH_URL).append(searchPhrase).toString());
    }

}
