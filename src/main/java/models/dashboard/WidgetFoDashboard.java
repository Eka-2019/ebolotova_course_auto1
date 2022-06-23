package models.dashboard;

import lombok.Data;
import lombok.NoArgsConstructor;
import models.WidgetPosition;
import models.WidgetSize;

@Data
@NoArgsConstructor
public class WidgetFoDashboard {
    String widgetName;
    int widgetId;
    String widgetType;
    WidgetSize widgetSize;
    WidgetPosition widgetPosition;
    boolean share;
}
