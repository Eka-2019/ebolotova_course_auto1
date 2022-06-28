package models.widget;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WidgetOption {
    private boolean zoom;
    private String timeline;
    private String viewMode;
    //private boolean latest;
}
