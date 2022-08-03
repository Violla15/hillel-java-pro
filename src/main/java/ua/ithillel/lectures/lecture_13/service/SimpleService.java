package ua.ithillel.lectures.lecture_13.service;

import ua.ithillel.lectures.lecture_13.annotation.Init;
import ua.ithillel.lectures.lecture_13.annotation.Service;

@Service(name = "Simple Service")
public class SimpleService {

    @Init
    public void initService() {
        System.out.println("simple init");
    }
}
