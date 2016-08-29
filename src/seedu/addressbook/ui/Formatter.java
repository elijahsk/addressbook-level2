package seedu.addressbook.ui;

import static seedu.addressbook.common.Messages.*;

import seedu.addressbook.commands.CommandResult;
import seedu.addressbook.common.Utils;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Text UI of the application.
 */
public class Formatter {

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";


    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    /** Format of a comment input line. Comment lines are silently consumed when reading user input. */
    private static final String COMMENT_LINE_FORMAT_REGEX = "#.*";

    public String addDivider(String message) {
    	return message + "\n" + DIVIDER; 
    }
    
    public String addDecoration(String message) {
    	return LINE_PREFIX + message.replace("\n", LS + LINE_PREFIX);
    }
    
    public String displayCommand(String command) {
    	return "[Command entered:" + command + "]";
    }
    
    /** Formats a list of strings as a viewable indexed list. */
    	public String getIndexedListForViewing(List<String> listItems) {
            final StringBuilder formatted = new StringBuilder();
            int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
            for (String listItem : listItems) {
                formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
                displayIndex++;
            }
            return formatted.toString();
        }
    	
    	/**
         * Formats a string as a viewable indexed list item.
         *
         * @param visibleIndex visible index for this listing
         */
    	public String getIndexedListItem(int visibleIndex, String listItem) {
            return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
        }
}
