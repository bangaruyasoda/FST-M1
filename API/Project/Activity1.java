package Activities;

	import org.testng.annotations.Test;
	import io.restassured.response.Response;
	import io.restassured.RestAssured;
	import io.restassured.builder.RequestSpecBuilder;
	import io.restassured.http.ContentType;
	import io.restassured.specification.RequestSpecification;
	import org.testng.Assert;
	import org.testng.annotations.BeforeClass;

	public class Activity1
	{

	    RequestSpecification requestSpec;

	    // Store SSH key and generated ID
	    String sshKey =
	            "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQCxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";

	    int keyId;

	    @BeforeClass
	    public void setup() {

	        requestSpec = new RequestSpecBuilder()
	                .setBaseUri("https://api.github.com")
	                .setContentType(ContentType.JSON)
	                .addHeader("Authorization", "token YOUR_GITHUB_ACCESS_TOKEN")
	                .build();
	    }

	    @Test(priority = 1)
	    public void addSSHKey() {

	        String requestBody = "{\n" +
	                "\"title\":\"TestAPIKey\",\n" +
	                "\"key\":\"" + sshKey + "\"\n" +
	                "}";

	        Response response =
	                RestAssured
	                        .given()
	                        .spec(requestSpec)
	                        .body(requestBody)
	                        .when()
	                        .post("/user/keys");

	        response.prettyPrint();

	        // Store generated key id
	        keyId = response.jsonPath().getInt("id");

	        // Assertions
	        Assert.assertEquals(response.getStatusCode(), 201);
	        Assert.assertNotNull(keyId);
	        Assert.assertTrue(keyId > 0);

	        System.out.println("SSH Key Created Successfully");
	        System.out.println("Generated ID: " + keyId);
	    }

	    @Test(priority = 2)
	    public void getSSHKeys() {

	        Response response =
	                RestAssured
	                        .given()
	                        .spec(requestSpec)
	                        .when()
	                        .get("/user/keys");

	        response.prettyPrint();

	        Assert.assertEquals(response.getStatusCode(), 200);

	        System.out.println("Retrieved SSH Keys Successfully");
	    }

	    @Test(priority = 3)
	    public void deleteSSHKey() {

	        Response response =
	                RestAssured
	                        .given()
	                        .spec(requestSpec)
	                        .when()
	                        .delete("/user/keys/" + keyId);

	        Assert.assertEquals(response.getStatusCode(), 204);

	        System.out.println("SSH Key Deleted Successfully");
	    }
	}