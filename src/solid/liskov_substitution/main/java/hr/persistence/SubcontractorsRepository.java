package solid.liskov_substitution.main.java.hr.persistence;

import solid.liskov_substitution.main.java.hr.personnel.Subcontractor;

import java.util.Arrays;
import java.util.List;

public class SubcontractorsRepository {

    public List<Subcontractor> findAll() {
        // Subcontractors
        Subcontractor subcontractor = new Subcontractor("Rebekah Jackson", 3000);
        return Arrays.asList(subcontractor);
    }
}
