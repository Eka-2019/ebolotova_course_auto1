package models.widget;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContentParameter {
    private List<String> contentFields;
    private int itemsCount;
    private WidgetOption widgetOptions;
}
