package net.manikiam.webpageprocessor.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * @author smanikiam
 */
public class ScriptParserServiceTest {

    static final String TEST_FILE = "stack_overflow_page.html";
    static final String ENCODING = "UTF-8";

    static final String SCRIPT1 = "jquery.min.js";
    static final String SCRIPT2 = "stub.en.js";

    Document document;

    ScriptParserService cut = ScriptParserService.getNewInstance();

    @Before
    public void before() throws Exception {

        ClassLoader classLoader = getClass().getClassLoader();
        File input = new File(classLoader.getResource(TEST_FILE).getFile());
        document = Jsoup.parse(input, ENCODING);
    }

    @Test
    public void parseScriptsCountTest() {

        List<String> result = cut.parseScripts(document);
    }
}
