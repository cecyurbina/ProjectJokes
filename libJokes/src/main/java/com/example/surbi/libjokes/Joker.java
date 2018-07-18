package com.example.surbi.libjokes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Joker {
    public String getJoke() {
        return getRandom();
    }

    private static List<String> allJokes(){
        List<String> jokes = new ArrayList<>();
        jokes.add("Chuck norris went skydiving and his parachute failed to open, so he took it back the next day for a refund");
        jokes.add("Chuck Norris died 20 years ago, Death just hasn't built up the courage to tell him yet.");
        jokes.add("Chuck Norris broke the law once. It still isn\u2019t fixed.");
        jokes.add("Chuck Norris doesn't wear a watch. He simply decides what time it is.");
        jokes.add("Chuck Norris has already been to Mars; that's why there are no signs of life.");
        jokes.add("Chuck Norris can sit at the corner of a round table");
        jokes.add("A total eclipse won't look directly at Chuck Norris.");
        jokes.add("Chuck Norris can divide by zero.");
        jokes.add("Chuck Norris protects his body guards.");
        jokes.add("When the President pushes the big red button, Chuck Norris's cell phone rings.");
        return jokes;
    }

    private static String getRandom() {
        List<String> jokes = allJokes();
        int rnd = new Random().nextInt(jokes.size());
        return jokes.get(rnd);
    }
}
