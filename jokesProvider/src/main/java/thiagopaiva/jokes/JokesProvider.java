package thiagopaiva.jokes;

import java.util.Random;

public class JokesProvider {
    private String[] jokes = {
        "Tonight I dreamt of a beautiful walk on a sandy beach.\n" +
        "At least that explains the footprints I found in the cat litter box this morning.",

        "What do you get when you cross-breed a shark and a cow?\n"+
        "I have no idea but I wouldn’t try milking it.",

        "I wasn't that drunk yesterday.\n"+
        "Oh boy you took the shower head in your arms and told it to stop crying.",

        "How can you tell you have a really bad case of acne?\n"+
        "It’s when the blind try to read your face.",

        "Of course I should clean my windows.\n" +
        "But privacy is important too."
    };

    public String tellJoke(){
        int joke = new Random().nextInt(5);
        return jokes[joke];
    }
}
