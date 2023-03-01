# SingtelAssignment

This is cucumber driven selenium based framework. <br>
Elements are categorised in to page object. <br>
<br>
<h2>Libraries used:</h2>
<h4>1. Selenium -Browser Automation library <br>
2. Webdriver Manager - util to pull respective browser binaries<br>
3. Junit - test control library<br>
4. Cucumber -BDD library<br>
5. Extent - Reporting library<br> </h4>

<br>
<h2>Please refer to support docs folder in dev branch for following: <h2>
<h4>1. Java docs<br>
2. Target folder with sample results and executables<br>
3. Test Results report under test-output folder <br> 
4. Test Coverage sheet <br></h4>
<br>
<br>
<h2>Framework is Java(JDK 1.8+) based maven(3.*) build: <br> </h2>

<h4>1. Clone the master branch<br>
2. Maven Commands to build and execute: <br> </h4>
	    <h5>  i) mvn clean install<br> <br>
	      ii) mvn test -Dtest="CucumberTestRunner" -Dcucumber.feature="src/test/resources/features" -Dcucumber.glue="stepdef" -Dcucumber.plugin="{ 'pretty', 'html:target/cucumber.html', 'json:target/cucumber-report/cucumber.json', 'com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:' }" <br> <br>
	      iii) Post execution find the reports at target/cucumber.html & test-output/SparkReport/Spark.html (screenshots are embedded to reports.<br> </h5>
<br><br>
<h2> Alternate way<h2> 
<h4>1. Extract the project in any IDE <br>
2. Run the CucumberTestRunner junit class under src/test/runner <br> </h4>

<br><br>

<h2> configurations </h2>
 <h4> 1. Readable config.properties file under src/test resources <br>
2. Readable extent.properties file under src/test resources </h4>
