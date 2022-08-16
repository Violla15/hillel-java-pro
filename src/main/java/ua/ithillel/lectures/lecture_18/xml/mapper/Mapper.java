package ua.ithillel.lectures.lecture_18.xml.mapper;

import org.w3c.dom.NodeList;

import java.util.List;

public interface Mapper<T> {
    List<T> getAll(NodeList nodeList);

}
