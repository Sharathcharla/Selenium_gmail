package StepDefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Steps {
    WebDriver dr;
    @Given("navigate to Gmail page")
    public void navigateToGmailPage() {
        WebDriverManager.chromedriver().setup();
        dr=new ChromeDriver();
        dr.get("http://www.gmail.com");
    }
    //user logged in using username as \"([^\"]*)\" and password as “<password>”
    @When("user logged in using username as <username> and password as <password>")
    public void userLoggedInUsingUsernameAsUsernameAndPasswordAsPassword() {
        dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        dr.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("");
        dr.findElement(By.id("identifierNext")).click();
        dr.findElement(By.xpath("//input[@name='password']")).sendKeys("");
        dr.findElement(By.id("passwordNext")).click();
        throw new io.cucumber.java.PendingException();
    }

    @Then("^home page should be displayed$")
    public void verifySuccessful(){
        String actualLinkText = dr.getCurrentUrl().toLowerCase();
        if(actualLinkText.contains("inbox")) {
            System.out.println("Login successful");
        }}
    @And("^compose the email$")
    public void compose(String to, String subject,String message){
        dr.findElement(By.xpath("//div[2]/div[2]/div[1]/div[1]/div/div")).click();
        dr.findElement(By.xpath("//*[@id=\":vy\"]")).sendKeys(to);//to whose email we want to send their email is taken as to
        dr.findElement(By.xpath("//*[@id=\":s2\"]")).sendKeys(subject);//subject of email
        dr.findElement(By.xpath("//*[@id=\":t9\"]")).sendKeys(message);//message to send
        dr.findElement(By.xpath("//*[@id=\":rs\"]")).click();//click this to send

    }
}
