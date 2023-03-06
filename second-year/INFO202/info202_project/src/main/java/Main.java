import dao.JdbiDaoFactory;
import dao.ProductDAO;
import gui.MainMenu;


/**
 *
 * @author lenli455
 */
public class Main {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
            ProductDAO proDAO = JdbiDaoFactory.getProductDAO();
            MainMenu mainMenu = new MainMenu(proDAO);
            mainMenu.setLocationRelativeTo(null);
            mainMenu.setVisible(true);
        }	
}
