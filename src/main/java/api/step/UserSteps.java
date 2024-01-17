package api.step;

import api.builders.UserBuilders;
import api.config.Requests;
import api.dto.response.get.GetEmptyUserDto;
import api.dto.response.get.UserDto;
import api.dto.response.get.DeleteUserDto;
import api.dto.response.get.GetUserDto;
import api.endpoints.UserEndpoints;

import static api.config.RequestService.request;
import static api.config.ResponseService.ok;
import static api.config.ResponseService.userDeleted;

public class UserSteps {

    static Requests requests = new Requests();


    public UserDto createUser() {
        return requests.post((new UserBuilders().userDefaultBuilder()),
                        UserEndpoints.USER_ADD.getEndpoints()).then().spec(ok())
                .extract().body().as(UserDto.class);
    }
    public GetUserDto getUser() {
        return requests.get(request(),
                        UserEndpoints.GET_USER.getEndpoints() + "Zodiac").then().spec(ok())
                .extract().body().as(GetUserDto.class);
    }

    public DeleteUserDto deleteUser() {
        return requests.delete(request(),
                        UserEndpoints.USER_DELETE.getEndpoints() + "Zodiac").then().spec(ok())
                .extract().body().as(DeleteUserDto.class);
    }
    public GetEmptyUserDto getEmptyUser() {
        return requests.get(request(),
                        UserEndpoints.GET_USER.getEndpoints() + "Zodiac").then().spec(userDeleted())
                .extract().body().as(GetEmptyUserDto.class);
    }
    public io.restassured.response.ResponseBodyExtractionOptions deleteEmptyUser() {
        return requests.delete(request(),
                        UserEndpoints.USER_DELETE.getEndpoints() + "Zodiac").then().spec(userDeleted())
                .extract().body();
    }
}
