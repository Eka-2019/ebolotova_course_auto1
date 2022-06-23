package models.widget;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Value {
    private String statistics$executions$passed;
    private String statistics$executions$total;
}
