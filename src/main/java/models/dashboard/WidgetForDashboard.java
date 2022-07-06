package models.dashboard;

import lombok.Data;
import lombok.NoArgsConstructor;
import models.widget.Position;
import models.widget.Size;

@Data
@NoArgsConstructor
public class WidgetForDashboard {
    String widgetName;
    int widgetId;
    String widgetType;
    Size widgetSize;
    Position widgetPosition;
    boolean share;
}
