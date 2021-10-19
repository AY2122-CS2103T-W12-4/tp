package seedu.modulink.logic.parser;

import static java.util.Objects.requireNonNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import seedu.modulink.commons.core.index.Index;
import seedu.modulink.commons.util.StringUtil;
import seedu.modulink.logic.parser.exceptions.ParseException;
import seedu.modulink.model.person.Email;
import seedu.modulink.model.person.Name;
import seedu.modulink.model.person.Phone;
import seedu.modulink.model.person.StudentId;
import seedu.modulink.model.tag.Mod;
import seedu.modulink.model.tag.Status;


/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses a {@code String name} into a {@code Name}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static Name parseName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!Name.isValidName(trimmedName)) {
            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
        }
        return new Name(trimmedName);
    }

    /**
     * Parses a {@code String phone} into a {@code Phone}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code phone} is invalid.
     */
    public static Phone parsePhone(String phone) throws ParseException {
        requireNonNull(phone);
        String trimmedPhone = phone.trim();
        if (!Phone.isValidPhone(trimmedPhone)) {
            throw new ParseException(Phone.MESSAGE_CONSTRAINTS);
        }
        return new Phone(trimmedPhone);
    }

    /**
     * Parses a {@code String email} into an {@code Email}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code email} is invalid.
     */
    public static Email parseEmail(String email) throws ParseException {
        requireNonNull(email);
        String trimmedEmail = email.trim();
        if (!Email.isValidEmail(trimmedEmail)) {
            throw new ParseException(Email.MESSAGE_CONSTRAINTS);
        }
        return new Email(trimmedEmail);
    }

    /**
     * Parses a {@code String tag} into a {@code Tag}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code tag} is invalid.
     */
    public static Mod parseTag(String tag) throws ParseException {
        requireNonNull(tag);
        String trimmedTag = tag.trim();
        if (!Mod.isValidTagName(trimmedTag)) {
            throw new ParseException(Mod.MESSAGE_CONSTRAINTS);
        }
        return new Mod(trimmedTag);
    }

    /**
     * Parses {@code Collection<String> tags} into a {@code Set<Tag>}.
     */
    public static Set<Mod> parseTags(Collection<String> tags) throws ParseException {
        requireNonNull(tags);
        final Set<Mod> modSet = new HashSet<>();
        for (String tagName : tags) {
            modSet.add(parseTag(tagName));
        }
        return modSet;
    }

    /**
     * Parses a {@code String StudentId} into a {@code StudentId}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code StudentId} is invalid.
     */
    public static StudentId parseStudentId(String studentId) throws ParseException {
        requireNonNull(studentId);
        String trimmedID = studentId.trim();
        if (!StudentId.isValidId(studentId)) {
            throw new ParseException(StudentId.MESSAGE_CONSTRAINTS);
        }
        return new StudentId(trimmedID);
    }

    /**
     * Parses a {@code String status} into a {@code Status}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code status} is invalid.
     */
    public static Status parseGroupStatus(String status) throws ParseException {
        if (status != null) {
            String trimmedStatus = status.trim();
            if (!Status.isValidStatus(trimmedStatus)) {
                throw new ParseException(Status.MESSAGE_CONSTRAINTS);
            }
            return Status.parseStatusForFilter(trimmedStatus);
        } else {
            return null;
        }
    }
}
