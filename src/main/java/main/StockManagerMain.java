package main;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import entities.Address;
import entities.Customer;
import entities.Envoice;
import entities.Item;
import entities.Receipt;
import entities.Store;
import entities.Supplier;
import entities.User;
import entitiesDAO.AddressDAO;
import entitiesDAO.CustomerDAO;
import entitiesDAO.EnvoiceDAO;
import entitiesDAO.ItemDAO;
import entitiesDAO.ReceiptDAO;
import entitiesDAO.StoreDAO;
import entitiesDAO.SupplierDAO;
import entitiesDAO.UserDAO;
import jakarta.persistence.EntityManager;
import tools.JpaUtil;

public class StockManagerMain {

	private EntityManager em;
	private static final Logger logger = LogManager.getLogger(StockManagerMain.class);

	public static void main(String[] args) {

		StockManagerMain main = new StockManagerMain("HibernateOracle");

		/**
		 * NOTAS: PERSISTENCE MODE: CREATE LOG4J ---> H:TRACE Main:INFO
		 * 
		 * OBJ_Address 1. La conexión a la BBDD sirve. 2. La funcion INSERT de registro
		 * sirve. 3. Lafunción de SELECT sirve.
		 * 
		 * 
		 * OBJ_Store 1. La conexión a la BBDD sirve. 2. La funcion INSERT de registro
		 * sirve. 3. La función de SELECT sirve.
		 * 
		 * 
		 * OBJ_Supplier 1. La conexión a la BBDD sirve. 2. La función INSERT de registro
		 * sirve. 3. La función de Select sirve.
		 * 
		 * 
		 * OBJ_User 1. La conexión a la BBDD sirve. 2. La función INSERT de registro
		 * sirve. 3. La función de Select sirve.
		 * 
		 * 
		 * OBJ_Item 1. La conexión a la BBDD sirve. 2. La función INSERT de registro
		 * sirve. 3. La función de Select sirve.
		 * 
		 * OBJ_Receipt 1. La conexión a la BBDD sirve. 2. La función INSERT de registro
		 * sirve. 3. La función de Select sirve. PREGUNTAR POR LA GENERACIÓN DE LA
		 * SECUENCIA DE CODIGO.
		 * 
		 * 
		 * OBJ_Customer 1. La conexión a la BBDD sirve. 2. La función INSERT de registro
		 * sirve. 3. La función de Select sirve.
		 */

		// ADDRESS TEST
//		AddressDAO addressDAO = new AddressDAO(main.em);
//
//		Address a1 = new Address("Calle1", "Madrid", "Pinto", "28320");
//		
//		Address a2 = new Address("CalleDelete", "Madrid", "Pinto", "28320");
//
//		addressDAO.insertAddress(a1);
//		addressDAO.insertAddress(a2);
//
//		List<Address> addressList = addressDAO.selectAddress();
//
//		System.out.println("Cafe");
//				
//		System.out.println("Get by name Test");
//		
//		List <Address> addressByNameList = addressDAO.getAddressByName("CalleDelete");
//		
//		a1.setCity("Calle Actualizada");
//		
//		addressDAO.updateAddress(a1.getId(), a1);
//		
//		List <Address> updatedList = addressDAO.selectAddress();
//		
//		for (Address address : updatedList) {
//			System.out.println(address);
//		}
//		
//		addressDAO.deleteAddressByName("CalleDelete");

//		// STORE TEST
//
//		StoreDAO storeDAO = new StoreDAO(main.em);
//
//		Store s1 = new Store("Sede Pinto", "333333333", a1);
//
//		storeDAO.insertStore(s1);
////
////		List<Store> storeList = storeDAO.selectStore();
////
////		System.out.println("Cafe");
////
////		storeList.add(s1);
////
////		for (Store store : storeList) {
////			System.out.println(store);
////		}
////
////		storeList.forEach(store -> logger.info(store));
////		
//
//
//		// SUPPLIER TEST
//
//		SupplierDAO supplierDAO = new SupplierDAO(main.em);
//
//		Address aSupplier = new Address("Calle2", "Madrid", "Leganes", "87654");
//
//		Supplier sup1 = new Supplier("CRESTAS", "123456", "333444555", aSupplier);
//
//		supplierDAO.insertSupplier(sup1);
//
//		List<Supplier> supplierList = supplierDAO.selectSupplier();
//
//		System.out.println("Cafe");
//
//		supplierList.add(sup1);
//
//		for (Supplier supplier : supplierList) {
//			System.out.println(supplier);
//		}
//
//		supplierList.forEach(supplier -> logger.info(supplier));
//
//		// USER TEST
		logger.info("PRUEBA LOGGER");

		User u1 = new User("Carlos", "Jaramillo", "A1234B", "1234", "Usuario", "carlos@gmail.com", "123", "masculino",
				new Date());
		User u2 = new User("María", "González", "B5678C", "5678", "Administrador", "maria@gmail.com", "567", "femenino",
				new Date());
		User u3 = new User("Juan", "Pérez", "C91011D", "91011", "Usuario", "juan@gmail.com", "91011", "masculino",
				new Date());
		User u4 = new User("Laura", "López", "D121314E", "121314", "Usuario", "laura@gmail.com", "121314", "femenino",
				new Date());
		User u5 = new User("Ana", "Martínez", "E151617F", "151617", "Usuario", "ana@gmail.com", "151617", "femenino",
				new Date());
		User u6 = new User("Pedro", "Sánchez", "F181920G", "181920", "Usuario", "pedro@gmail.com", "181920",
				"masculino", new Date());
		User u7 = new User("Lucía", "Rodríguez", "G212223H", "212223", "Usuario", "lucia@gmail.com", "212223",
				"femenino", new Date());
		User u8 = new User("David", "García", "H242526I", "242526", "Usuario", "david@gmail.com", "242526", "masculino",
				new Date());
		User u9 = new User("Sofía", "Hernández", "I272829J", "272829", "Usuario", "sofia@gmail.com", "272829",
				"femenino", new Date());
		User u10 = new User("Diego", "Fernández", "J303132K", "303132", "Usuario", "diego@gmail.com", "303132",
				"masculino", new Date());

		UserDAO userDAO = new UserDAO(main.em);

		userDAO.insertUser(u1);
		userDAO.insertUser(u2);
		userDAO.insertUser(u3);
		userDAO.insertUser(u4);
		userDAO.insertUser(u5);
		userDAO.insertUser(u6);
		userDAO.insertUser(u7);
		userDAO.insertUser(u8);
		userDAO.insertUser(u9);
		userDAO.insertUser(u10);

//		List<User> userList = userDAO.selectUser();

//
//		for (User user : userList) {
//			System.out.println(user);
//		}
//
//		userList.forEach(user -> logger.info(user));

		List<User> userListNameASC = userDAO.ascListName();

		for (User user : userListNameASC) {
			System.out.println(user.getName());
		}

		List<User> userListDniASC = userDAO.ascListDNI();

		for (User user : userListDniASC) {
			System.out.println(user.getDni());
		}

//		
//		//ITEM TEST
//		
//		Item i1 = new Item("000","itemTest",100.00,"kindTest",5,s1);
//		
//		ItemDAO itemDao = new ItemDAO (main.em);
//		
//		
//		itemDao.insertItem(i1);
//		
//		List<Item> itemList = itemDao.selectItem();
//
//		itemList.forEach(item -> logger.info(item));
//		
//		
//		//ITEM RECEIPT
//		
//		Receipt receiptTest = new Receipt (new Date(),"Coment",sup1,u1);
//		
//		ReceiptDAO receiptDao = new ReceiptDAO (main.em);
//		
//		receiptDao.insertReceipt(receiptTest);
//
//		List<Receipt> receiptList = receiptDao.selectReceipt();
//
//		receiptList.forEach(receipt -> logger.info(receipt));
//		
//		//TEST CUSTOMER
//		
//		Address customerAddress = new Address ("Calle","Tarragona","cataluña","test"); 
//		Customer customerTest = new Customer ("CustomerTest","asdqwe","333333333",customerAddress,"ObservationTest");
//		
//		CustomerDAO customerDao = new CustomerDAO (main.em);
//		
//		customerDao.insertCustomer(customerTest);

//		List<Customer> customerList = customerDao.selectCustomer();

//		customerList.forEach(customer -> logger.info(customer));
//		
//		
//		//TEST ENVOICE
//		
//		Envoice envoiceTest = new Envoice (new Date(),"x",customerTest,u1);
//		
//		EnvoiceDAO envoiceDao = new EnvoiceDAO (main.em);
//		
//		envoiceDao.insertEnvoice(envoiceTest);
//		
//		List<Envoice> envoiceList = envoiceDao.selectEnvoice();
//
//		envoiceList.forEach(envoice -> logger.info(envoice));

	}

	// CONSTRUCTOR
	public StockManagerMain(String persistenceUnit) {
		super();
		this.em = JpaUtil.getEM(persistenceUnit);
	}

}
