package com.monish.QuizApp.Entity;

public class Response {
    private int id;
    private String response;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResponse() {
        return response;
    }

    public void setReponse(String response) {
        this.response = response;
    }

    public Response(int id, String reponse) {
        this.id = id;
        this.response = reponse;
    }

    public Response(String response) {
        this.response=response;
    }

    public Response() {
    }
}
