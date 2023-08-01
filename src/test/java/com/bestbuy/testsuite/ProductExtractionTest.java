package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ProductExtractionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);
    }

//21. Extract the limit
    @Test
    public void extractTheLimit(){
        int limit =response.extract().path("limit");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " +limit);
        System.out.println("------------------End of Test---------------------------");
    }

//22. Extract the total
@Test
public void extractTheTotal() {
    int total = response.extract().path("total");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value of total is : " + total);
    System.out.println("------------------End of Test---------------------------");

}

//23. Extract the name of 5th product
@Test
public void extractTheNameOfProduct() {
    String name = response.extract().path("data[3].name");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The the name of 5th product : " + name);
    System.out.println("------------------End of Test---------------------------");
}
    //24. Extract the names of all the products
    @Test
    public void extractTheNameOfAllProduct() {
        List<String> allProducts = response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The the names of all the products : " + allProducts);
        System.out.println("------------------End of Test---------------------------");
    }


//25. Extract the productId of all the products
@Test
public void extractTheProductIdOfAllProduct() {
    List<Integer> allProductsId = response.extract().path("data.id");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The productId of all the products: " + allProductsId);
    System.out.println("------------------End of Test---------------------------");
}

//26. Print the size of the data list
@Test
public void extractTheSizeOfDataList() {


    List<Integer> listOfData = response.extract().path("data.id");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The productId of all the products: " + listOfData.size());
    System.out.println("------------------End of Test---------------------------");
}

//27. Get all the value of the product where product name = Energizer - MAX Batteries AA (4-Pack)
@Test
public void extractAllTheValue() {
        List<HashMap<String,?>> allTheValue =response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4-Pack)'}");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("Get all the value of the product where product name = Energizer - MAX Batteries AA (4-Pack): " +allTheValue );
    System.out.println("------------------End of Test---------------------------");
}

//28. Get the model of the product where product name = Energizer - N Cell E90 Batteries (2-Pack)
@Test
public void getModelOfProduct() {
    List<HashMap<String,?>> getTheModel =response.extract().path("data.findAll{it.name == 'Energizer - N Cell E90 Batteries (2-Pack)'}.model");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("Get the model of the product where product name = Energizer - N Cell E90 Batteries (2-Pack): " +getTheModel );
    System.out.println("------------------End of Test---------------------------");
}


//29. Get all the categories of 8th products
    @Test
    public void getAllCategoriesOfProducts() {
        List<HashMap<String,?>> getAllCategories =response.extract().path("data[7].categories");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Get all the categories of 8th products : " +getAllCategories );
        System.out.println("------------------End of Test---------------------------");
    }

//30. Get categories of the store where product id = 150115
@Test
public void getCategoriesOfStore() {
    List<HashMap<String,?>> getCategories =response.extract().path("data[3].categories");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("Get categories of the store where product id = 150115 : " +getCategories );
    System.out.println("------------------End of Test---------------------------");
}

//31. Get all the descriptions of all the products
@Test
public void getAllTheDescriptionOfAllTheProduct() {
    List<HashMap<String,?>> getAllDescription =response.extract().path("data.description");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("//31. Get all the descriptions of all the products : " +getAllDescription );
    System.out.println("------------------End of Test---------------------------");
}

//32. Get id of all the all categories of all the products

    @Test
    public void getIdOfAllCategoriesOfAllProducts() {
        List<HashMap<String,?>> getIdOfAllCategories =response.extract().path("data.categories.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" Get id of all the all categories of all the products : " +getIdOfAllCategories );
        System.out.println("------------------End of Test---------------------------");
    }

//33. Find the product names Where type = HardGood
@Test
public void findProductNameByType() {
    List<String> productName =response.extract().path("data.findAll{it.type == 'HardGood'}.name");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("Find the product names Where type = HardGood : " +productName );
    System.out.println("------------------End of Test---------------------------");
}



//34. Find the Total number of categories for the product where product name = Duracell - AA1.5V CopperTop Batteries (4-Pack)
@Test
public void totalNumberOfCategories() {
    List<HashMap<String, ?>> totalNumberOfCategories = response.extract().path("data.findAll{it.name = 'Duracell - AA 1.5V CopperTop Batteries (4-Pack)'}.categories");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("Total number of categories for the product where product name = Duracell - AA 1.5V CopperTop Batteries (4-Pack) is : " + totalNumberOfCategories.size());
    System.out.println("------------------End of Test---------------------------");

}


//35. Find the createdAt for all products whose price < 5.49

    @Test
    public void findCreatedAtForAllProduct() {
        List<String> createdAtAllProduct = response.extract().path("data.findAll{it.price < 5.49}.createdAt");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the createdAt for all products whose price < 5.49 : " + createdAtAllProduct);
        System.out.println("------------------End of Test---------------------------");

    }


//36. Find the name of all categories Where product name = “Energizer - MAX Batteries AA (4-Pack)”

    @Test
    public void findNameOfAllCategories() {
        List<HashMap<String, ?>> nameOfAllCategories = response.extract().path("data.findAll{it.name=='Energizer - MAX Batteries AA (4-Pack)'}.categories.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the name of all categories Where product name = “Energizer - MAX Batteries AA (4-Pack)”: " + nameOfAllCategories);
        System.out.println("------------------End of Test---------------------------");
    }
    //37. Find the manufacturer of all the products
    @Test
    public void findManufacturer() {
        List<HashMap<String, ?>> findAllManufactures = response.extract().path("data.manufacturer");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Find the manufacturer of all the products: " + findAllManufactures);
        System.out.println("------------------End of Test---------------------------");
    }

//38. Find the image of products whose manufacturer is = Energizer
@Test
public void findTheImageOfProducts() {
    List<String> productImage = response.extract().path("data.findAll{it.manufacturer =='Energizer'}");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("Find the manufacturer of all the products: " + productImage);
    System.out.println("------------------End of Test---------------------------");
}

//39. Find the createdAt for all categories products whose price > 5.99
@Test
public void findTheCreatedAtForAllCategories(){
    List<String> createdAt = response.extract().path("data.findAll{it.price>5.99}.categories.createdAt");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("Find the createdAt for all categories products whose price > 5.99: " + createdAt);
    System.out.println("------------------End of Test---------------------------");
}
//40. Find the uri of all the products
@Test
public void findTheUriOfAllTheProducts(){
        List<String> url =response.extract().path("data.url");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("Find the uri of all the products: " +url );
    System.out.println("------------------End of Test---------------------------");
}

}
