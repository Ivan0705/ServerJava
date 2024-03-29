package ru.academits.dao;

import ru.academits.model.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Anna on 17.06.2017.
 */
public class ContactDao {
    private List<Contact> contactList = new ArrayList<>();
    private AtomicInteger idSequence = new AtomicInteger(0);

    public ContactDao() {
        Contact contact = new Contact();
        contact.setId(getNewId());
        contact.setFirstName("Иван");
        contact.setLastName("Иванов");
        contact.setPhone("9123456789");
        contactList.add(contact);
    }

    private int getNewId() {
        return idSequence.addAndGet(1);
    }

    public List<Contact> getAllContacts(String filterQuery) {
        if (filterQuery != null && !filterQuery.equals("")) {
            filterQuery = filterQuery.toLowerCase();
            List<Contact> filteredResults = new ArrayList<>();

            for (Contact contact : contactList) {
                if (Integer.toString(contact.getId()).equals(filterQuery)) {
                    filteredResults.add(contact);
                } else if (contact.getPhone().equals(filterQuery)) {
                    filteredResults.add(contact);
                } else if (contact.getFirstName().toLowerCase().equals(filterQuery)) {
                    filteredResults.add(contact);
                } else if (contact.getLastName().toLowerCase().equals(filterQuery)) {
                    filteredResults.add(contact);
                }
            }
            return filteredResults;
        } else {
            return contactList;
        }
    }

    public void add(Contact contact) {
        contact.setId(getNewId());
        contactList.add(contact);
    }

    public void remove(int id) {
        contactList.removeIf(contact -> contact.getId() == id);
    }
}
