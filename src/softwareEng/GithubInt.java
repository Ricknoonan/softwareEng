package softwareEng;

import java.net.URL;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class GithubInt {
	
	public static void main(String[] args) throws Exception{
				Scanner scanner = new Scanner(System.in);
				System.out.println("What is your GitHub Username?");
				String username = scanner.next();
				System.out.println("What repo do you want?");
				String repo = scanner.next();
				HttpURLConnection httpcon = (HttpURLConnection) new URL("https://api.github.com/repos/" 
					+ username + "/" + repo).openConnection();														
				scanner.close();
				
				httpcon.addRequestProperty("User-Agent", "Chrome");
				BufferedReader in = new BufferedReader(new InputStreamReader(httpcon.getInputStream()));
				
				StringBuilder responseSB = new StringBuilder();
				String line;
				while (( line = in.readLine()) != null) {
					responseSB.append("\n" + line);
					System.out.println(line);
				}
				in.close();	
	}	
}
