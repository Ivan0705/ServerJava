package academits.coverter;

import academits.service.ContactValidation;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class ContactValidationConverter {
    private Gson gson = new GsonBuilder().create();

    public String convertToJson(ContactValidation contactValidation) {
        return gson.toJson(contactValidation);
    }
}
