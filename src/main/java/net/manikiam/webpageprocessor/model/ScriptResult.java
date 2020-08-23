package net.manikiam.webpageprocessor.model;

/**
 * @author smanikiam
 */
public class ScriptResult implements Comparable<ScriptResult> {

    private String scriptName;
    private int count;

    public ScriptResult(String scriptName) {

        this.scriptName = scriptName;
        count = 1;
    }

    public String getScriptName() {
        return scriptName;
    }

    public int getCount() {
        return count;
    }

    public void incrementCount() {
        count = ++count;
    }

    @Override
    public int compareTo(ScriptResult scriptResult) {

        if (count == scriptResult.getCount()) {

            return scriptName.compareTo(scriptResult.getScriptName());
        } else {

            return scriptResult.getCount() - count;
        }
    }

    @Override
    public String toString() {
        return new StringBuilder(scriptName).append(",").append(count).toString();
    }
}