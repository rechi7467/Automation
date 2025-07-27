// package pages;

// import io.appium.java_client.android.AndroidDriver;
// import io.appium.java_client.pagefactory.AndroidFindBy;
// import org.openqa.selenium.WebElement;

// public class StartTimer extends BasePage{
//     @AndroidFindBy(id = "com.google.android.deskclock:id/timer_setup_digit_8")
//     private WebElement number8;

//     @AndroidFindBy(id = "com.google.android.deskclock:id/timer_setup_time")
//     private WebElement end;
//     public StartTimer(AndroidDriver driver){
//         super(driver);
//     }
//     public void findTime(){
//         elementToBeClickable(number8).click();

//         if( visibilityOf(end).getText().contains(number8.getText())
//     }
// }
package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class StartTimer extends BasePage {
    @AndroidFindBy(id = "com.google.android.deskclock:id/timer_setup_digit_8")
    private WebElement number8;

    @AndroidFindBy(id = "com.google.android.deskclock:id/timer_setup_time")
    private WebElement end;

    public StartTimer(AndroidDriver driver) {
        super(driver);
    }

    public void findTime() {
        elementToBeClickable(number8).click();

        if (visibilityOf(end).getText().contains(number8.getText())) {
            // כאן תוכל להוסיף את הקוד שצריך שירוץ אם התנאי מתקיים
            System.out.println("Timer setup contains number 8");
        }
    }
}
