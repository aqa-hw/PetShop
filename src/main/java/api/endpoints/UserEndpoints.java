package api.endpoints;

public enum UserEndpoints {
    USER_ADD("/v2/user/"),
    GET_USER("v2/user/"),
    USER_DELETE("v2/user/");

    private final String endpoints;

    UserEndpoints(String endpoints) {
        this.endpoints = endpoints;
    }

    public String getEndpoints() {
        return endpoints;
    }
}
