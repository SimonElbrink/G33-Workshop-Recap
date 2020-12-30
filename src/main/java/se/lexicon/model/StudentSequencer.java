package se.lexicon.model;

public class StudentSequencer {
    private static int sequencer = 0;

    public static int nextId() {
        return ++sequencer;
    }

    public static int getSequencer() {
        return sequencer;
    }

    public static void reset(){
        sequencer = 0;
    }

}
