package ua.ithillel.lectures.lecture_13.annotation;

import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Service {

    String name();

    boolean lazyLoad() default false;
}
