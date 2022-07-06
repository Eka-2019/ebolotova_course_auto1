package models.widget;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class Order {
    private boolean isAsc;
    private String sortingColumn;
}
