package hust.soict.dsai.aims;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;
import java.util.Scanner;


public class Aims {

	public static void main (String[] args){
		Store store = new Store();
		Cart cart = new Cart();
		
		int user_option1;
		do {
			try {
				user_option1 = showMenu();
				switch (user_option1) {

					case 1: // View store
						int user_option2;
						System.out.println("1. View store"); 
						
						do {
						user_option2 = storeMenu();
						
						switch (user_option2) {

							case 1: // See a media's details
								int user_option3;
								System.out.print("Enter media's title: ");
								Scanner sc = new Scanner(System.in);
								String media_name = sc.nextLine();
								Media curr_media = store.detailsId(store.searchMedia(media_name));
								try{
									
									System.out.println(curr_media.toString());
								}
								catch (Exception e) {
									System.out.println("No matching found");
									user_option2 = 5;
									continue;
								}
									
									do {
										user_option3 = mediaDetailsMenu();
										switch(user_option3) {

											case 1: 
												cart.addMedia(curr_media);
												System.out.println("Add " + curr_media.toString());
												user_option3 = 5;
												break;
											case 2:
												System.out.println("2. Play"); 
												if (curr_media instanceof Disc) {
													Disc d = (Disc) curr_media;
													d.play();
												} else {
													System.out.println("Book is not playable");
												}
												user_option3 = 5;
												break;
											case 0:
												user_option2 = 5; // return to the 2nd menu
												break;
										}
									} while (user_option3 > 2); break;
								
									

							case 2: // Add a media to cart

								System.out.print("Which media you want to add (title): ");
								sc = new Scanner(System.in);
								media_name = sc.nextLine();
								curr_media = store.detailsId(store.searchMedia(media_name));
								try {
									System.out.println("Add media " + curr_media.toString());
									cart.addMedia(curr_media);
								}
								catch (Exception e) {
									System.out.println("No matching found");
								}
								user_option2 = 5;
								break;
								
							case 3: // Play a media
								System.out.print("Which media you want to play (title): ");
								sc = new Scanner(System.in);
								media_name = sc.nextLine();
								curr_media = store.detailsId(store.searchMedia(media_name));
								try {
									System.out.println("Chosen media is: " + curr_media.toString());
									if (curr_media instanceof Disc) {
										Disc d_ = (Disc) curr_media;
										d_.play();
										}
								}
								catch (Exception e) {
									System.out.println("No matching found");
								}
								user_option2 = 5; break;
							
							case 4: // See current cart
								cart.print();
								user_option2 = 5;
								break;
							case 0: // Back
								user_option1 = 5; // return to the 1st menu
								break;
								
							}
						} while (user_option2 > 4); continue;

					case 2: // Update store
						System.out.println("1. Add media");
						System.out.println("2. Remove media");
						Scanner sc = new Scanner(System.in);
						int user_option4 = sc.nextInt();
						switch (user_option4) {
							case 1: // Add Media
								System.out.print("[Media] [Id] [Title]: \n");
								System.out.println("Available Media: Book, DVD, CD");
								System.out.println("(E.g, DVD 1 abc)");
								sc = new Scanner(System.in);
								String[] tokens = sc.nextLine().split(" ");
								String media_type = tokens[0];
								Integer id = Integer.parseInt(tokens[1]);
								String title = tokens[2];
								boolean done;

								switch(media_type) {
									case "Book":
										done = store.addMedia(new Book(id, title));
										System.out.println(done);
										break;
									case "DVD":
										DigitalVideoDisc dvd = new DigitalVideoDisc(id, title);
										done = store.addMedia(dvd);
										System.out.println(dvd.getTitle());
										System.out.println(done);
										break;
									case "CD":
										done = store.addMedia(new CompactDisc(id, title));
										System.out.println(done);
										break;
									default:
										System.out.println("Wrong form of addition");
										break;
								} user_option1 = 5; break; // return to the main menu
							case 2: // Remove Media
								System.out.println("Enter media type and title:");
								System.out.println("E.g, Book ABC");
								sc = new Scanner (System.in);
								tokens = sc.nextLine().split(" ");
								media_type = tokens[0];
								title = tokens[1];

								switch (media_type) {
									case "Book": 
										done = store.removeMedia(new Book (title));
										System.out.println(done);
										break;
									case "DVD":
										done = store.removeMedia(new DigitalVideoDisc(title));
										System.out.println(done);
										break;
									case "CD":
										done = store.removeMedia(new CompactDisc(title));
										System.out.println(done);
										break;
								} user_option1 = 5; break; // return to the main menu
								
							} break; 
						
					case 3: // See current cart
						
						do {
							user_option4 = cartMenu();
							switch (user_option4) { // Filter medias in cart
								case 1: 
									sc = new Scanner(System.in);
									System.out.println("1. Filter by Id");
									System.out.println("2. Filter by Title");
									int choice = sc.nextInt();
									switch (choice) {
										case 1:
											System.out.println("Please enter the media id");
											try {
												int id = sc.nextInt();
												System.out.println(cart.searchID(id).toString());
											} catch (Exception e) {
												System.out.println("No matching found");
											} break;

										case 2:
											System.out.println("Please enter the media title");
											sc = new Scanner (System.in);
											String title = sc.nextLine();
											try {
												System.out.println(cart.searchTitle(title).toString());
											} catch (Exception e) {
												System.out.println("No matching found");
											}
											break;
									} user_option4 = 6; break;
									
									case 2: // Sort medias in cart
										sc = new Scanner(System.in);
										System.out.println("1. Sort by cost");
										System.out.println("2. Sort by title");
										choice = sc.nextInt();
										switch (choice){
											case 1:
												System.out.println("Sort by cost");
												cart.sortCostTitle();
											case 2:
												System.out.println("Sort by title");
												cart.sortTitleCost();
										} user_option4 = 6; break;

									case 3: // Remove media from cart
										System.out.println("Enter media type and title:");
										System.out.println("E.g, Book ABC");
										sc = new Scanner (System.in);
										String[] tokens = sc.nextLine().split(" ");
										String media_type = tokens[0];
										String title = tokens[1];
										boolean done;

										switch (media_type) {
											case "Book": 
												done = store.removeMedia(new Book (title));
												System.out.println(done);
												break;
											case "DVD":
												done = store.removeMedia(new DigitalVideoDisc(title));
												System.out.println(done);
												break;
											case "CD":
												done = store.removeMedia(new CompactDisc(title));
												System.out.println(done);
												break;
										} user_option4 = 6; break; // return to the main menu
																	
									case 4: // Play a media
										System.out.print("Which media you want to play (title): ");
										sc = new Scanner(System.in);
										String media_name = sc.nextLine();
										Media curr_media = cart.searchTitle(media_name);
										try {
											System.out.println("Chosen media is: " + curr_media.toString());
											if (curr_media instanceof Disc) {
												Disc d_ = (Disc) curr_media;
												d_.play();
												}
										}
										catch (Exception e) {
											System.out.println("No matching found");
										} user_option4 = 6; break;
										
									case 5: // Place order
										System.out.println("The order is created !");
										cart = new Cart();
										user_option1 = 5; break;
									case 0: // Back
										user_option1 = 5; break;
								}
							} while (user_option4 > 5);	user_option1 = 5;		
						
					case 0: // Exit
						System.out.println("Exited");
						break;
				}
			} catch(Exception e) {
				System.out.println("Please enter the acceptable input");
				user_option1 = 5;
			}
		} while (user_option1 > 4);

	}
	

	public static int showMenu() {

		int selection;
		Scanner sc = new Scanner(System.in);

		System.out.println("AIMS: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. View store"); 
		System.out.println("2. Update store"); 
		System.out.println("3. See current cart"); 
		System.out.println("0. Exit"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3"); 

		selection = sc.nextInt();
		return selection;
	}

	public static int storeMenu() { 
		int selection;
		System.out.println("Options: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. See a media’s details"); 
		System.out.println("2. Add a media to cart"); 
		System.out.println("3. Play a media"); 
		System.out.println("4. See current cart"); 
		System.out.println("0. Back"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3-4"); 
		
		Scanner sc = new Scanner(System.in);
		selection = sc.nextInt();
		return selection;
	} 

	public static int mediaDetailsMenu() { 
		int selection;
		System.out.println("Options: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. Add to cart"); 
		System.out.println("2. Play"); 
		System.out.println("0. Back"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2"); 

		Scanner sc = new Scanner(System.in);
		selection = sc.nextInt();
		return selection;
	} 

	public static int cartMenu() {
		int selection;
		System.out.println("Option: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2"); 

		Scanner sc = new Scanner (System. in);
		selection = sc.nextInt();
		return selection;
	}
	
}
