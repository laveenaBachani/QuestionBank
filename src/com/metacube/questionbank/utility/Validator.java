/**
 * 
 */
package com.metacube.questionbank.utility;

/**
 * @author Admin39
 *
 */

	import java.util.ArrayList;
	import java.util.List;
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;

	import org.springframework.web.multipart.MultipartFile;


	/*
	 * @author Ankit
	 */
	public class Validator {
	
		static Pattern pattern;
		static Matcher matcher;

		public static boolean checkImage(MultipartFile image)
		{
			if(image.getSize()==0)
			{
				return false;	
			}
			else
			{

				String filename=image.getOriginalFilename();
				if(filename.contains(".png") || filename.contains(".gif") || filename.contains(".jpeg") || filename.contains(".bmp") ||  filename.contains(".jpg") )
				{

					return true;
				}
				else
				{
					System.out.println("Wrong extension");
					return false;
				}
			}
		}

		/**
		 * this function validate the email
		 * @param Email
		 * @return boolean
		 */
		public static boolean Email(String Email){
			String emailpattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

			Pattern pattern1 = Pattern.compile(emailpattern);

			Matcher matcher1= pattern1.matcher(Email);

			if(matcher1.matches()){

				return true;
			}
			else{

				return false;
			}

		}
		/*
		 * checking if password is of valid syntax
		 * @method checkPassword
		 * @param  password
		 */
		private static  boolean checkPasswordpatten(String password)
		{
			final String passwordpattern="(?=^.{8,}$)((?=.* \\d)|(?=.*\\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$";

			if(!password.matches(passwordpattern))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		/*
		 * checking if user information is not empty
		 * @method checkEmpty
		 * @param  userData
		 */
		public static  boolean checkEmpty(String userData)
		{
			boolean flag;
			if(userData==null || userData.isEmpty())
			{
				flag=false;
			}
			else
			{
				flag=true;
			}
			return flag;
		}

		/*
		 * Checking if data entered by user is valid
		 * @method validData
		 * @param Users object
		 */
		
	

}
