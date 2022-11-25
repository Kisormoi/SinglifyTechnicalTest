package com.seasonalloan.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Dorothy.Kisormoi
 *
 */
public class HomePage {
	WebDriver ldriver;

	public HomePage(WebDriver driver) {

		this.ldriver = driver;
		PageFactory.initElements(driver, this);

	}

//using id locator but since we have no browser to pick locator from - will name them as the field names
	@FindBy(id = "creditAmount")
	WebElement creditAmount;

	@FindBy(id = "NumberofMonths")
	WebElement numberofMonths;

	@FindBy(id = "LoanProduct")
	WebElement loanProduct;

	@FindBy(id = "ExpectedDisbursementDate")
	WebElement expectedDisbursementDate;

	@FindBy(id = "MonthlyDueDate")
	WebElement monthlyDueDate;

	@FindBy(id = "submit")
	WebElement submit;

	/*
	 * Working on a scenario where the loanee applying for a loan with a loan term
	 * of 60 months with non negotiable interest,processing fee,administrative fee
	 * and risk fee
	 */
	public void validLoanOfferEntry() {

		creditAmount.sendKeys("10000");
		numberofMonths.sendKeys("60");
		Select select2 = new Select(loanProduct);
		select2.selectByVisibleText("PA_EASI_LEI");
		Select select1 = new Select(expectedDisbursementDate);
		select1.selectByVisibleText("31/03/2021");
		monthlyDueDate.sendKeys("10");
		submit.submit();
	}

	/*
	 * Working on a scenario where the loanee applying for a loan with a loan term
	 * of 61 months with non negotiable interest,processing fee,administrative fee
	 * and risk fee
	 */
	public void invalidLoanOfferEntry() {

		creditAmount.sendKeys();
		numberofMonths.sendKeys("61");
	}
}