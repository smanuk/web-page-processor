package net.manikiam.webpageprocessor.services;

import org.jsoup.nodes.Document;

import java.util.List;

/**
 * @author smanikiam
 */
public class WebProcessorService {

    private static String BING_SEARCH_URL = "https://www.bing.com/search?q=";

    public static WebProcessorService getNewInstance() {
        return new WebProcessorService();
    }


    private WebpageService webPageService;
    private LinkParserService linkParserService;
    private ScriptParserService scriptParserService;


    private WebProcessorService() {
        webPageService = WebpageService.getNewInstance();
        linkParserService = LinkParserService.getNewInstance();
        scriptParserService = ScriptParserService.getNewInstance();
    }


    public void countScripts(String searchPhrase) throws Exception {

        Document webDocument = searchBing(searchPhrase);

        List<String> links = linkParserService.parseLinks(webDocument);

        for (String link : links) {

            try {
                Document page = webPageService.openWebPage(link);
                List<String> scriptNames = scriptParserService.parseScripts(page);

                System.out.println(scriptNames);
            }
            catch (Exception ex) {
                System.out.println("Error opening webpage, will skip this one: " + link);
            }

        }
    }


    private Document searchBing(String searchPhrase) throws Exception {

        return webPageService.openWebPage(new StringBuilder(BING_SEARCH_URL).append(searchPhrase).toString());
    }

}
