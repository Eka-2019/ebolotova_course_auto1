package models.widget;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WidgetOption {
    private boolean zoom;
    private String timeline;
    private String viewMode;
}
