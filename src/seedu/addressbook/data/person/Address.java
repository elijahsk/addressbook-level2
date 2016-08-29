package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street, #1-01, 999999";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must be in format a/BLOCK, STREET, UNIT, POSTAL_CODE";
    public static final String ADDRESS_VALIDATION_REGEX = ".+,.+,.+,.+";
    private static final int ADDRESS_INDEX_BLOCK = 0;
    private static final int ADDRESS_INDEX_STREET = 1;
    private static final int ADDRESS_INDEX_UNIT = 2;
    private static final int ADDRESS_INDEX_POSTAL_CODE = 3;
    
    public final Block block;
    public final Street street;
    public final Unit unit;
    public final PostalCode postalCode;
    public final String value;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        
        final String[] splitAddressComponents = address.trim().split(",");
        this.block = new Block(splitAddressComponents[0].trim());
        this.street = new Street(splitAddressComponents[1].trim());
        this.unit = new Unit(splitAddressComponents[2].trim());
        this.postalCode = new PostalCode(splitAddressComponents[3].trim());
        this.value = address;
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}