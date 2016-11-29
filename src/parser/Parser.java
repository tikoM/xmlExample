package parser;

/**
 * @author Tigran.Mkrtchyan
 * @since 11/18/2016.
 *
 * using adapter pattern
 */
public interface Parser {
   void parseByDom(String path);
   void parseBySax(String path);
   void parseByStax(String path);
}
