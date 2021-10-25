package pl.webdevchallenge.meetmeuprest.event.domain;

import pl.webdevchallenge.meetmeuprest.event.util.GroupCategory;

import java.util.ArrayList;

public class Group {
    private long id;
    private String groupName;
    private GroupCategory groupCategory;
    private ArrayList<Long> groupUsersList;
    private ArrayList<Long> groupEventList;

}
