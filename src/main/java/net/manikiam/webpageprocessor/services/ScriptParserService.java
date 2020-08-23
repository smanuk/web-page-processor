package net.manikiam.webpageprocessor.services;

import org.jsoup.nodes.Document;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

/**
 * @author smanikiam
 */
public class ScriptParserService {

    public static ScriptParserService getNewInstance() {
        return new ScriptParserService();
    }

    private ScriptParserService() {

    }

    public List<String> parseScripts(Document document) {

        throw new NotImplementedException();
    }
}
