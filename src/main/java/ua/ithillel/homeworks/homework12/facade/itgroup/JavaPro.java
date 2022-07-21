package ua.ithillel.homeworks.homework12.facade.itgroup;

import ua.ithillel.homeworks.homework12.facade.GroupStart;

public class JavaPro implements GroupStart {

    @Override
    public void start() {
        System.out.println("Java Pro group " + getStartStudy() + " started learning.");
    }

    public String getStartStudy() {
        return "15.04.2022";
    }
}