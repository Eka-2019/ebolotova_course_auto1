package config;

import lombok.Getter;

@Getter
public enum EndPointUrl {
    DASHBOARD("/api/v1/default_personal/dashboard"),
    WIDGET("/api/v1/default_personal/widget"),
    TOKEN("/uat/sso/oauth/token");

    String path;

    EndPointUrl(String path){
        this.path = path;
    }

    public String addPath(String additionalPath){
        return  path + additionalPath;
    }
}
