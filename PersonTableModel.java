package addressbook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.table.AbstractTableModel;

public class PersonTableModel extends AbstractTableModel {

    public PersonTableModel() {
        people = new ArrayList<>();
    }

    public void nameSort() {
        Collections.sort(people, new Person.NameComparator());
    }

    public void addPerson(Person p) {
        people.add(p);
        fireTableRowsInserted(people.size() - 1, people.size() - 1);
    }

    public Person getPerson(int i) {
        return people.get(i);
    }

    public void sort(Comparator<Person> comp) {
        Collections.sort(people, comp);
        this.fireTableRowsUpdated(0, people.size());
    }

    public int getRowCount() {
        return people.size();
    }

    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Last name";
            case 1:
                return "First name";
            case 2:
                return "Address";
            case 3:
                return "City";
            case 4:
                return "St";
            default:
                return "Zip";
        }
    }

    @Override
    public Class<?> getColumnClass(int column) {
        if (column == 5) {
            return Integer.class;
        } else {
            return String.class;
        }
    }

    public Object getValueAt(int row, int column) {
        Person p = people.get(row);
        switch (column) {
            case 0:
                return p.getLastName();
            case 1:
                return p.getFirstName();
            case 2:
                return p.getAddress();
            case 3:
                return p.getCity();
            case 4:
                return p.getState();
            default:
                return p.getZip();
        }
    }

    private ArrayList<Person> people;
}
