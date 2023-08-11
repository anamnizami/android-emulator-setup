package com.egym.util;

import java.util.Random;


public class SpecialProductsData {

    public static String  noImage() { //Note: Recommended price is not available for all the sales channel

        String[] PDPNoImage = {"2130-0500", "2380-107839"};

        return (PDPNoImage[new Random().nextInt((PDPNoImage.length))]);
    }

    public static String productListForCheckout() {
        String[] productList = {"2320-11832", "GKNP10057"};
        return (productList[new Random().nextInt((productList.length))]);
    }

    public static String preishammerLogo() {

        String[] preisHammerLogoProduct = {"1610-0226", "15605239", "2310-4023"};

        return (preisHammerLogoProduct[new Random().nextInt((preisHammerLogoProduct.length))]);
    }

    public static String disclaimerProduct() {
        //update product group to cover more article_type: turbocharger, battery, waste_oil, tyre_pressure
        String[] disclaimerProduct = {"135013077"};

        return (disclaimerProduct[new Random().nextInt((disclaimerProduct.length))]);
    }

    public static String universalProduct() {
        String[] universalProduct = {"2320-11655", "2320-113654", "2320-113738", "2380-102247"};

        return (universalProduct[new Random().nextInt((universalProduct.length))]);
    }

    public static String pdfForProduct() {
        String[] pdfForProduct = {"2330-4756", "2030-105360", "1732-109021", "1720-129811", "2330-4696"};

        return (pdfForProduct[new Random().nextInt((pdfForProduct.length))]);
    }

    public static String pricePerUnitProduct() {
        String[] pricePerUnitProduct = {"2360-17383", "2320-12364", "2320-12425"};

        return (pricePerUnitProduct[new Random().nextInt((pricePerUnitProduct.length))]);
    }

    public static String carTableProduct() {
        String[] carTableProduct = {"2010-7160"};

        return (carTableProduct[new Random().nextInt((carTableProduct.length))]);
    }

    public static String oeNumberProduct() {
        String[] oeNumberProduct = {"46337942"};

        return (oeNumberProduct[new Random().nextInt((oeNumberProduct.length))]);
    }

    public static String defaultQuantityProduct() {

        String[] quantityProduct = {"1420-125094"};
        return (quantityProduct[new Random().nextInt((quantityProduct.length))]);
    }

    public static String carSpecificProduct() {

        String[] quantityProduct = {"2270-7826", "2380-1551"};

        return (quantityProduct[new Random().nextInt((quantityProduct.length))]);
    }

    public static String productDisplaySku() {

        String[] product = {"gn857", "220124s"};

        return (product[new Random().nextInt((product.length))]);
    }

    public static String productSku() {

        String[] product = {"1620-6895", "2040-108057"};

        return (product[new Random().nextInt((product.length))]);
    }

    public static String productName() {

        String[] product = {"filter"};

        return (product[new Random().nextInt((product.length))]);
    }

    public static String productCompetitorPartNumber() {

        String[] product = {"pk297"};

        return (product[new Random().nextInt((product.length))]);
    }

    public static String productEan() {

        String[] product = {"1021300000018"};

        return (product[new Random().nextInt((product.length))]);
    }

    public static String productNotMatchingGolf3() {

        String[] product = {"1520-7322"};

        return (product[new Random().nextInt((product.length))]);
    }
    public static String productMatchingGolf3() {

        String[] product = {"1420-15234"};

        return (product[new Random().nextInt((product.length))]);
    }

    public static String braincraftProducts() {

        String[] product = {"2360-0150", "2340-100484"};

        return (product[new Random().nextInt((product.length))]);
    }
    //To-do: Add more art numbers that return compatible PLPs. Number of products <20 & multiple availabilities.
    public static String productListAllAvailabilities() {

        String[] product = {"2006"};

        return (product[new Random().nextInt((product.length))]);
    }

    public static String qaIntEnvironmentsProduct() {

        String[] product = {"1035-4360", "1560-0387", "1720-9845"};

        return (product[new Random().nextInt((product.length))]);
    }
}
