package parser;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author Tigran.Mkrtchyan
 * @since 11/18/2016.
 */
public class StaxParser implements Parser {
    @Override
    public void parseByDom(String path) {

    }

    @Override
    public void parseBySax(String path) {

    }

    @Override
    public void parseByStax(String path) {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(path));
            while (xmlEventReader.hasNext()) {
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    if (startElement.getName().getLocalPart().equals("staff")) {
                        Attribute idAttr = startElement.getAttributeByName(new QName("id"));
                        if (idAttr != null) {
                            System.out.println("Id:" + idAttr.getValue());
                        }
                    }
                    //set the other varibles from xml elements
                    else if (startElement.getName().getLocalPart().equals("firstname")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        System.out.println("firstname:" + xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("lastname")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        System.out.println("nickname:" + xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("nickname")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        System.out.println("nickname:" + xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("salary")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        System.out.println("salary:" + xmlEvent.asCharacters().getData());
                    }
                }
            }

        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
