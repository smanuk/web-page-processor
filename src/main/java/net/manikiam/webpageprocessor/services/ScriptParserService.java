package net.manikiam.webpageprocessor.services;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author smanikiam
 */
public class ScriptParserService {

    private static final String SOURCE = "src";
    private static String SCRIPT_REF = "script[src]";
    private static final String JS = ".js";

    public static ScriptParserService getNewInstance() {
        return new ScriptParserService();
    }

    private ScriptParserService() {

    }

    public List<String> parseScripts(Document document) {

        Elements elements = document.select(SCRIPT_REF);

        Set<String> scriptSet = elements.stream()
                .filter(s -> s.attr(SOURCE).toLowerCase().contains(JS))
                .map(scriptSource -> {

                    String fullScriptPath = scriptSource.attr(SOURCE).toLowerCase();

                    try {
                        String script = parseScriptFromPath(fullScriptPath);
                        return script;
                    }
                    catch(Exception ex) {
                        ex.printStackTrace();
                    }
                    return null;
                })
                .collect(Collectors.toSet());


        return new ArrayList<>(scriptSet);
    }

    private String parseScriptFromPath(String path) {

        return path.substring(path.lastIndexOf('/')+1, path.lastIndexOf(JS)+3);
    }
}
