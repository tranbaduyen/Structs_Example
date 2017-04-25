package common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Date;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

public class Utilities  {

	public Utilities() {
		// TODO Auto-generated constructor stub
	}

	public String loadImage(String filePathDr, FormFile file) {

		File newFile = null;
		FileOutputStream outputStream = null;

		String path = "";
		String newFileName = "";
		try {

			// create the upload folder if not exists
			File folder = new File(filePathDr);
			if (!folder.exists()) {
				folder.mkdir();
			}

			String fileName = file.getFileName();
			System.out.println("file name1 " + fileName);

			if (!("").equals(file.getFileName())) {

				String[] arr = file.getFileName().split("\\.");

				newFileName = new Date().getTime() + "." + arr[arr.length - 1];
				System.out.println("newFileName  " + newFileName);

				newFile = new File(filePathDr, newFileName);

				if (!newFile.exists()) {
					FileOutputStream fos = new FileOutputStream(newFile);
					fos.write(file.getFileData());
					fos.flush();
					fos.close();
				}
			}

			path = "images/" + newFileName;

			System.out.println("url " + path);

		} catch (Exception e) {

			ActionErrors errors = new ActionErrors();
			errors.add("uploadedFile", new ActionMessage("errors.file.save", file.getFileName()));

			System.out.println("errors.file.save " + file.getFileName());
			System.out.println("size error " + errors.size());

		} finally {
			if (outputStream != null)
				try {
					outputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		return path;
	}

	/* format 20000f--> 20,000 */
	public static String priceWithDecimal(float price) {
		DecimalFormat formatter = new DecimalFormat("###,###,###");
		return formatter.format(price);
	}
}
