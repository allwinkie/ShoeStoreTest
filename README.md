# ShoeStoreTest
shoe store example using selenium and java
go to http://shoestore-manheim.rhcloud.com/definition
to get the acceptance criteria


        /**
         * I had problems getting this to work in eclipse- i use intelej
         * git clone https://github.com/allwinkie/ShoeStoreTest.git
         * then import a local maven project in eclipse
         */
       /**
         * Created by allwinkie on 2/18/16.
         * testplan Accptance Criteria 1
         * 1) have firefox open home page
         * 2) open month
         * 3) check if there are any shoes - if not assert error
         * 4)check each shoe for text,image,name,brand - if not assert error
         * 5) the program loops through all the months
         * 6) - I handeled the java exception for the assertion error( is supposed to fail) 
         * to make a clean execution
         * 7) added main to make executable, and added log4j, testNG
         * --- test dynamically determines number of shoes and checks each, because of changing stock
         */
        
          /**
         * Created by allwinkie on 2/18/16.
         * testplan Accptance Criteria 2
         * 1) have firefox open each page with the email entry
         * 2) add email
         * 3) check to see if the flash message is sent- if not assert error
         * 4) added main to make executable, and added log4j, testNG
         * if new page is created with same email box , add url to list ( in real world would be on a csv and read) 
         *
         */
  
