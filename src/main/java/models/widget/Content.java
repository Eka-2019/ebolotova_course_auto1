package models.widget;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

//@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Content {
    private List<Result> result;
}
