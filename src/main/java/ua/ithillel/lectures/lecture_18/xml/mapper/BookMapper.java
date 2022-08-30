package ua.ithillel.lectures.lecture_18.xml.mapper;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import ua.ithillel.lectures.lecture_18.xml.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookMapper implements Mapper<Book> {
    @Override
    public List<Book> getAll(NodeList nodeList) {
        List<Book> result = new ArrayList<>();

        for (int temp = 0; temp < nodeList.getLength(); temp++) {
            Node node = nodeList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String id = element.getAttribute("id");
                String author = element.getElementsByTagName("author").item(0).getTextContent();
                String title = element.getElementsByTagName("title").item(0).getTextContent();
                String genre = element.getElementsByTagName("genre").item(0).getTextContent();
                String price = element.getElementsByTagName("price").item(0).getTextContent();
                String publishDate = element.getElementsByTagName("publish_date").item(0).getTextContent();
                String description = element.getElementsByTagName("description").item(0).getTextContent();

                Book book = new Book(id, author, title, genre, price, publishDate, description);
                result.add(book);
            }
        }

        return result;
    }
}

