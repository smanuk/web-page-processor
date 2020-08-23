package net.manikiam.webpageprocessor.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * @author smanikiam
 */
public class WebpageService {

    private static String USER_AGENT = "Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6";
    private static String REFERER = "https://www.bing.com";

    public static WebpageService getNewInstance() {

        return new WebpageService();
    }

    private WebpageService() {

    }

    public Document openWebPage(String webUrlString) throws Exception {

            return Jsoup.connect(webUrlString)
                    .userAgent(USER_AGENT)
                    .referrer(REFERER)
                    .get();
    }
}
