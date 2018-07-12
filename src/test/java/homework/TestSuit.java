package homework;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSuit extends BaseTest
{
    //LoadProp loadProp = new LoadProp();

    @Test

    public void toVerifyUserShouldBeAbleToFinishOrderSuccessfully()
    {
        clickOnElement(By.linkText("Jewelry"));
        clickOnElement(By.xpath("//*[@class='item-grid']/div[2]/div/div[2]/div[3]/div[2]/input[1]"));
        waitForElementToBeInvisible(By.linkText("shopping cart"),20);
        clickOnElement(By.xpath("//*[@class='item-grid']/div[3]/div/div[2]/div[3]/div[2]/input[1]"));
        clickOnElement((By.linkText("shopping cart")));
        clearAndEnterText(By.xpath("//*[@value='1']"),"2");
        clickOnElement(By.name("updatecart"));
        clickOnElement(By.id("checkout"));
        Assert.assertEquals(getTextFromElement(By.id("terms-of-service-warning-box")),"Please accept the terms of service before the next step.");
        clickOnElement(By.xpath("//*[@title='close']"));
        clickOnElement(By.id("termsofservice"));
        clickOnElement(By.id("checkout"));
        clickOnElement(By.xpath("//*[@value='Checkout as Guest']"));
        enterText(By.id("BillingNewAddress_FirstName"),"Meera");
        enterText(By.id("BillingNewAddress_LastName"),"Shah");
        String email = "meerashah"+timestamp()+"@gmail.com";
        clearAndEnterText(By.id("BillingNewAddress_Email"),email);
        selectByVisibleText(By.id("BillingNewAddress_CountryId"),"United Kingdom");
        enterText(By.id("BillingNewAddress_City"),"London");
        enterText(By.id("BillingNewAddress_Address1"), "112 sainath");
        enterText(By.id("BillingNewAddress_ZipPostalCode"), "OX3 4BH");
        enterText(By.id("BillingNewAddress_PhoneNumber"), "07654367876");
        clickOnElement(By.xpath("//input[@title='Continue']"));
        clickOnElement(By.id("shippingoption_1"));
        clickOnElement(By.xpath("//input[@onclick='ShippingMethod.save()']"));
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//input[@onclick='PaymentMethod.save()']"));
        enterText(By.id("CardholderName"),"Noah Evans");
        enterText(By.id("CardNumber"),"4256974421703710");
        selectByIndex(By.id("ExpireMonth"),2);
        selectByIndex(By.id("ExpireYear"),6);
        enterText(By.id("CardCode"),"511");
        clickOnElement(By.xpath("//input[@onclick='PaymentInfo.save()']"));
        waitAndClick(By.xpath("//*[@id='confirm-order-buttons-container']/input"),10);
        waitForElementToBeInvisible(By.xpath("//*[@id='confirm-order-buttons-container']/input"),10);
        Assert.assertEquals(getTextFromElement(By.xpath("//*[@class='title']")),"Your order has been successfully processed!");
        //Assert.assertEquals(getTextFromElement(By.xpath("//input[@value='Continue']")),"CONTINUE");
        Assert.assertEquals(getTextFromElement(By.xpath("//input[@value='Continue']")),"");
        Assert.assertEquals(driver.getCurrentUrl(),"http://demo.nopcommerce.com/checkout/completed/");

    }

    @Test

    public static void toVerifyUserShouldBeAbleToChangeCurrencyToEuro()
    {
        selectByIndex(By.id("customerCurrency"),1);
        Assert.assertEquals(getTextFromElement(By.xpath("//*[@class='price actual-price']")),"€1140.00");
        Assert.assertEquals(getTextFromElement(By.xpath("//*[@class='item-grid']/div[2]/div/div[2]/div[3]/div/span")),"€1710.00");
        Assert.assertEquals(getTextFromElement(By.xpath("//*[@class='item-grid']/div[3]/div/div[2]/div[3]/div/span")),"€232.75");
        Assert.assertEquals(getTextFromElement(By.xpath("//*[@class='item-grid']/div[4]/div/div[2]/div[3]/div/span")),"€23.75");
        System.out.println("Build Your Own Computer : "+getTextFromElement(By.xpath("//*[@class='price actual-price']")));
        System.out.println("Apple Mac-Book Pro 13 inch : "+getTextFromElement(By.xpath("//*[@class='item-grid']/div[2]/div/div[2]/div[3]/div/span")));
        System.out.println("HTC One M8 Android Lolipop : "+getTextFromElement(By.xpath("//*[@class='item-grid']/div[3]/div/div[2]/div[3]/div/span")));
        System.out.println("Virtual Gift Card : "+getTextFromElement(By.xpath("//*[@class='item-grid']/div[4]/div/div[2]/div[3]/div/span")));

    }

    @Test

    public static void toVerifyUserShouldBeAbleToSendProductEmailToFriend()
    {
        clickOnElement(By.xpath("//img[@title='Show details for $25 Virtual Gift Card']"));
        clickOnElement(By.xpath("//input[@value='Email a friend']"));
        String email = "Rahi"+ timestamp()+"@gmail.com";
        enterText(By.id("FriendEmail"),email);
        String myemail = "Meerashah"+ timestamp()+"@gmail.com";
        enterText(By.id("YourEmailAddress"),myemail);
        enterText(By.id("PersonalMessage"),"Hi, Rahi Have a look on this item.");
        clickOnElement(By.name("send-email"));
        Assert.assertEquals(getTextFromElement(By.xpath("//*[@class='message-error validation-summary-errors']")),"Only registered customers can use email a friend feature");
    }
}
