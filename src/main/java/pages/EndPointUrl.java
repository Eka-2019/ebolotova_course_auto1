package pages;

import lombok.Getter;

@Getter
public enum EndPointUrl {
    DASHBOARD("/dashboard");
    String path;

    EndPointUrl(String path){
        this.path = path;
    }

    public String addPath(String additionalPath){
        return  path + additionalPath;
    }
}
