package models.widget;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Widget {
    private List<AppliedFilter> appliedFilters;
    private Content content;
    private ContentParameter contentParameters;
    private String description;
    private int id;
    private String name;
    private String owner;
    private boolean share;
    private String widgetType;
    private List<Long> filterIds;
}
