package seedu.modulink.logic.commands;

import static seedu.modulink.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.modulink.commons.core.Messages;
import seedu.modulink.model.Model;
import seedu.modulink.model.person.Person;


/**
 * Adds person whose student ID matches the user input to favourites..
 * ID matching is case insensitive.
 */
public class AddFavCommand extends Command {

    public static final String COMMAND_WORD = "addFav";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a person as a favourite. \n "
            + "Parameters: Student_ID \n"
            + "Example: " + COMMAND_WORD + " A1234567X";

    public static final String FAVOURITING_PROFILE_ERROR =
            "You cannot add your own profile to your Favourites list.";

    private final String studentId;

    public AddFavCommand(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public CommandResult execute(Model model) {
        boolean noPersonFound = true;
        ObservableList<Person> personList = model.getPersonList();

        // Look for the Person with the student ID, and if he is
        // not a favourite, make him a favourite. If he already is,
        // return a message saying he already is.
        for (Person person : personList) {
            if (person.getStudentId().toString().equalsIgnoreCase(studentId)) {
                if (person.getIsFavourite()) {
                    return new CommandResult(String.format(Messages.MESSAGE_PERSON_ALREADY_FAVOURITE));
                } else if (person.getIsMyProfile()) {
                    return new CommandResult(FAVOURITING_PROFILE_ERROR);
                } else {
                    person.setFavouriteTrue();
                    noPersonFound = false;
                }
            }
        }
        // included this so the list will be properly updated
        Predicate<Person> updatePredicate = unused -> false;
        model.updateFilteredPersonList(updatePredicate);
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);

        if (noPersonFound) {
            return new CommandResult(
                    String.format(Messages.MESSAGE_NO_SUCH_ID_FOUND));
        } else {
            return new CommandResult(
                    String.format(Messages.MESSAGE_FAVOURITE_ADDED, studentId));
        }

    }


    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddFavCommand // instanceof handles nulls
                && this.studentId.equals(((AddFavCommand) other).studentId));
    }


}
