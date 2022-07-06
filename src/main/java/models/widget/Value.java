package models.widget;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class Value {
    private String statistics$executions$passed;
    private String statistics$executions$total;
}
