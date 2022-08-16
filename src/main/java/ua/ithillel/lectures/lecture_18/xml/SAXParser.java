package ua.ithillel.lectures.lecture_18.xml;

import org.xml.sax.SAXException;
import ua.ithillel.lectures.lecture_18.xml.handler.BookSAXHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SAXParser {

    public void parseDocument(String path) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        javax.xml.parsers.SAXParser saxParser = factory.newSAXParser();


        BookSAXHandler handler = new BookSAXHandler();
        saxParser.parse(path,handler);

        handler.getResult().forEach(System.out::println);
    }
}
