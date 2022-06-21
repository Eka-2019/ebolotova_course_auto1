package models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Widget {
    boolean share;
    String name;
    String description;
    String widgetType;
    int widgetId;
    WidgetPosition widgetPosition;
    WidgetSize widgetSize;
    WigetContentParameters contentParameters;


    public Widget(String name, String description, boolean share, String widgetType) {
        this.name = name;
        this.description = description;
        this.share = share;
        this.widgetType = widgetType;
    }
}
