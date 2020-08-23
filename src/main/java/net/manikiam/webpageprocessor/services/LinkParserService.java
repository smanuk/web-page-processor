package net.manikiam.webpageprocessor.services;

import org.jsoup.nodes.Document;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

/**
 * @author smanikiam
 */
public class LinkParserService {

    public static LinkParserService getNewInstance() {

        return new LinkParserService();
    }

    private LinkParserService() {

    }

    public List<String> parseLinks(Document webDocument) {

        throw new NotImplementedException();
    }
}
