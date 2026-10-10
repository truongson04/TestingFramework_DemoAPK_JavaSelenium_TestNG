package testcases;

import Listeners.RetryAnalyzer;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class TestExercise1 extends BaseTest {
    @Test(retryAnalyzer = RetryAnalyzer.class)
    void testCartFunction(){
        ProductPage productPage = new ProductPage();
        productPage.selectTheLeastCheapestItem();
        ProductDetailPage productDetailPage = new ProductDetailPage();
        for(int i=1; i<=2; i++){
            productDetailPage.increaaseItems();
        }
        productDetailPage.selectGrayColor();
        productDetailPage.clickAddToCart();
        String actualCartNumber = productDetailPage.getElementText(productDetailPage.getCartIcon());
        Assert.assertEquals(actualCartNumber, "3");
        productDetailPage.clickCartIcon();
        CartPage cartPage = new CartPage();
        String actualPriceCart =cartPage.getElementText(cartPage.getTotalPrice());
        String actualItemPrice = cartPage.getElementText(cartPage.getProductPrice());
        Assert.assertEquals(actualItemPrice, "$7.99");
        Assert.assertEquals(actualPriceCart, "$23.97");
        cartPage.clickProceed();
        LoginPage loginPage = new LoginPage();
        loginPage.login("bob@example.com", "10203040");
        CheckOutPage checkOutPage = new CheckOutPage();
        checkOutPage.fillInFields("Son", "Hanoi", "Hadong", "NY", "Canada", "123", "Vietnam");
        CheckOutExtra checkOutExtra = new CheckOutExtra();
        checkOutExtra.fillPaymentFields("USER", "4868719196829038", "02/29", "344");
        ReviewOrder reviewOrder = new ReviewOrder();
        String actualProductPrice = reviewOrder.getElementText(reviewOrder.getReviewproductPrice());
        String acutualReviewPrice = reviewOrder.getElementText(reviewOrder.getReviewPrice());
        Assert.assertEquals(actualProductPrice, "$7.99");
        Assert.assertEquals(acutualReviewPrice,"$29.96" );

        Assert.assertTrue(reviewOrder.isElementDisplayed(reviewOrder.getCheckOutMessage()));



    }

}
