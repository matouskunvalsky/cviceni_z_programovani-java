package people.services;

import people.Owner;
import people.factories.OwnerFactory;

import java.util.ArrayList;
import java.util.List;

public class OwnerService {

    private final OwnerFactory ownerFactory;
    private final List<Owner> owners = new ArrayList<>();

    public OwnerService(OwnerFactory ownerFactory) {
        this.ownerFactory = ownerFactory;
    }

    public Owner createOwner(String firstName, String lastName) {
        Owner owner = ownerFactory.createAccountOwner(firstName, lastName);
        owners.add(owner);
        return owner;
    }
}