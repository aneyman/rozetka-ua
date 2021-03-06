package ui_tests;

import core.TestBase;
import org.testng.annotations.Test;
import pages.RozetkaWelcomePage;
import pages.SamsungGalaxyS5Page;
import pages.ResultPage;

import static org.testng.Assert.*;

public class SmartphoneSearchTest extends TestBase {

    RozetkaWelcomePage page = new RozetkaWelcomePage();

    SamsungGalaxyS5Page samsungGalaxyS5Page = new SamsungGalaxyS5Page();

    ResultPage searchPage = new ResultPage();

    @Test
    public void setUpPreconditions(){

        page.open();

        assertTrue(page.isOpened());

    }


    @Test(dependsOnMethods = {"setUpPreconditions"})

    public void searchSmartphoneAndVerifyCharacteristics(){

        page.searchProduct(TestData.SAMSUNG_G900H_GALAXY_S5);

        assertEquals(searchPage.verifyProductLink(), TestData.SAMSUNG_G900H_GALAXY_S5);

        searchPage.openProductLink();

        assertTrue(samsungGalaxyS5Page.verifyProductContent().getText().contains(TestData.SAMSUNG_PROCESSOR));

    }

}
