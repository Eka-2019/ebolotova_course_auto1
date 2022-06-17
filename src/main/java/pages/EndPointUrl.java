package pages;

import lombok.Getter;

@Getter
public enum EndPointUrl {
    DASHBOARD("/api/v1/default_personal/dashboard"),
    TOKEN("/uat/sso/oauth/token");

    String path;

    EndPointUrl(String path){
        this.path = path;
    }

    public String addPath(String additionalPath){
        return  path + additionalPath;
    }
}
