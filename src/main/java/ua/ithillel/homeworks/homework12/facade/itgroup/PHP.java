package ua.ithillel.homeworks.homework12.facade.itgroup;

import ua.ithillel.homeworks.homework12.facade.GroupStart;

public class PHP implements GroupStart {

    @Override
    public void start() {
        System.out.println("PHP group " + getStartStudy() + " started learning.");
    }

    public String getStartStudy() {
        return "20.02.2022";
    }
}
