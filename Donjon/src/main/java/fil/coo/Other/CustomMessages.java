package fil.coo.Other;

public class CustomMessages {

	/**
	 * welcoming message
	 */
	public static void welcomeText(){
		System.out.println("  ____                                        ____                      \n" + 
				" |  _ \\ _   _ _ __   __ _  ___  ___  _ __    / ___| __ _ _ __ ___   ___ \n" + 
				" | | | | | | | '_ \\ / _` |/ _ \\/ _ \\| '_ \\  | |  _ / _` | '_ ` _ \\ / _ \\\n" + 
				" | |_| | |_| | | | | (_| |  __/ (_) | | | | | |_| | (_| | | | | | |  __/\n" + 
				" |____/ \\__,_|_| |_|\\__, |\\___|\\___/|_| |_|  \\____|\\__,_|_| |_| |_|\\___|\n" + 
				"                    |___/                                              ");
	}
	
	/**
	 * ended dungeon message
	 */
	public static void winText() {
		System.out.println("__  ______  __  __   _       _______   __   __\n" + 
				"\\ \\/ / __ \\/ / / /  | |     / /  _/ | / /  / /\n" + 
				" \\  / / / / / / /   | | /| / // //  |/ /  / / \n" + 
				" / / /_/ / /_/ /    | |/ |/ // // /|  /  /_/  \n" + 
				"/_/\\____/\\____/     |__/|__/___/_/ |_/  (_)  \n");
	}
	
	/**
	 * game over message
	 */
	public static void gameOverText() {
		System.out.println("Game Over");
	}
	
	
	
}
