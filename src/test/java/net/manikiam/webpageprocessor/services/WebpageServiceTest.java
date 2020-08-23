package net.manikiam.webpageprocessor.services;

import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

/**
 * @author smanikiam
 */
public class WebpageServiceTest {

    private WebpageService cut;

    @Before
    public void before() throws Exception {
        cut = WebpageService.getNewInstance();
    }

    @Test
    public void firstTest() throws Exception {

        Document dc = cut.openWebPage("https://www.bing.com/search?q='absolute zero'");
        assertThat(dc, not(nullValue()));
    }
}
