package models.widget;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContentParameter {
    private List<String> contentFields;
    private int itemsCount;
    private WidgetOption widgetOptions;
}
