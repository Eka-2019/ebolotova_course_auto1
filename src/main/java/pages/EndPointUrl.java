package pages;

import lombok.Getter;

@Getter
public enum EndPointUrl {
    LOGIN("/#login");

    String path;

    EndPointUrl(String path){
        this.path = path;
    }

    public String addPath(String additionalPath){
        return  path + additionalPath;
    }
}
