package allControllers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import daopackage.AddToCartDao;
import daopackage.AdminDao;
import daopackage.ToyDao;
import daopackage.UserDao;
import dtopackage.AddToCartDto;
import dtopackage.AdminDto;
import dtopackage.ToyStoreDto;
import dtopackage.UserDto;

public class AllControllers {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) throws SQLException, IOException {
		AddToCartDao ato=new AddToCartDao();
		ato.deleteAddToCartTable();
		System.out.println("===WEILCOME TO TOY STORE===");
		boolean allcheck=true;
		do {
			System.out.println("Enter the choice \n 1.Admin \n 2.User \n 3.Exit");
			int allkey=s.nextInt();
			switch (allkey) {
			case 1:{
				System.out.println("Admin");
				boolean admincheck1=true;
				do {
					System.out.println("enter the choice \n 1.Register \n 2.Login \n 3.Exit");
					int adminregisterkey=s.nextInt();
					switch (adminregisterkey) {
					case 1:{
						System.out.println("Please Give me the Details For Registration");
						saveAdmin();
					}break;
					case 2:{
						System.out.println("login Admin");
						AdminDto adminadto = loginAdmin();
						if(adminadto !=null) {
							boolean loginadminallprofile=true;
							do {
								System.out.println("enter the choice admin \n 1.Profile \n 2.Toystore \n 3.Exit");
								int protoystoreexit=s.nextInt();
								switch (protoystoreexit) {
								case 1:{
										boolean fupdepfe=true;
										do {
											System.out.println("enter the choice \n 1.fetch \n 2.update profile \n 3.delete profile \n 4.exit");
											int admincrudkey=s.nextInt();
											switch (admincrudkey) {
											case 1:{
												fetchAdmin(adminadto.getEmail());
											}break;
											case 2:{
												boolean updateadmin=true;
												do {
													System.out.println("enter the choice \n 1.name \n 2.email \n 3.password \n 4.Exit");
													int updateadminall=s.nextInt();
													switch (updateadminall) {
													case 1:{
														updateAdminName(adminadto.getEmail());
													}break;
													case 2:{
														updateAdminMail(adminadto.getEmail());
														updateadmin=false;
														admincheck1=false;
														fupdepfe=false;
														loginadminallprofile=false;
													}break;
													case 3:{
														updateAdminPassword(adminadto.getEmail());
														updateadmin=false;
														admincheck1=false;
														fupdepfe=false;
														loginadminallprofile=false;
													}break;
													case 4:{
														System.out.println("===EXIT FROM ADMIN CRUD OPERATIONS===");
														updateadmin=false;
													}break;
													default:System.out.println("Enter the Right Choice...!!!");
														break;
													}
												} while (updateadmin);
											}break;
											case 3:{
												deleteAdmin(adminadto.getEmail());
												fupdepfe=false;
												admincheck1=false;
												loginadminallprofile=false;
											}break;
											case 4:{
												System.out.println("===EXIT FROM ADMIN CRUD===");
												fupdepfe=false;
											}break;
											default:System.out.println("Enter the Right Choice...!!!");
												break;
											}
										} while (fupdepfe);
								}break;
								case 2:{
									System.out.println("===WELCOME "+adminadto.getName()+" ===");
									boolean toystore=true;
									do {
										System.out.println("enter the choice \n 1.Upload toy \n 2.Update Toy \n 3.Fetch toy \n 4.Exit");
										int uploadupdatefetchexit=s.nextInt();
										switch (uploadupdatefetchexit) {
										case 1:{
											saveToyDetails(adminadto.getEmail());
										}break;
										case 2:{
											boolean updatetoy=true;
											do {
												System.out.println("Enter the choice \n 1.ToyName \n 2.Price \n 3.quantity \n 4.exit");
												int toynamepricequantityexitkey=s.nextInt();
												switch (toynamepricequantityexitkey) {
												case 1:{
													toyNameUpdate(adminadto.getEmail());
												}break;
												case 2:{
													toyPriceUpdate(adminadto.getEmail());
												}break;
												case 3:{
													toyQuantityUpdate(adminadto.getEmail());
												}break;
												case 4:{
													System.out.println("===EXIT FROM TOY CRUD OPERATIONS===");
													updatetoy=false;
												}break;
												default:System.out.println("Enter the Right Choice...!!!");
													break;
												}
											} while (updatetoy);
										}break;
										case 3:{
											fetchToy(adminadto.getEmail());
										}break;
										case 4:{
											System.out.println("===EXIT FROM TOY STORE===");
											toystore=false;
										}break;
										default:System.out.println("Enter the Right Choice...!!!");
											break;
										}
									} while (toystore);
								}break;
								case 3:{
									System.out.println("EXIT ADMIN IN PROFILE");
									loginadminallprofile=false;
								}break;
								default:System.out.println("Enter the Right Choice...!!!");
									break;
								}
							} while (loginadminallprofile);
						}
					}break;
					case 3:{
						System.out.println("Exit Admin");
						admincheck1=false;
					}break;
					default:System.out.println("Enter the Right Choice...!!!");
						break;
					}
				} while (admincheck1);
			}break;
			case 2:{
				System.out.println("===WELCOME USER 🙏🙏🙏===");
				boolean usercheck=true;
				do {
					System.out.println("enter teh choice \n 1.Register \n 2.login \n 3.Exit");
					int userkey=s.nextInt();
					switch (userkey) {
					case 1:{
						saveUser();
					}break;
					case 2:{
						System.out.println("===USER LOGIN===");
						UserDto userdto = loginUser();
						if(userdto != null) {
							boolean usercheck1=true;
							do {
								System.out.println("enter teh choice \n 1.profile \n 2.Toy store \n 3.Exit");
								int userprofiletoystoreexit=s.nextInt();
								switch (userprofiletoystoreexit) {
								case 1:{
									System.out.println("===USER PROFILR===");
									boolean profileusertoy=true;
									do {
										System.out.println("ENTER THE CHOICE \n 1.FETCH DETAILS \n 2.UPDATE \n 3.DELETE PROFILE \n 4.EXIT");
										int userdetailskey=s.nextInt();
										switch (userdetailskey) {
										case 1:{
											fetchUser(userdto.getMailid());
										}break;
										case 2:{
											System.out.println("===UPDATE PROFILE===");
											boolean updateuserprofilecheck=true;
											do {
												System.out.println("ENTER THE CHOICE \n 1.NAME \n 2.PHONE \n 3.EMAIL \n 4.PASSWORD \n 5.WALLET \n 6.EXIT");
												int updateuserprofileallkey=s.nextInt();
												switch (updateuserprofileallkey) {
												case 1:{
													updateUserName(userdto.getMailid());
												}break;
												case 2:{
													updateUserPHONE(userdto.getMailid());
												}break;
												case 3:{
													updateUserMilid(userdto.getMailid());
													updateuserprofilecheck=false;
													profileusertoy=false;
													usercheck1=false;
													usercheck=false;
												}break;
												case 4:{
													updateUserPassword(userdto.getMailid());
													updateuserprofilecheck=false;
													profileusertoy=false;
													usercheck1=false;
													usercheck=false;
												}break;
												case 5:{
													updateUserWallet(userdto.getMailid());
												}break;
												case 6:{
													System.out.println("===EXIT FROM UPDATE PROFILE===");
													updateuserprofilecheck=false;
												}break;
												default:System.out.println("Enter the Right Choice...!!!");
													break;
												}
											} while (updateuserprofilecheck);
										}break;
										case 3:{
											int r = deleteUserProfile(userdto.getMailid());
											if(r != 0) {
												profileusertoy=false;
												usercheck1=false;
												usercheck=false;
											}	
										}break;
										case 4:{
											System.out.println("===EXIT FROM USER PROFILE===");
											profileusertoy=false;
										}break;
										default:System.out.println("Enter the Right Choice...!!!");
											break;
										}
									} while (profileusertoy);
								}break;
								case 2:{
									System.out.println("TOY STORE OF USER FETCH ALL TOYS");
//									fetch all toys , add to cart,purchase,view your cart,exit
									boolean alltoyscheck=true;
									do {
										System.out.println("enter the choice \n 1.Display All Toys \n 2.Add to Cart \n 3.Purchase \n 4.View your Cart \n 5.Exit");
										int alltoykey=s.nextInt();
										switch (alltoykey) {
										case 1:{
											displayAllToys();
										}break;
										case 2:{
											System.out.println("===ADD TO CART===");
											ArrayList<ToyStoreDto> a = displayAllToys();
											int c = addToCart(a);
											if(c!=0) {
												addToCart(a);
											}else if(c==1) {
												addToCart(a);
											}else {	
											}
										}break;
										case 3:{
											System.out.println("purchase");
											purchaseItems(userdto.getMailid());
										}break;
										case 4:{
											System.out.println("view cart");
											viewCart();
										}break;
										case 5:{
											System.out.println("===EXIT FROM TOY STORE===");
											alltoyscheck=false;
										}break;
										default:System.out.println("Enter the Right Choice...!!!");
											break;
										}
									} while (alltoyscheck);
								}break;
								case 3:{
									System.out.println("===EXIT FROM PROFILE===");
									usercheck1=false;
								}break;
								default:System.out.println("Enter the Right Choice...!!!");
									break;
								}
							} while (usercheck1);
						}
					}break;
					case 3:{
						System.out.println("===EXIT USER===");
						usercheck=false;
					}break;
					default:System.out.println("Enter the Right Choice...!!!");
						break;
					}
				} while (usercheck);
			}break;
			case 3:{
				System.out.println("THANK YOU SIR PLEASE VISIT AGAIN 🙏🙏🙏");
				allcheck=false;
			}break;
			default:System.out.println("Enter the Right Choice...!!!");
				break;
			}
		} while (allcheck);
	}
	
	private static void viewCart() throws SQLException, IOException {
		AddToCartDao a=new AddToCartDao();
		ArrayList<AddToCartDto> b = a.fetchAllToysInCart();
		if(!b.isEmpty()) {
			System.out.println("__________________________________________________________________________________________________________");
			System.out.println("id         name         quantity         price");
			System.out.println("__________________________________________________________________________________________________________");
			for(AddToCartDto c:b) {
					System.out.println(c.getId()+"    "+c.getName()+"    "+c.getQuantity()+"    "+c.getPrice());
			}
			System.out.println("__________________________________________________________________________________________________________");
		}else {
			System.out.println("YOUR CART IS EMPTY PLEASE ADD PRODUCTS...!!!");
		}	
	}

	private static void purchaseItems(String mail) throws SQLException, IOException {
		AddToCartDao a=new AddToCartDao();
		ArrayList<AddToCartDto> al = a.fetchAllToysInCart();
		UserDao u=new UserDao();
		UserDto person = u.fetchUser(mail);
	if(!al.isEmpty()) {
		System.out.println("__________________________________________________________________________________________________________");
			System.out.println("id         name         quantity         price");
			System.out.println("__________________________________________________________________________________________________________");
			for( AddToCartDto css:al) {
				System.out.println(css.getId()+"    "+css.getName()+"    "+css.getQuantity()+"    "+css.getPrice());
			}
			System.out.println("__________________________________________________________________________________________________________");
			AddToCartDao ac=new AddToCartDao();
			long price = ac.fetchSumOfToysPrice();
			UserDao us=new UserDao();
			System.out.println("                            "+"TOTAL PRICE:-"+price);
			System.out.println("IF YOU WANT TO PAY TYPE {Y} OTHER WISE {N}");
			String pay=s.next();
			UserDto puser = us.fetchUser(mail);
			if(pay.equalsIgnoreCase("y")) {
//				return 1;
				if( puser.getWallet()>=price ) {
					System.out.println("yes");
					us.updateUserWallet(((puser.getWallet())-price), mail);
					ac.deleteAddToCartTable();
					System.out.println("THANK YOU  FOR PURCHASING YOU HAVE A NICE DAY "+puser.getName());
				}else {
					System.out.println("YOUR WALLET AMOUNT IS LOW...!!!");
					System.out.println("if you wanyto add type {y} other wise {n}");
					String check=s.next();
					if(check.equals("y")) {
						System.out.println("ADD AMOUNT IN YOUR WALLET");
						long addamount=s.nextLong();
						long add=addamount+puser.getWallet();
						us.updateUserWallet(add, mail);
						purchaseItems(mail);
					}else {
						System.out.println("YOU EXITED FROM PAYMENT");
					}
				}
			}else {
//				return 0;
				System.out.println("");
			}
		}else {
			System.out.println("ITEMS ARE NOT THERE IN YOUR CART PLEASE ADD ITEMS IN YOUR CART...!!!");
		}
	}

	private static int addToCart(ArrayList<ToyStoreDto> a) throws SQLException, IOException {
		System.out.print("ENTER THE ID TO ADD THE PRODUCT IN YOUR CART:-");
		int id=s.nextInt();
		System.out.print("ENTER THE QUANTITY TO ADD THE PRODUCT IN YOUR CART:-");
		long quantity=s.nextLong();
		AddToCartDao acd=new AddToCartDao();
		ToyDao tdao=new ToyDao();
		ToyStoreDto k = tdao.referenceForChangingWallet(id);
		if(k.getQuantity()>=quantity) {
		for(ToyStoreDto s:a) {
			if(k.getQuantity()>=quantity) {
				int q = tdao.changingQuantityGivenByCoustomer((k.getQuantity()-quantity), id);
			if(id==s.getId()) {
//				tdao.changingQuantityGivenByCoustomer((k.getQuantity()-quantity), id);	
				int sd = acd.saveCartDetails(s.getId(), s.getToyName(),quantity,(quantity*s.getPrice()));
				if(sd>=1) {
					System.out.println("YOU ADDED SOME PRODUCTS IN YOUR CART.....");
				}else {
					System.out.println("stock is not avilable");
				}
				}
			}
		}
		}else {
			System.out.println("stock is not avilable");
		}
		System.out.println("IF YOU WANT TO CONTINUE TYPE {Y} IF YOU DONT WANT IT THEN TYPE{N}");
		String conform=s.next();
		if(conform.equals("y")) {
			return 1;
		}else if(conform.equals("n")){
			return 0;
		}
		else {
			return 1;
		}
	}

	private static void updateUserWallet(String mailid) throws SQLException, IOException {
		System.out.print("ADD THE WALLET AMOUNT:-");
		long wallet=s.nextLong();
		UserDao u=new UserDao();
		int r = u.updateUserWallet(wallet, mailid);
		System.out.println("YOUR ADDED MONEY IN YOUR WALLET SUCESSFULLY...😍😍😍");
	}
	private static void updateUserPassword(String mailid) throws SQLException, IOException {
		System.out.print("ENTER THE NEW PASSWORD:-");
		String password=s.next();
		UserDao u=new UserDao();
		int r = u.updateUserpassword(password, mailid);
		System.out.println("YOUR PASSWORD IS CHANGED SUCESSFULLY...😊😊😊");
	}
	private static void updateUserMilid(String mailid) throws SQLException, IOException {
		System.out.print("ENTER THE NEW MAILID:-");
		String newmail=s.next();
		UserDao u=new UserDao();
		int r = u.updateUserMailid(newmail, mailid);
		System.out.println("YOUR MAILID IS CHANGED SUCESSFULLY...😊😊😊");
	}
	private static void updateUserPHONE(String mailid) throws SQLException, IOException {
		System.out.print("ENTER THE NEW PHONE NUMBER:-");
		long phone=s.nextLong();
		UserDao u=new UserDao();
		int r = u.updateUserPhoneNumber(phone, mailid);
		System.out.println("YOUR PHONE NUMBER IS CHANGED SUCESSFULLY...😊😊😊");
	}
	private static void updateUserName(String mailid) throws SQLException, IOException {
		System.out.print("ENTER THE NEW NAME:-");
		String name=s.next();
		UserDao u=new UserDao();
		int r = u.updateUserName(name, mailid);
		System.out.println("YOUR NAME IS CHANGED SUCESSFULLY...😊😊😊");
	}

	private static int deleteUserProfile(String mailid) throws SQLException, IOException {
		UserDao u=new UserDao();
		System.out.println("IF YOU WHAT TO DELETE YOUR ACCOUNT TYPE {Y} OTHER WISE {N}");
		String continueop=s.next();
		if(continueop.equals("y")) {
			int i = u.DeleteUserAccount(mailid);
			System.out.println("YOUR ACCOUNT IS DELETED SO PLEASE TRY WITH ANOTHER ACCOUNT OR REGISTER NEW ACCOUNT 😒😒😒");
			return 1;
		}else {
			System.out.println("YOU EXITED FROM DELETING OPERATION 😍😍😍");
			return 0;
		}		
	}

	private static ArrayList<ToyStoreDto> displayAllToys() throws SQLException, IOException {
		ToyDao tdao=new ToyDao();
		ArrayList<ToyStoreDto> all = tdao.fetchAllToys();
		System.out.println("_____________________________________________________________________________________________________________________________________");
		System.out.println("ID                   NAME                       PRICE                         QUANTITY                                        ");
		System.out.println("_____________________________________________________________________________________________________________________________________");
		for(ToyStoreDto  t:all) {
			System.out.println(t.getId()+"                      "+t.getToyName()+"                             "+t.getPrice()+"                     "+t.getQuantity());
		}
		System.out.println("_____________________________________________________________________________________________________________________________________");
		return all;
	}

	private static void toyQuantityUpdate(String email) throws SQLException, IOException {
		System.out.print("ENTER THE NEW QUANTITY OF TOY:-");
		int quantity=s.nextInt();
		System.out.print("ENTER THE ID FOR UPDATING THE PRICE:-");
		int id=s.nextInt();
		ToyDao tdao=new ToyDao();
		int u = tdao.toyQuantityUpdateinDB(quantity, id, email);
		if(u != -1) {
			if(u > 0) {
				System.out.println(u+" QUANTITY UPDATED SUCCESSFULLY...😍😍😍");
			}else {
				System.out.println("PLEASE CHECK THE ID PROPERLY...⚠️⚠️⚠️");
			}			
			}else {
			System.out.println("THERE IS NO ITEM EXIST IN THE DATABASE WITH THIS ID...⚠️⚠️⚠️");
		}	
	}

	private static void toyPriceUpdate(String email) throws SQLException, IOException  {
		System.out.print("ENTER THE NEW PRICE OF TOY:-");
		int newToyPrice=s.nextInt();
		System.out.print("ENTER THE ID FOR UPDATING THE PRICE:-");
		int id=s.nextInt();
		ToyDao tdao=new ToyDao();
		int u = tdao.toyPriceUpdateinDB(newToyPrice, id, email);
		if(u != -1) {
			if(u > 0) {
				System.out.println(u+" PRICE UPDATED SUCCESSFULLY...😍😍😍");
			}else {
				System.out.println("PLEASE CHECK THE ID PROPERLY...⚠️⚠️⚠️");
			}			
			}else {
			System.out.println("THERE IS NO ITEM EXIST IN THE DATABASE WITH THIS ID...⚠️⚠️⚠️");
		}	
	}

	private static void toyNameUpdate(String email) throws SQLException, IOException {
		System.out.print("ENTER THE NEW NAME OF TOY:-");
		String newToyName=s.next();
		System.out.print("ENTER THE ID FOR UPDATING THE NAME:-");
		int id=s.nextInt();
		ToyDao tdao=new ToyDao();
		int u=tdao.toynameUpdate(newToyName,id,email);
		if(u != -1) {
			if(u > 0) {
				System.out.println(u+" NAME UPDATED SUCCESSFULLY...😍😍😍");
			}else {
				System.out.println("PLEASE CHECK THE ID PROPERLY...⚠️⚠️⚠️");
			}
			}else {
			System.out.println("THERE IS NO ITEM EXIST IN THE DATABASE WITH THIS ID...⚠️⚠️⚠️");
		}	
	}

	private static void deleteAdmin(String email) throws SQLException, IOException {
		AdminDao a = new AdminDao();
		int r = a.deleteAdmindb(email);
		System.out.println("your have deleted your record so please login with another account...!!!");

	}

	private static void updateAdminPassword(String email) throws SQLException, IOException {
		System.out.print("Enter the new Password:");
		String password = s.next();
		AdminDao a = new AdminDao();
		int r = a.updateAdminPasswordDao(password, email);
		if (r != 0) {
			System.out.println("updated new password sucessfully...");
			System.out.println("Please Login with new password...!!!");
		} else {
			System.out.println("not updated");
		}
	}

	private static void updateAdminMail(String email) throws SQLException, IOException {
		System.out.print("Enter the new Mailid:");
		String newmail = s.next();
		AdminDao ao = new AdminDao();
		int r = ao.updateAdminEmail(newmail, email);
		if (r != 0) {
			System.out.println("updated mail sucessfully...");
			System.out.println("Please Login with new MAILID...!!!");
		} else {
			System.out.println("not updated");
		}
	}

	private static void updateAdminName(String email) throws SQLException, IOException {
		System.out.print("Enter the new Name for Updation:");
		String name = s.next();
		AdminDao ao = new AdminDao();
		int r = ao.updateAdminName(name, email);
		if (r != 0) {
			System.out.println("updated name sucessfully...");
		} else {
			System.out.println("not updated");
		}
	}

	private static void fetchToy(String email) throws SQLException, IOException {
		ToyDao t = new ToyDao();
		ArrayList<ToyStoreDto> fetchtoy = t.fetchToyDetails(email);
		System.out.println("_____________________________________________________________________________________________________________________________________");
		System.out.println("ID                   NAME                       PRICE                         QUANTITY                                        ");
		System.out.println("_____________________________________________________________________________________________________________________________________");
		for (ToyStoreDto td : fetchtoy) {
			System.out.println(td.getId()+"                    "+td.getToyName()+"                         "+td.getPrice()+"                             "+td.getQuantity());
		}
		System.out.println("_____________________________________________________________________________________________________________________________________");
	}

	private static void fetchUser(String mailid) throws SQLException, IOException {
		UserDao udao = new UserDao();
		UserDto f = udao.fetchUser(mailid);
		System.out.println("****************************************************");
		System.out.println("ID:-" + f.getId());
		System.out.println("NAME:-" + f.getName());
		System.out.println("PHONE NUMBER:-" + f.getPhone());
		System.out.println("MAILID:-" + f.getMailid());
		System.out.println("PASSWORD:-" + f.getPassword());
		System.out.println("WALLET:-" + f.getWallet());
		System.out.println("****************************************************");
	}

	private static void fetchAdmin(String email) throws SQLException, IOException {
		AdminDao adao = new AdminDao();
		AdminDto f = adao.fetchAdmin(email);
		if (f != null) {
			System.out.println("***************************************");
			System.out.println("ID:-" + f.getId());
			System.out.println("NAME:-" + f.getName());
			System.out.println("EMAIL:-" + f.getEmail());
			System.out.println("PASSWORD:-" + f.getPassword());
			System.out.println("***************************************");
		} else {
			System.out.println("mailid is incorret.....");
		}

	}

	private static UserDto loginUser() throws SQLException, IOException {
		System.out.print("enter the email:");
		String email = s.next();
		System.out.print("enter the password:");
		String password = s.next();
		UserDao udao = new UserDao();
		UserDto u = udao.fetchUser(email);
		if (u != null) {
			if (u.getPassword().equals(password)) {
				System.out.println("Login successful dear " + u.getName());
			} else {
				System.out.println("entered password is wrong......");
				loginUser();
			}
		} else {
			System.out.println("Entered email is wrong...!!!");
			loginUser();
		}
		return u;

	}

	private static AdminDto loginAdmin() throws SQLException, IOException {
		System.out.print("enter the email:");
		String email = s.next();
		System.out.print("enter the password:");
		String password = s.next();
		AdminDao adao = new AdminDao();
		AdminDto a = adao.fetchAdmin(email);
		if (a != null) {
			if (a.getPassword().equals(password)) {
				System.out.println("Login successful dear " + a.getName());
			} else {
				System.out.println("entered password is wrong......");
				loginAdmin();
				;
			}
		} else {
			System.out.println("Entered email is wrong...!!!");
			loginAdmin();
		}
		return a;
	}

	private static int saveToyDetails(String email) {
		ToyDao tdao = new ToyDao();
		int data = 0;
		System.out.print("enter the id:");
		int id = s.nextInt();
		System.out.print("enter the name:");
		String name = s.next();
		System.out.print("enter the price:");
		long price = s.nextLong();
		System.out.print("enter the quantity:");
		long quantity = s.nextLong();
		ToyStoreDto tdto = new ToyStoreDto(id, name, price, quantity, email);
		try {
			data = tdao.saveToyDetails(tdto);
			System.out.println("Toy details saved succesfully.......");
		} catch (SQLException e) {
			System.out.println("something is wrong");
			saveUser();
		} catch (IOException e) {
			System.out.println("something is wrong");
			saveUser();
		}
		return data;
	}

	private static int saveUser() {
		UserDao uda = new UserDao();
		int data = 0;
		System.out.print("enter the id:");
		int id = s.nextInt();
		System.out.print("enter the name:");
		String name = s.next();
		System.out.print("enter teh phone number:");
		long phone = s.nextLong();
		System.out.print("enter the email:");
		String email = s.next();
		System.out.print("enter the password:");
		String password = s.next();
		System.out.print("enter the wallet:");
		int wallet = s.nextInt();
		UserDto udto = new UserDto(id, name, phone, email, password, wallet);
		try {
			data = uda.saveUserDetails(udto);
			System.out.println("details saved succesfully.......");
		} catch (SQLException e) {
			System.out.println("something is wrong");
			saveUser();
		} catch (IOException e) {
			System.out.println("something is wrong");
			saveUser();
		}
		return data;

	}

	private static int saveAdmin() {
		AdminDao ada = new AdminDao();
		int data = 0;
		System.out.print("enter teh id:");
		int id = s.nextInt();
		System.out.print("enter the name:");
		String name = s.next();
		System.out.print("enter the email:");
		String email = s.next();
		System.out.print("enter the password:");
		String password = s.next();
		AdminDto adto = new AdminDto(id, name, email, password);
		try {
			data = ada.saveAdminDetails(adto);
			System.out.println("details saved succesfully.......");
		} catch (SQLException e) {
			System.out.println("something is wrong");
			saveAdmin();
		} catch (IOException e) {
			System.out.println("something is wrong");
			saveAdmin();
		}
		return data;

	}

}
