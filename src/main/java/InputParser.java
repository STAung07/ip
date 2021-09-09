public abstract class InputParser {
    // take in string and check no. of words, words it contains etc.

    // flags for all possible cases
    private static final String LIST = "list";
    private static final String BYE = "bye";
    private static final String TODO = "todo";
    private static final String EVENT = "event";
    private static final String DONE = "done";
    private static final String DEADLINE = "deadline";
    private static final String BY= "/by";
    private static final String AT = "/at";


    public static String getTaskName(String input) {
        return input.substring(input.indexOf(" ") + 1, input.indexOf("/")).trim();
    }

    public static String getDate(String input) {
        return input.substring(input.indexOf("/") + 3).trim();
    }

    public static int getTaskIndex(String input) {
        return Integer.parseInt(input.substring(input.indexOf(" ") + 1)) - 1;
    }

    // command parser handling all commands; returns enum of commands
    public static Commands getCommand(String input) {
        // checks if it contains list or bye
        if (input.equals(LIST)) {
            return Commands.LIST;
        }

        if (input.equals(BYE)) {
            return Commands.BYE;
        }

        if (input.startsWith(TODO)) {
            return Commands.TODO;
        }

        if (input.startsWith(DEADLINE)) {
            return Commands.DEADLINE;
        }

        if (input.startsWith(EVENT)) {
            return Commands.EVENT;
        }

        if (input.startsWith(DONE)) {
            return Commands.DONE;
        }

        return Commands.NULLCOMMAND;
    }
}
