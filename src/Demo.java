import adapter.ParseAdapter;
import parser.DomParser;
import parser.SaxParser;
import parser.StaxParser;

/**
 * @author Tigran.Mkrtchyan
 * @since 11/18/2016.
 */
public class Demo {
    public static void main(String[] args) {
        ParseAdapter parseAdapter = new ParseAdapter(new DomParser(), "DOM");
        parseAdapter.parse("/D:/_Projects/xmlAssesment/xmls/staff.xml");
        System.out.println("End of Dom");
        parseAdapter = new ParseAdapter(new SaxParser(), "SAX");
        parseAdapter.parse("/D:/_Projects/xmlAssesment/xmls/staff.xml");
        System.out.println("End of Sax");
        parseAdapter = new ParseAdapter(new StaxParser(), "STAX");
        parseAdapter.parse("/D:/_Projects/xmlAssesment/xmls/staff.xml");
        System.out.println("End of Stax");
    }
}
