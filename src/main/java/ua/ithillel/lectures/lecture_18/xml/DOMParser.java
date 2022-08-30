package ua.ithillel.lectures.lecture_18.xml;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DOMParser {

    private DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

    public Document parseDocument(String path) throws ParserConfigurationException, IOException, SAXException {
        dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File(path));

        doc.normalize();
        return doc;
    }
}


