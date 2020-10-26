package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.sql.SQLOutput;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FindTransactionPage extends BasePage {

    @FindBy(xpath = "//input[@type='text'][contains(@id,'fromDate')]")
    public WebElement fromDateBox;

    @FindBy(xpath = "//input[@type='text'][contains(@id,'toDate')]")
    public WebElement toDateBox;

    @FindBy(xpath = "//button[@type='submit'][contains(.,'Find')]")
    public WebElement findButton;

    @FindBy(xpath = "//input[@type='text'][contains(@id,'description')]")
    public WebElement descriptionBox;



    @FindBy(xpath = "(//table)[2]/tbody/tr")
    public List<WebElement> rowsOf01_06;

    int numberOfRows01_06 = rowsOf01_06.size();


    @FindBy (xpath = "(//table)[2]/tbody/tr/td[1][contains(text(),'2012-09')]")
    public List<WebElement> dateRows;

    public void compareDatesWithinDateRange(String fromDate, String toDate) throws ParseException {
        fromDateBox.clear();
        toDateBox.clear();
        List<String> dateRowsString = BrowserUtils.getElementsText(dateRows);

            try{
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date Fdate = format.parse(fromDate);
                java.util.Date tdate = format.parse(toDate);
                for (String ActualDate : dateRowsString) {
                    java.util.Date date =format.parse(ActualDate);
                    Assert.assertTrue(date.compareTo(Fdate)>=0 && date.compareTo(tdate)<=0);
                }
            }catch (Exception e){
                e.printStackTrace();
            }



    }




//old version of verify range date
    /*
    public void compareDateRows(String fromDate, String toDate){
        fromDateBox.clear();
        toDateBox.clear();
        String fromToDates01_06 ="";
        String fromToDates02_06 ="";

        if (fromDate.equals("2012-09-01") && toDate.equals("2012-09-06")){
            List<String> dateRows01_06 = BrowserUtils.getElementsText(dateRows);


            System.out.println("dateRows01_06 = " + dateRows01_06);
            fromToDates01_06 = "2012-09-01 2012-09-02 2012-09-03 2012-09-04 2012-09-05 2012-09-06";
            for (String s : dateRows01_06) {
                Assert.assertTrue(fromToDates01_06.contains(s));

            }
        }else{
            List<String> dateRows02_06 = BrowserUtils.getElementsText(dateRows);
            System.out.println("dateRows01_06 = " + dateRows02_06);
            fromToDates02_06 = "2012-09-02 2012-09-03 2012-09-04 2012-09-05 2012-09-06";
            for (String s : dateRows02_06) {
                Assert.assertTrue(fromToDates02_06.contains(s));

            }
        }

    }
 */

    public void isdateRows02_06ContainsDate(String date){
        List<String> dateRows02_06 = BrowserUtils.getElementsText(dateRows);
       Assert.assertFalse(dateRows02_06.contains(date));
       /*
        for (String s : dateRows02_06) {
            Assert.assertFalse(s.equals(date));
        }

        */


    }

    //Sort of dates

     public void sortOfDates(){
         List<String> dateList1 = BrowserUtils.getElementsText(dateRows);

         System.out.println("BEFORE SORTED datelist1");
         for (String s1 : dateList1) {
             System.out.println(s1);
         }
         List<String> dateList2 = new ArrayList<>();
         for (int i = 0; i < dateList1.size(); i++) {
              dateList2.add(dateList1.get(i));

         }
         System.out.println("dateList2");
         for (String s : dateList2) {
             System.out.println(s);

         }

         //sort Method
         sortDates(dateList1);


         System.out.println("AFTER SORTED dateList1");
         for (String s1 : dateList1) {
             System.out.println(s1);
         }
         int size = dateList1.size();
         System.out.println("COMPARATION TWO DATE LIST ");
         for (int i = dateList1.size()-1, j = 0; i >= 0; i--,j++) {
             System.out.println(dateList1.get(i));
             System.out.println(dateList2.get(j));
             Assert.assertTrue(dateList1.get(i).equals(dateList2.get(j)));

         }

     }
     public static void sortDates (List<String> dateList){
         Collections.sort(dateList, new Comparator<String>() {
             DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
             //OR
             //DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd '@'hh:mm a");
             @Override
             public int compare(String o1, String o2) {
                 try{
                     //date comparations happens here
                     return dateFormat.parse(o1).compareTo(dateFormat.parse(o2));
                 }catch (ParseException e){
                     throw new IllegalArgumentException(e);
                 }
             }
         });
     }

     @FindBy(xpath = "(//table)[2]/tbody/tr/td[2]")
    public List<WebElement> descriptionColumn;


    //verify result table has only ONLINE transfers
    public  void hasreultTableDescription(String description){
        descriptionBox.clear();
        List<String> listOfDescriptons = BrowserUtils.getElementsText(descriptionColumn);
        System.out.println(listOfDescriptons);
        for (String listOfDescripton : listOfDescriptons) {
            Assert.assertTrue(listOfDescripton.contains(description));

        }
    }
    //verify that results table should not have Online transfers
    public void resultTableHasNotDescription(String description){
        List<String> listOfDescriptons = BrowserUtils.getElementsText(descriptionColumn);
        Assert.assertFalse(listOfDescriptons.contains(description));

    }

    @FindBy(xpath = "(//table)[2]/tbody/tr/td[3]")
    public List<WebElement> depositRow;

    @FindBy(xpath = "(//table)[2]/tbody/tr/td[4]")
    public List<WebElement> withdrawalRow;

    //deposit table reults
    public void getDepositTableResult(){
        List<String> depositResultTable = BrowserUtils.getElementsText(depositRow);
        System.out.println(depositResultTable);
        int count= 0;
        for (String s : depositResultTable) {
            if (s.length() > 0) {
                count++;
            }
        }
        Assert.assertTrue(count > 0);

    }

    //withdrawal table rusult
    public void getWithdrawaTableResult(){
        List<String> withdrawalTableResult = BrowserUtils.getElementsText(withdrawalRow);
        System.out.println(withdrawalTableResult);
        int count= 0;
        for (String s :withdrawalTableResult) {
            if (s.length() > 0) {
                count++;
            }

        }
        Assert.assertTrue(count>0);
    }
    // type options
    @FindBy(xpath = "//select[contains(@name,'type')]")
    public WebElement typeOptions;

    public void selectType(String type){
        Select typedropdown = new Select(typeOptions);
        typedropdown.selectByVisibleText(type);

    }
    //result table has no result under withdrawal
    public void noResultUnderWithdrawal(){
        List<String> withdrawalTableResult = BrowserUtils.getElementsText(withdrawalRow);
        System.out.println(withdrawalTableResult);
        int count= 0;
        for (String s :withdrawalTableResult) {
            if (s.length() > 0) {
                count++;
            }

        }
        Assert.assertTrue(count==0);

    }
    //reault table has no result under deposit
    public void noResultUnderDeposit(){
        List<String> depositResultTable = BrowserUtils.getElementsText(depositRow);
        System.out.println(depositResultTable);
        int count= 0;
        for (String s : depositResultTable) {
            if (s.length() > 0) {
                count++;
            }
        }
        Assert.assertTrue(count == 0);


    }



















}
