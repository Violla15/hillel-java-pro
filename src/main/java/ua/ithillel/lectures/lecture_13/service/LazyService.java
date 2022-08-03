package ua.ithillel.lectures.lecture_13.service;

import ua.ithillel.lectures.lecture_13.annotation.Init;
import ua.ithillel.lectures.lecture_13.annotation.Service;

@Service(name = "Lazy Service", lazyLoad = true)
public class LazyService {

    @Init
    public void lazyInit() {
        System.out.println("lazy init");
    }
}
