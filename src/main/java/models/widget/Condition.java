package models.widget;

import lombok.Data;

@Data
public class Condition {
    private String condition;
    private String filteringField;
    private String value;
}
