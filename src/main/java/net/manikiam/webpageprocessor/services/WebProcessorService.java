package net.manikiam.webpageprocessor.services;

import net.manikiam.webpageprocessor.model.ScriptResult;
import org.jsoup.nodes.Document;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author smanikiam
 */
public class WebProcessorService {

    private static String BING_SEARCH_URL = "https://www.bing.com/search?q=";

    private static int LIMIT = 5;

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

        Map<String, ScriptResult> results = new HashMap<>();
        for (String link : links) {

            try {
                Document page = webPageService.openWebPage(link);
                addScripts(scriptParserService.parseScripts(page), results);
            }
            catch (Exception ex) {
                System.out.println("Error opening webpage, will skip this one: " + link);
            }
        }

        sortAndPrintResults(results);
    }


    private Document searchBing(String searchPhrase) throws Exception {

        return webPageService.openWebPage(new StringBuilder(BING_SEARCH_URL).append(searchPhrase).toString());
    }

    private void addScripts(List<String> scriptNames, Map<String, ScriptResult> results) {

        scriptNames.forEach(sn -> addScript(sn, results));
    }

    private void addScript(String scriptName, Map<String, ScriptResult> results) {

        if (results.containsKey(scriptName)) {
            results.get(scriptName).incrementCount();
        }
        else {
            results.put(scriptName, new ScriptResult(scriptName));
        }
    }

    private void sortAndPrintResults(Map<String, ScriptResult> results) {

        System.out.println("Total entries: " + results.size());

        System.out.println("Top 5 entries:");
        results.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(LIMIT)
                .forEach(m -> System.out.println(m.getValue()));
    }
}
