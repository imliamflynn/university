package otago.examiner;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;


@DataJpaTest
@SpringBootTest() 
@ActiveProfiles("test") 
public class ExaminerApplicationTests {

        @Autowired
        //private Users<user>;
  
	@Test
	public void CreateNewUser() {
            inputIsCorrectFormat();
            userIsInsertedInDatabase();
	}

        private void userIsInsertedInDatabase() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private void inputIsCorrectFormat() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
        //@Test
	//public void CreateNewUser() {
         //   inputIsCorrectFormat();
         //  userIsInsertedInDatabase();
	///}

}
