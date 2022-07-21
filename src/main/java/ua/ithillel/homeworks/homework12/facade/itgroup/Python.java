package ua.ithillel.homeworks.homework12.facade.itgroup;

import ua.ithillel.homeworks.homework12.facade.GroupStart;

public class Python implements GroupStart {

    @Override
    public void start() {
        System.out.println("Python group " + getStartStudy() + " started learning.");
    }

    public String getStartStudy() {
        return "06.05.2022";
    }
}
