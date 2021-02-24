package dataprovider;
import org.testng.annotations.DataProvider;

public class CustomerDataProvider {


        @DataProvider(name = "CreateCustomer")
        public static Object[][] CreateCustomer() // there are 2 square brackets [] [] after word Object
        {

            return new Object[][]{
                    {"Paris", "admin", "paloke0802", "Julia", "Roberts", ""},
                    {"Paris", "admin", "paloke0802", "", "Gaga", "Mandatory field 'firstname' is empty"},
                    {"Paris", "admin", "paloke0802", "Lady", "", "Mandatory field 'lastname' is empty"}

            };

        }

}
