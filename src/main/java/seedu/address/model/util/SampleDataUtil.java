package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.StudentId;
import seedu.address.model.tag.Mod;


/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new Name("Alex Yeoh"), new StudentId("A1234567R"), new Phone("87438807"),
                new Email("alexyeoh@example.com"), true,
                getTagSet("CS2103T have group", "CS2106", "CS2101 need member"), false),
            new Person(new Name("Bernice Yu"), new StudentId("A1234568X"),
                    new Phone("99272758"), new Email("berniceyu@example.com"), false,
                getTagSet("CS2100", "CS3230 need group", "CS4234 need member"), false),
            new Person(new Name("Charlotte Oliveiro"), new StudentId("A1234569Y"),
                    new Phone("93210283"), new Email("charlotte@example.com"), true,
                getTagSet("CS1101S", "CS3230 need member"), false),
            new Person(new Name("David Li"), new StudentId("A1234570Z"),
                    new Phone("91031282"), new Email("lidavid@example.com"), false,
                getTagSet("IS1103"), false),
            new Person(new Name("Irfan Ibrahim"), new StudentId("A1234571R"),
                    new Phone("92492021"), new Email("irfan@example.com"), false,
                getTagSet("ST2334 need group", "GEA1000 need member"), false),
            new Person(new Name("Roy Balakrishnan"), new StudentId("A1234572X"),
                    new Phone("92624417"), new Email("royb@example.com"), false,
                getTagSet("LAJ1000 need member", "GES1021", "MA2001"), false)
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Mod> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Mod::new)
                .collect(Collectors.toSet());
    }

}
