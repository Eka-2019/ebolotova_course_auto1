package models.widget;

import lombok.Data;

import java.util.List;

@Data
public class ContentParameter {
    private List<String> contentFields;
    private int itemsCount;
    private WidgetOption widgetOptions;
}
