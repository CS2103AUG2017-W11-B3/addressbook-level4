package seedu.address.model.person;

import static seedu.address.logic.parser.CliSyntax.PREFIX_BIRTHDAY;

import java.util.Comparator;
import java.util.List;

import seedu.address.commons.util.StringUtil;

//@@author nadhira15
/**
 * Tests that a {@code ReadOnlyPerson}'s {@code Birthday} matches any of the keywords given.
 */
public class BirthdayContainsKeywordsPredicate extends FieldContainsKeywordsPredicate {
    private final List<String> keywords;

    public BirthdayContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
        this.fieldToSearch = PREFIX_BIRTHDAY.getPrefix();
    }

    @Override
    public boolean test(ReadOnlyPerson person) {
        return keywords.stream().anyMatch(keyword -> StringUtil
                .containsWordPartialIgnoreCase(person.getBirthday().value, keyword));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof BirthdayContainsKeywordsPredicate // instanceof handles nulls
                && this.keywords.equals(((BirthdayContainsKeywordsPredicate) other).keywords)); // state check
    }

    @Override
    public Comparator<ReadOnlyPerson> sortOrderComparator() {
        return defaultSortOrder; //no sorting for birthday
    }
}
