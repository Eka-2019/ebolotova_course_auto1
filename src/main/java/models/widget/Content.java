package models.widget;

import lombok.Data;

import java.util.List;

//@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Content {
    private List<Result> result;
}
