package adapter;

import parser.Parser;

/**
 * @author Tigran.Mkrtchyan
 * @since 11/18/2016.
 */
public class ParseAdapter {
    Parser parser;
    String type;

    public ParseAdapter(Parser parser, String type) {
        this.parser = parser;
        this.type = type;
    }

    public void parse(String path) {
        switch (type) {
            case "DOM":
                parser.parseByDom(path);
                break;
            case "SAX":
                parser.parseBySax(path);
                break;
            case "STAX":
                parser.parseByStax(path);
                break;
        }
    }
}
