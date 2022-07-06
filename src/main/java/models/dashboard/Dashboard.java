package models.dashboard;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Dashboard {
    int id;
    String name;
    String description;
    String owner;
    boolean share;
    List<WidgetForDashboard> widgets;


    public Dashboard(String name, String description, boolean share) {
        this.name = name;
        this.description = description;
        this.share = share;
    }
}
