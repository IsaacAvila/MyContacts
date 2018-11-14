package com.example.hobo.mycontacts.restApi.deserializer;

import com.example.hobo.mycontacts.pojo.Contact;
import com.example.hobo.mycontacts.restApi.JsonKeys;
import com.example.hobo.mycontacts.restApi.model.ContactResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Caleb on 7/21/2017.
 */

public class ContactDeserializer implements JsonDeserializer<ContactResponse> {

    @Override
    public ContactResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        ContactResponse contactResponse = gson.fromJson(json, ContactResponse.class);
        JsonArray contactResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.RESPONSE_ARRAY);
        contactResponse.setContacts(deserializerContactJson(contactResponseData));
        return contactResponse;
    }

    private ArrayList<Contact> deserializerContactJson(JsonArray contactResponseData) {
        ArrayList<Contact> contacts = new ArrayList<>();
        for (int i = 0; i < contactResponseData.size(); i++) {
            JsonObject imageInfo = contactResponseData.get(i).getAsJsonObject();

            JsonObject userJson  = imageInfo.getAsJsonObject(JsonKeys.USER);
            String id            = userJson.get(JsonKeys.USER_ID).getAsString();
            String full_name     = userJson.get(JsonKeys.USER_FULL_NAME).getAsString();

            String urlPhoto = imageInfo.getAsJsonObject(JsonKeys.IMAGES)
                    .getAsJsonObject(JsonKeys.RESOLUTION)
                    .get(JsonKeys.IMAGE_URL).getAsString();

            int likes = imageInfo.getAsJsonObject(JsonKeys.LIKES)
                    .get(JsonKeys.COUNT).getAsInt();

            Contact contact = new Contact();
            contact.setId(id);
            contact.setFullName(full_name);
            contact.setUrlPhoto(urlPhoto);
            contact.setLikes(likes);

            contacts.add(contact);
        }
        return contacts;
    }
}
