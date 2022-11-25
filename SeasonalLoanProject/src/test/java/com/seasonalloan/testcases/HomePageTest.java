package com.seasonalloan.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.seasonalloan.base.BaseClass;
import com.seasonalloan.pageobjects.HomePage;

/**
 * @author Dorothy.Kisormoi
 *
 */
public class HomePageTest extends BaseClass {
	HomePage lo = new HomePage(driver);

	@Test
	/*
	 * Verify when user enters valid loan term the user is navigated to the LoanTerm
	 * Schedule page
	 */
	public void verifyValidLoanTerm() throws Throwable {

		lo.validLoanOfferEntry(); // calls the validLoanOfferEntry method
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "Expected url";
		Assert.assertEquals(actualURL, expectedURL);

	}

//Verify when user enters invalid loan term the correct warning message pops_up
	public void verifyInvalidLoanTerm() {

		lo.invalidLoanOfferEntry();// calls the validLoanOfferEntry method
		String actualMessage = driver.findElement(By.id("LoanTerm error")).getText();
		String expectedMessage = "Numarul de luni trebuie sa fie intre 1 si 60";
		Assert.assertEquals(actualMessage, expectedMessage);

	}
}