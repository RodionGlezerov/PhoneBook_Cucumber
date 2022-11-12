package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.rmi.MarshalledObject;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LoginSteps {

    WebDriver driver;

    @Given("Navigate to Page Phone Book")
    public void navigateToLoginPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://contacts-app.tobbymarshall815.vercel.app/home");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @When("Click on Login tab")
    public void clickOnLoginTab(){
        click(By.xpath("//a[.='LOGIN']"));
    }

    @Then("Appear LoginRegistration form")
    public void isLoginRegFormPresent(){
        Assert.assertTrue(isElementPresent(By.cssSelector(".login_login__3EHKB")));
    }

    @And("Enter the valid data")
    public void enterValidData(){
        type(By.cssSelector("[placeholder='Email']"),"Man@gmail.com");
        type(By.cssSelector("[placeholder='Password']"),"Aa123456789~");
    }

    @And("Click Login Button")
    public void clickOnLoginButton(){
        click(By.xpath("//button[.=' Login']"));
    }

    @Then("SignOut button displayed")
    public void isSignOutButtonPresent(){
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));
    }

    @And("Enter the valid email and an invalid password")
    public void enterInvalidPassword(DataTable table){
        List<Map<String,String>> dataTable = table.asMaps();
        String email = dataTable.get(0).get("email");
        String password = dataTable.get(0).get("password");

        type(By.cssSelector("[placeholder='Email']"),email);
        type(By.cssSelector("[placeholder='Password']"),password);
    }

    @And("Click ADD Button")
    public void clickAddButton(){
        click(By.xpath("//*[.='ADD']"));
    }
    @And("Enter Valid Contact Information")
    public void enterValidContactInformation(DataTable table){
        List<Map<String,String>> dataTable = table.asMaps();
        String name = dataTable.get(0).get("name");
        String lastName = dataTable.get(0).get("lastName");
        String phone = dataTable.get(0).get("phone");
        String email = dataTable.get(0).get("email");
        String address = dataTable.get(0).get("address");
        String description = dataTable.get(0).get("description");

        type(By.cssSelector("[placeholder='Name']"),name);
        type(By.cssSelector("[placeholder='Last Name']"),lastName);
        type(By.cssSelector("[placeholder='Phone']"),phone);
        type(By.cssSelector("[placeholder='email']"),email);
        type(By.cssSelector("[placeholder='Address']"),address);
        type(By.cssSelector("[placeholder='description']"),description);

    }

    @And("Click Save")
    public void clickSaveButton(){
        click(By.xpath("//button[.='Save']"));
    }

    @Then("Appear New Contact")
    public void isContactPresent(){
        pause(1000);
        Assert.assertTrue(isElementPresent(By.xpath("//*[text()='Tom']")));
    }

    @Then("Alert appeared")
    public void isAlertAppeared(){
        Assert.assertTrue(isAllertPresent());
    }

    public boolean isAllertPresent() {
        Alert alert = new WebDriverWait(driver,10).until(ExpectedConditions.alertIsPresent());
        if (alert == null){
            return false;
        } else {
            driver.switchTo().alert().accept();
            return true;
        }
    }

    public void type(By locator, String text) {
        if (text != null){
            click(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size()>0;
    }


    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void pause (int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
