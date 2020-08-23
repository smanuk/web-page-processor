package net.manikiam.webpageprocessor.services;

/**
 * @author smanikiam
 */
public class WebProcessorService {
    
    public static WebProcessorService getNewInstance() {
        return new WebProcessorService();
    }

    private WebProcessorService() {

    }


    private Document searchBing(String searchPhrase) throws Exception {

        return webPageService.openWebPage(new StringBuilder(BING_SEARCH_URL).append(searchPhrase).toString());
    }

}
