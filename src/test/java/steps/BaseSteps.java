package steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

//Probably Class to keep all steps (??)
public class BaseSteps {

        protected WebDriver driver;
        private static final org.apache.log4j.Logger LOGGER = Logger.getLogger(String.valueOf(BaseSteps.class));

        public BaseSteps(WebDriver driver){
            this.driver = driver;
        }

}
