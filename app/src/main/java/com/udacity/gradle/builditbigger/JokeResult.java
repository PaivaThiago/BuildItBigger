package com.udacity.gradle.builditbigger;

public class JokeResult {
    private String joke;


    public JokeResult() {
        joke = null;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public interface JokeDelegate {
        void handleJoke(JokeResult result);
    }
}

