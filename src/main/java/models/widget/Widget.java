package models.widget;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.text.AbstractDocument;
import java.util.List;

@Data
@NoArgsConstructor
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
}
