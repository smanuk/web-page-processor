package net.manikiam.webpageprocessor.services;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author smanikiam
 */
public class LinkParserService {

    static final String SEARCH_RESULT = "li.b_algo";
    static final String REMOVE_RESULT = "li.b_algoBorder";
    static final String LINK_SECTION = "h2";
    static final String LINK = "a[href]";
    static final String HREF = "href";

    public static LinkParserService getNewInstance() {

        return new LinkParserService();
    }

    private LinkParserService() {

    }

    public List<String> parseLinks(Document webDocument) {


        Elements listItems = webDocument
                .select(SEARCH_RESULT)
                .removeAttr(REMOVE_RESULT)
                .select(LINK_SECTION)
                .select(LINK);


        Set<String> linkSet = listItems.stream()
                .map(href -> href.attr(HREF))
                .collect(Collectors.toSet());

        return new ArrayList<>(linkSet);
    }
}
