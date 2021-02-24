package dataprovider;
import org.testng.annotations.DataProvider;

public class UserDataProvider {


        @DataProvider (name = "CreateUser")
        public static Object[][] CreateUser() // there are 2 square brackets [] [] after word Object
        {

            return new Object[][]{
                    {"Paris", "admin", "paloke0802", "jroberts", "password", ""},
                    {"Paris", "admin", "paloke0802", "", "pasword", "Mandatory field 'Username' is empty"},
                    {"Paris", "admin", "paloke0802", "samplename", "", "Mandatory field 'Password' is empty"}

            };

        }

}
