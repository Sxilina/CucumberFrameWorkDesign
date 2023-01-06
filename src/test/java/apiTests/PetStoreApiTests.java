package petStoreApiTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetStoreApiTests {
  @Test (dependsOnMethods="postAPet")
  public void getPetById() {
	  RestAssured
	  .given().accept(ContentType.JSON)
	  .get("https://petstore.swagger.io/v2/pet/2323233")
	  .then().statusCode(200);
  }
  
  
   @Test
   public void findByStatus() {
	   RestAssured
	   .given().accept(ContentType.JSON).contentType("application/json").param("status","pending")
	   .when().get("https://petstore.swagger.io/v2/pet/findByStatus?status=available")
	   .then().statusCode(200).contentType("application/json");
   }

  
   @Test

   public void getById() {
 	  Response myResponse=RestAssured
 			  .given().accept(ContentType.JSON)
 			  .get("https://petstore.swagger.io/v2/pet/2323233");
 	  
 	  myResponse.prettyPrint();
 	  //verify
      myResponse.then().assertThat().statusCode(200)
      .and().contentType("application/json"); 
      
      String petName= myResponse.path("name");
      System.out.println("pet name is:" + petName);
      Assert.assertEquals(petName, "Bobbi");
  
      int petId= myResponse.body().path("id");
      System.out.println("pet id is:" + petId);
      Assert.assertEquals(petId, 2323233);
     
      int tagsId=myResponse.path("tags[0].id");
      System.out.println("pet tags id is :" + tagsId);
      Assert.assertEquals(tagsId, 31);
      
     // how to access the tags name from the second object
      String tags2Name=myResponse.path("tags[1].name");
      System.out.println("pet second tag name is:" + tags2Name);
      Assert.assertEquals(tags2Name, "summer");
      
      //using json-path function
      String categoryName=myResponse.jsonPath().get("category.name");
      System.out.println("pet category name is:" + categoryName);
      Assert.assertEquals(categoryName, "cat");
   }
  
     @Test
        public void postAPet() {
    	  
    	   String requestBody="{\n"
    	   		+ "  \"id\": 2323233,\n"
    	   		+ "  \"category\": {\n"
    	   		+ "    \"id\": 0,\n"
    	   		+ "    \"name\": \"Puppie\"\n"
    	   		+ "  },\n"
    	   		+ "  \"name\": \"Bobbi\",\n"
    	   		+ "  \"photoUrls\": [\n"
    	   		+ "    \"string\"\n"
    	   		+ "  ],\n"
    	   		+ "  \"tags\": [\n"
    	   		+ "    {\n"
    	   		+ "      \"id\": 31,\n"
    	   		+ "      \"name\": \"cocapoo\"\n"
    	   		+ "    }\n"
    	   		+ "  ],\n"
    	   		+ "  \"status\": \"available\"\n"
    	   		+ "}";
    	   
    	  Response myResponse=  RestAssured
    	   .given().accept(ContentType.JSON).contentType("application/json").body(requestBody)
    	   .when().post("https://petstore.swagger.io/v2/pet");
    	  
    	  myResponse.then().statusCode(200)
    	  .and().contentType("application/json");
    	  
    	  myResponse.prettyPrint();
    	   
     }
}





