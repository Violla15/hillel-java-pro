package ua.ithillel.homeworks.homework12.facade;

import ua.ithillel.homeworks.homework12.facade.itgroup.JavaPro;
import ua.ithillel.homeworks.homework12.facade.itgroup.PHP;
import ua.ithillel.homeworks.homework12.facade.itgroup.Python;

public class Group {

    private final GroupStart javaPro;
    private final GroupStart python;
    private final GroupStart php;

    public Group() {
        javaPro = new JavaPro();
        python = new Python();
        php = new PHP();
    }

    public void startJavaPro() {
        javaPro.start();
    }

    public void startPython() {
        python.start();
    }

    public void startPHP() {
        php.start();
    }
}
