package models;

import lombok.Data;

import java.util.List;

@Data
public class WigetContentParameters {
    List<String> contentFields;
    int itemsCount;
    WidgetParametersOptions widgetOptions;

}
