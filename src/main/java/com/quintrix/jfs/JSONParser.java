package com.quintrix.jfs;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quintrix.jfs.models.MessageRole;

public class JSONParser {

  @SuppressWarnings("unchecked")
  public static void main(String[] args) {

    String jsonStr = "{" + "\"message\": \"Hello\"," + "\"role\": \"admin \"" + "}";
    // HashMap example

    try

    {
      Map<String, Object> jsonToJavaMap = new HashMap<String, Object>();
      jsonToJavaMap = new ObjectMapper().readValue(jsonStr, Map.class);

      System.out.println("Java map: " + jsonToJavaMap);
    } catch (JsonProcessingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }


    // MessageRole
    MessageRole messageRole;
    try {
      messageRole = new ObjectMapper().readValue(jsonStr, MessageRole.class);
      System.out.println("Java Map: " + messageRole);
      System.out.println(messageRole.getMessage());

      if (messageRole.getMessage().equals("admin")) {
        System.out.println("It is Admin");
      } else {
        System.out.println("It is NOT Admin");
      }



    } catch (JsonMappingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (JsonProcessingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }



  }
}
