package models.widget;

import lombok.Data;

import java.util.List;

@Data
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
