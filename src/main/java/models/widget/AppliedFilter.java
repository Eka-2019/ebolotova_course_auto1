package models.widget;

import lombok.Getter;

import java.util.List;

@Getter
public class AppliedFilter {
    private List<Condition> conditions;
    private String description;
    private int id;
    private String name;
    private List<Order> orders;
    private String owner;
    private boolean share;
    private String type;
}
