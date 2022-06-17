package models;

import lombok.Data;

@Data
public class Widget {
    boolean share;
    String widgetName;
    String widgetType;
    int widgetId;
    WidgetPosition widgetPosition;
    WidgetSize widgetSize;

}
