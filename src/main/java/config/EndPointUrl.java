package config;

import lombok.Getter;

import static utils.Constants.PROJECT_NAME;

@Getter
public enum EndPointUrl {
    DASHBOARD(String.format("/api/v1/%s/dashboard", PROJECT_NAME)),
    WIDGET(String.format("/api/v1/%s/widget", PROJECT_NAME)),
    TOKEN("/uat/sso/oauth/token");

    String path;


    EndPointUrl(String path) {
        this.path = path;
    }

    public String addPath(String additionalPath) {
        return path + additionalPath;
    }
}
