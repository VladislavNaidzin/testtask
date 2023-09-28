package by.trainee.testtask;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@SpringBootTest
class TesttaskApplicationTests {



	@Test
	void users() {


		RestAssured.baseURI = "http://localhost:8080";
		Response response = given().log().all()
				.when()
				.get("/users")
				.then()
				.statusCode(200)
				.extract()
				.response();

		response.then().body("$", hasSize(greaterThan(0)));
	}


	@Test
	void usersPlus() {


		RestAssured.baseURI = "http://localhost:8080";
		Response response = given().log().all()
				.when()
				.get("/users/plus")
				.then()
				.statusCode(200)
				.extract()
				.response();

		response.then().body("$", hasSize(greaterThan(0)));
	}

	@Test
	void usersAdd() {


		RestAssured.baseURI = "http://localhost:8080";
		Response response = given().log().all()
				.when()
				.post("/users/add")
				.then()
				.statusCode(401)
				.extract()
				.response();
	}

	@Test
	void userByLogin() {


		RestAssured.baseURI = "http://localhost:8080";

		String login = "user1";
		Response response = given().log().all()
				.when()
				.get("/users/" + login)
				.then()
				.statusCode(200)
				.extract()
				.response();

		response.then().body("login", equalTo(login));


	}

	@Test
	void userByLoginFail() {


		RestAssured.baseURI = "http://localhost:8080";

		String login = "HereIsNoUser";
		Response response = given().log().all()
				.when()
				.get("/users/" + login)
				.then()
				.statusCode(404)
				.extract()
				.response();

		response.then().body(isEmptyOrNullString());


	}

	@Test
	void addUser() {
	RestAssured.baseURI = "http://localhost:8080";
	String login = "user5";
	String password = "1";
		String token=given().log().all()
				.contentType("application/json")
				.body("{\n" +
						"    \"login\":\"user5\",\n" +
						"    \"PASSWORD\":\"1\"\n" +
						"}")
				.when()
				.post("/authenticate")
				.then()
				.statusCode(200)
				.extract()
				.path("activeToken");

		System.out.println(token);

		String loginNew="user1234";
	Response response = given().log().all()
			.header("Authorization", "Bearer " + token)
			.body("{\"login\":\"" + loginNew + "\"}")
			.contentType(ContentType.JSON)
			.when()
			.post("/users/add")
			.then()
			.statusCode(201)
			.extract()
			.response();
	}


	@Test
	void addUserFailedBadRequest() {
		RestAssured.baseURI = "http://localhost:8080";
		String login = "user5";
		String password = "1";
		String token=given().log().all()
				.contentType("application/json")
				.body("{\n" +
						"    \"login\":\"user5\",\n" +
						"    \"PASSWORD\":\"1\"\n" +
						"}")
				.when()
				.post("/authenticate")
				.then()
				.statusCode(200)
				.extract()
				.path("activeToken");

		System.out.println(token);

		Response response = given().log().all()
				.header("Authorization", "Bearer " + token)
				.body("{\"login\":\"" + login + "\"}")
				.contentType(ContentType.JSON)
				.when()
				.post("/users/add")
				.then()
				.statusCode(400)
				.extract()
				.response();
	}


}
