package parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * @author Tigran.Mkrtchyan
 * @since 11/18/2016.
 */
public class SaxParser implements Parser{

    @Override
    public void parseByDom(String path) {

    }

    @Override
    public void parseBySax(String path) {
        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {

                boolean bfname = false;
                boolean blname = false;
                boolean bnname = false;
                boolean bsalary = false;

                public void startElement(String uri, String localName,String qName,
                                         Attributes attributes) throws SAXException {

                    bfname = qName.equalsIgnoreCase("FIRSTNAME");
                    blname = qName.equalsIgnoreCase("LASTNAME");
                    bnname = qName.equalsIgnoreCase("NICKNAME");
                    bsalary = qName.equalsIgnoreCase("SALARY");
                }

                public void endElement(String uri, String localName,
                                       String qName) throws SAXException {

                }

                public void characters(char ch[], int start, int length) throws SAXException {

                    if (bfname) {
                        System.out.println("First Name : " + new String(ch, start, length));
                        bfname = false;
                    }

                    if (blname) {
                        System.out.println("Last Name : " + new String(ch, start, length));
                        blname = false;
                    }

                    if (bnname) {
                        System.out.println("Nick Name : " + new String(ch, start, length));
                        bnname = false;
                    }

                    if (bsalary) {
                        System.out.println("Salary : " + new String(ch, start, length));
                        bsalary = false;
                    }

                }

            };

            saxParser.parse(path, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public void parseByStax(String path) {

    }
}
