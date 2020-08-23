package net.manikiam.webpageprocessor.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

/**
 * @author smanikiam
 */
public class LinkParserServiceTest {

    static final String TEST_FILE = "bing_search_page.html";
    static final String ENCODING = "UTF-8";

    Document document;

    LinkParserService cut = LinkParserService.getNewInstance();

    @Before
    public void before() throws Exception {

        ClassLoader classLoader = getClass().getClassLoader();
        File input = new File(classLoader.getResource(TEST_FILE).getFile());
        document = Jsoup.parse(input, ENCODING);
    }

    @Test
    public void getLinksTest() {

        List<String> links = cut.parseLinks(document);
        assertThat(links, is(notNullValue()));
    }
}
