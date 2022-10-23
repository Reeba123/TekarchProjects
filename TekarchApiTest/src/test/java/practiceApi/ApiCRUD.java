package practiceApi;

import java.util.List;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.helpers.ServiceHelpers;
import com.test.models.AddUserpojo;
import com.test.models.GetPOJOres;
import com.test.models.TestAddpojo;
import com.test.models.TestPojo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ApiCRUD extends ServiceHelpers {
	static int id = 0;

	// Testcase:1
	@Test
	public static void gettmethod() {

		Response res = RestAssured.when().get("https://dummy.restapiexample.com/api/v1/employees");
		TestPojo test = res.as(TestPojo.class);
		List<GetPOJOres> respList = test.getData();
		res.then().statusCode(200);
		res.then().body("status", Matchers.equalTo("success"));
		System.out.println("number data records = " + respList.size());
		res.prettyPrint();

	}

	// Testcase:2

	@Test
	public static void createmethod() {
		Response res = RestAssured.given().contentType(ContentType.JSON)
				.body("{\"name\":\"test\",\"salary\":\"123\",\"age\":\"23\"}").when()
				.post("https://dummy.restapiexample.com/api/v1/create");
		TestAddpojo test = res.as(TestAddpojo.class);
		AddUserpojo data = test.getData();
		res.then().statusCode(200);
		res.then().body("status", Matchers.equalTo("success"));
		res.prettyPrint();
		String name = data.getName();
		Assert.assertEquals(name, "test");
		String salary = data.getSalary();
		Assert.assertEquals(salary, "123");
		String age = data.getAge();
		Assert.assertEquals(age, "23");
		int id = data.getId();
		System.out.println("id = " + id);

	}

//Testcase :3
	@Test(dependsOnMethods = "createmethod")
	public static void deletemethod() {

		Response res = RestAssured.given().contentType(ContentType.JSON).when()
				.delete("https://dummy.restapiexample.com/api/v1/delete/" + id);
		res.then().statusCode(200);
		System.out.println("Message data = " + res);
		res.then().body("status", Matchers.equalTo("success"));
		System.out.println("Response = " + res);
		res.prettyPrint();

	}

	// Testcase :4
	@Test
	public static void deleteerrormethod() {

		Response res = RestAssured.given().contentType(ContentType.JSON).when()
				.delete("https://dummy.restapiexample.com/api/v1/delete/0");
		res.then().statusCode(400);
		System.out.println("Message data = " + res);
		res.then().body("status", Matchers.equalTo("error"));
		String msgdata = res.jsonPath().get("message");
		System.out.println("Message data = " + msgdata);
		res.prettyPrint();

	}

	// Testcase :5
	@Test
	public static void getmethod() {

		Response res = RestAssured.given().contentType(ContentType.JSON).when()
				.get("https://dummy.restapiexample.com/api/v1/employee/2");
		res.then().statusCode(200);
		res.then().contentType(ContentType.JSON);
		String name = res.jsonPath().get("data.employee_name");
		Assert.assertEquals(name, "Garrett Winters");
	     int salary=res.jsonPath().get("data.employee_salary");
		// System.out.println("salary = " + salary);
		 Assert.assertEquals(salary, 170750); 
		 int Age=res.jsonPath().get("data.employee_age");
		 Assert.assertEquals(Age, 63);
	}

}
