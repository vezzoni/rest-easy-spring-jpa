package vezzoni.api.controller;

import javax.ws.rs.core.Response;

public interface ApiController {

    Response greetings(String name);

    Response insert(Integer id);

}
