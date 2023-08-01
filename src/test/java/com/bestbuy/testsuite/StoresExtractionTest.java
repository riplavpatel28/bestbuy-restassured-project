package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StoresExtractionTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);

    }






        // 1. Extract the limit
@Test
        public void extractTheLimit(){

    int limit= response.extract().path("limit");


    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value of limit is : " +limit);
    System.out.println("------------------End of Test---------------------------");


}

//2. Extract the total
    @Test
    public void extractTotal(){
        int total= response.extract().path("total");


        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total value  is : " +total);
        System.out.println("------------------End of Test---------------------------");


    }


//3. Extract the name of 5th store
    @Test
    public void extractNameOfTheStore(){

        String storeName = response.extract().path("data[4].name");


        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of 5th store : " +storeName);
        System.out.println("------------------End of Test---------------------------");


    }


//4. Extract the names of all the store
@Test
    public void extractNameOfTheAllStore(){

    List<String> allStoreName = response.extract().path("data.name");


    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The  the names of all the store : " + allStoreName);
    System.out.println("------------------End of Test---------------------------");

}


//5. Extract the storeId of all the store
@Test
public void extractTheStoreIdTheAllStore(){

    List<Integer> allStoreId = response.extract().path("data.services.storeservices.storeId");


    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The storeId of all the store : " + allStoreId);
    System.out.println("------------------End of Test---------------------------");

}

//6. Print the size of the data list
    @Test
    public void sizeOfTheData(){

        List<Integer> listOfData = response.extract().path("data.Id");
        int size =listOfData.size();


        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The size of the data : " + size);
        System.out.println("------------------End of Test---------------------------");


    }


//7. Get all the value of the store where store name =St Cloud
@Test
public void allTheValueOfTheStore() {

    List<HashMap<String, ?>> value = response.extract().path("data.findAll{it.name =='St Cloud'}");


    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value of the store  : " + value);
    System.out.println("------------------End of Test---------------------------");
}

//8. Get the address of the store where store name = Rochester
    @Test
      public void getTheAddressOfTheStore(){
//        List<HashMap<String, ?>> address = response.extract().path("data.findAll{it.address =='Rochester'}");
//        System.out.println("------------------StartingTest---------------------------");
//        System.out.println(" the address of the store is : " + address);
//        System.out.println("------------------End of Test---------------------------");


    }


//9. Get all the services of 8th store
    @Test
    public void getAllOfTheServices(){
     List <?> listOfServices =response.extract().path("data[7].services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of the store  : " + listOfServices);
        System.out.println("------------------End of Test---------------------------");
    }




//10. Get storeservices of the store where service name = Windows Store
@Test
public void getStoreServicesOfTheStore(){
    List<HashMap<String, ?>> storeServices = response.extract().path("data.services*.findAll{it.name == 'Windows Store'}.storeservices");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println(" All the storeservices of the store where service name = Windows Store is : " + storeServices );
    System.out.println("------------------End of Test---------------------------");
}





//11. Get all the storeId of all the store
    @Test
    public void getAllStoreId(){
        List<Integer> storeId =response.extract().path("data.services.storeservices.storeId");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Get all the storeId  : " + storeId);
        System.out.println("------------------End of Test---------------------------");
    }





//12. Get id of all the store
    @Test
    public void getIdOfAllStore(){

        List<Integer> allStoreId =response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" Get id of all the store  : " + allStoreId);
        System.out.println("------------------End of Test---------------------------");

    }



//13. Find the store names Where state = ND
        @Test
    public void findStoreName(){
        List<String> StoreName = response.extract().path("data.findAll{it.state =='ND'}");
            System.out.println("------------------StartingTest---------------------------");
            System.out.println(" the store names Where state  : " + StoreName);
            System.out.println("------------------End of Test---------------------------");

        }

//14. Find the Total number of services for the store where store name = Rochester
    @Test
    public void findTotalNumberOfStoreServices(){
        List<Object> totalStore =response.extract().path("data.findAll{it.name =='Rochester'}.services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" Total number of services   : " + totalStore.size());
        System.out.println("------------------End of Test---------------------------");
    }



//15. Find the createdAt for all services whose name = “Windows Store”
@Test
public void findCreatedAtAllServices(){
    List<HashMap<String,?>> createdAt =response.extract().path("data.services*.findAll{it.name =='Windows Store'}.createdAt");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("the createdAt for all services whose name = “Windows Store”  : " + createdAt);
    System.out.println("------------------End of Test---------------------------");
}

    // 16. Find the name of all services Where store name = “Fargo”
    @Test
    public void AllServices() {
        List<HashMap<String, ?>> allServices = response.extract().path("data.services*.findAll{it.name =='Fargo'}.services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the createdAt for all services whose name = “Windows Store”  : " + allServices);
        System.out.println("------------------End of Test---------------------------");
    }



        // 17. Find the zip of all the store
        @Test
        public void findTheZipOfAllStore(){
            List<HashMap<String, ?>> allZip = response.extract().path("data.zip");
            System.out.println("------------------StartingTest---------------------------");
            System.out.println(" the zip of all the store  : " + allZip);
            System.out.println("------------------End of Test---------------------------");
        }



//18. Find the zip of store name = Roseville
@Test
public void findZipOfStoreName(){
       List<Integer > zipOfStore =response.extract().path("data.findAll{it.name =='Roseville'}.zip");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" The zip of store name = Roseville : " + zipOfStore );
        System.out.println("------------------End of Test---------------------------");
    }



//19. Find the storeservices details of the service name = Magnolia Home Theater
@Test
public void findStoreServicesOfServiceName(){
               List<HashMap<String,?>> storeServices= response.extract().path("data.services*.findAll{it.name =='Magnolia Home Theater'}");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println(" the storeservices details of the service name = Magnolia Home Theater : " + storeServices );
    System.out.println("------------------End of Test---------------------------");
}
//20. Find the lat of all the stores
@Test
public void findLatOfAllStores(){
   List<HashMap<String,?>> latOfStores =response.extract().path("data.lat");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println(" the lat of all the stores : " + latOfStores );
    System.out.println("------------------End of Test---------------------------");
}


}






