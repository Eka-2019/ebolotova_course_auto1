package models.widget;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
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
