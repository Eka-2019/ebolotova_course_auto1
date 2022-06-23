package models.widget;

import lombok.Data;

@Data
public class Result {
    private int id;
    private int number;
    private String name;
    private int startTime;
    private Value values;
}
