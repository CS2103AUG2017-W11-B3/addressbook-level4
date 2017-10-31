package seedu.address.ui;

//@@author teclu
/**
 * A UI feature for each unique tag to have its own colour.
 */
public class TagColours {
    private static final String RED = "#CB4335";
    private static final String DARK_RED = "#911205";
    private static final String ORANGE = "#F39C12";
    private static final String LIGHT_ORANGE = "#FFAA23";
    private static final String YELLOW = "#F4D03F";
    private static final String GREEN = "#27AE60";
    private static final String DARK_GREEN = "#006D36";
    private static final String BLUE = "#2980B9";
    private static final String NAVY_BLUE = "#095282";
    private static final String INDIGO = "#8E44AD";
    private static final String VIOLET = "#DB2B6F";
    private static final String BLACK = "#000000";
    private static final String HOT_PINK = "#FF0062";

    /**
     * Returns a String array of available tag colours.
     */
    public String[] getTagColours() {
        return new String[] { RED, DARK_RED, ORANGE, LIGHT_ORANGE, YELLOW,
                                GREEN, DARK_GREEN, BLUE, NAVY_BLUE, INDIGO, VIOLET, HOT_PINK, BLACK };
    }
}
