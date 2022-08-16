package ua.ithillel.lectures.lecture_18.xml.handler;

import lombok.Getter;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ua.ithillel.lectures.lecture_18.xml.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookSAXHandler extends DefaultHandler {

    private StringBuilder elementValue;
    @Getter
    private List<Book> result;


    @Override
    public void startDocument() {
        result = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case "book" -> result.add(new Book());
            case "title", "author", "genre", "price", "publish_date", "description" ->
                    elementValue = new StringBuilder();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "title" -> lastBook().setTitle(elementValue.toString());
            case "author" -> lastBook().setAuthor(elementValue.toString());
            case "genre" -> lastBook().setGenre(elementValue.toString());
            case "price" -> lastBook().setPrice(elementValue.toString());
            case "publish_date" -> lastBook().setPublishDate(elementValue.toString());
            case "description" -> lastBook().setDescription(elementValue.toString());
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (elementValue == null) {
            elementValue = new StringBuilder();
        } else {
            elementValue.append(ch, start, length);
        }
    }

    private Book lastBook() {
        return result.get(result.size() - 1);
    }
}
