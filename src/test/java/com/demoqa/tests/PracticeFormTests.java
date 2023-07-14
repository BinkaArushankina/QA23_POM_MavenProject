package com.demoqa.tests;

import com.demoqa.data.StudentData;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.PracticeFormPage;
import com.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getForms();
        new SidePanel(driver).selectPracticeForm();
    }

    public void fillPracticeFormTest() {
        new PracticeFormPage(driver).hideIframes();
        new PracticeFormPage(driver).enterPersonalData
                ("Jack","Sparrow","jack@gmail.com", "12345678901")
                .selectGender("Male")
              //  .typeData("13 May 1835")
                .selectDate("May","1835","13")
                .addSubject(new String[]{"Maths", "Physics", "English"})
                .selectHobby(new String[]{"Sporting", "Reading", "Music"})
                .uploadFile("C:/Tools/Image2023PNG.png")
                .enterAddress("Tortuga")
                .selectState("NCR")
                .selectCity("Delhi")
                .submit();
    }


    @Test
    public void fillPracticeFormWithFinalDataTest () {
        new PracticeFormPage(driver).hideIframes();
        new PracticeFormPage(driver).enterPersonalData
                        (StudentData.FIRST_NAME,
                                StudentData.LAST_NAME,
                                StudentData.EMAIL,
                                StudentData.PHONE)
                .selectGender(StudentData.GENDER)
                .typeData(StudentData.B_DAY)
                .addSubject(StudentData.SUBJECTS)
                .selectHobby(StudentData.HOBBIES)
                .uploadFile(StudentData.PHOTO)
                .enterAddress(StudentData.ADDRESS)
                .selectState(StudentData.STATE)
                .selectCity(StudentData.CITY)
                .submit().assertTitle();

    }




}
