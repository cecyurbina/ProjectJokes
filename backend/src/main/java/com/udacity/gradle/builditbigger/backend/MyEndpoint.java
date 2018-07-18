package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi() {
         com.example.surbi.libjokes.Joker joker = new com.example.surbi.libjokes.Joker();
        //Toast.makeText(this, joker.getJoke(), Toast.LENGTH_SHORT).show();

        MyBean response = new MyBean();
        response.setData(joker.getJoke());

        return response;
    }

}
